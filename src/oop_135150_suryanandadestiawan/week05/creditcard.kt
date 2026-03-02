package oop_001_suryanandadestiawan.week05

class CreditCard(
    accountName: String,
    val limit: Double
) : PaymentMethod(accountName) {

    var usedAmount: Double = 0.0

    override fun processPayment(amount: Double) {
        if (usedAmount + amount <= limit) {
            usedAmount += amount
            println("Pembayaran sebesar $amount berhasil. Total terpakai: $usedAmount")
        } else {
            println("Transaksi ditolak. Melebihi limit kartu.")
        }
    }
}