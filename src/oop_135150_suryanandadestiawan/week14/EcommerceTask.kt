package oop_135150_suryanandadestiawan.week14

import java.io.File

class BadOrderProcessor {
    // VIOLATION: Hardcoded File I/O (DIP), Melakukan kalkulasi + I/O + Notifikasi sekaligus (SRP)
    private val file = File("orders.csv")

    fun processOrder(itemName: String, basePrice: Double, customerType: String) {

        // VIOLATION: Kaku jika ada tipe customer/diskon baru di masa depan (OCP)
        val finalPrice = when (customerType) {
            "REGULAR" -> basePrice
            "VIP"     -> basePrice * 0.90 // Diskon 10%
            else      -> basePrice
        }

        println("Memproses pesanan $itemName seharga $finalPrice")

        // VIOLATION SRP/DIP: Menulis file langsung di class bisnis
        file.appendText("$itemName,$finalPrice,$customerType\n")

        // VIOLATION SRP/DIP: Notifikasi terikat kuat dengan sistem order
        println("Email terkirim: Pesanan $itemName Anda telah dikonfirmasi!")
    }
}

// ============================================================
// REFACTORED: Fix SRP & DIP
// ============================================================

// Abstraksi penyimpanan order (SRP + DIP)
interface OrderRepository {
    fun saveOrder(itemName: String, finalPrice: Double, customerType: String)
}

// Implementasi CSV menggunakan safe resource handling
class CsvOrderRepository(private val filePath: String) : OrderRepository {
    override fun saveOrder(itemName: String, finalPrice: Double, customerType: String) {
        File(filePath).appendText("$itemName,$finalPrice,$customerType\n")
        println("Order tersimpan ke $filePath")
    }
}

// Abstraksi notifikasi (SRP + DIP)
interface NotificationService {
    fun sendNotification(message: String)
}

// Implementasi email notifier
class EmailNotifier : NotificationService {
    override fun sendNotification(message: String) {
        println("Email terkirim: $message")
    }
}

// SafeOrderProcessor menerima abstraksi melalui constructor injection (DIP)
class SafeOrderProcessor(
    val repo: OrderRepository,
    val notifier: NotificationService
) {
    fun processOrder(itemName: String, basePrice: Double, customerType: String) {
        val finalPrice = when (customerType) {
            "REGULAR" -> basePrice
            "VIP"     -> basePrice * 0.90
            else      -> basePrice
        }
        println("Memproses pesanan $itemName seharga $finalPrice")
        repo.saveOrder(itemName, finalPrice, customerType)
        notifier.sendNotification("Pesanan $itemName Anda telah dikonfirmasi!")
    }
}

// ============================================================
// REFACTORED: Fix OCP — PricingStrategy
// ============================================================

// Abstraksi kalkulasi harga (OCP)
interface PricingStrategy {
    fun calculate(price: Double): Double
}

class RegularPricing : PricingStrategy {
    override fun calculate(price: Double): Double = price
}

class VipPricing : PricingStrategy {
    override fun calculate(price: Double): Double = price * 0.90 // Diskon 10%
}

// OrderProcessor final: menerima PricingStrategy — blok when dihapus
class FinalOrderProcessor(
    val repo: OrderRepository,
    val notifier: NotificationService,
    val pricing: PricingStrategy
) {
    fun processOrder(itemName: String, basePrice: Double) {
        val finalPrice = pricing.calculate(basePrice)
        println("Memproses pesanan $itemName seharga $finalPrice")
        repo.saveOrder(itemName, finalPrice, "")
        notifier.sendNotification("Pesanan $itemName Anda telah dikonfirmasi!")
    }
}

fun main() {
    val repo     = CsvOrderRepository("orders.csv")
    val notifier = EmailNotifier()

    // Menggunakan SafeOrderProcessor (SRP + DIP fix)
    val safeProcessor = SafeOrderProcessor(repo, notifier)
    safeProcessor.processOrder("Laptop", 15000000.0, "VIP")

    // Menggunakan FinalOrderProcessor (SRP + DIP + OCP fix)
    val vipProcessor = FinalOrderProcessor(repo, notifier, VipPricing())
    vipProcessor.processOrder("Headphone", 500000.0)

    val regularProcessor = FinalOrderProcessor(repo, notifier, RegularPricing())
    regularProcessor.processOrder("Mouse", 200000.0)
}
