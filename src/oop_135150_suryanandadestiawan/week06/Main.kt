package oop_001_suryanandadestiawan.week06

// Fungsi ini Decoupled! Tidak peduli kelas aslinya apa.
fun processCheckout(method: PaymentMethod, amount: Double) {
    println("-> Memulai checkout...")
    method.pay(amount) // Dynamic polymorphism in action
}

fun main() {
    val myWatch = Smartwatch()
    myWatch.showTime()

    val myPhone = Smartphone()
    myPhone.turnOn()

    val pay1 = Gopay()
    val pay2 = CreditCard()

    println("\n=== TESTING CHECKOUT ===")
    processCheckout(method = pay1, amount = 50000.0)
    processCheckout(method = pay2, amount = 150000.0)

    // TESTING SMART HOME
    println("\n=== TESTING SMART HOME ===")

    // Instansiasi perangkat
    val lamp = SmartLamp(id = "SL-01", name = "Lampu Ruang Tamu")
    val speaker = SmartSpeaker(id = "SS-01", name = "Google Nest Dapur")
    val cctv = SmartCCTV(id = "SC-01", name = "Ezviz Garasi")

    // Daftarkan ke Hub
    val hub = SmartHomeHub()
    hub.addDevice(lamp)
    hub.addDevice(speaker)
    hub.addDevice(cctv)

    // Test nyalakan semua manual
    println("\n--- Menyalakan Semua Perangkat ---")
    lamp.turnOn()
    speaker.turnOn()
    speaker.playMusic("Morning Vibes")
    cctv.turnOn()

    // Test Hub: matikan semua
    hub.turnOffAllSwitches()

    // Test Hub: mode keamanan
    hub.activateSecurityMode()
}