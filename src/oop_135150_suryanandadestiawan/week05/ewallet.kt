package oop_001_suryanandadestiawan.week05

class EWallet(
    accountName: String,
    var balance: Double
) : PaymentMethod(accountName) {

    override fun processPayment(amount: Double) {
        if (balance >= amount) {
            balance -= amount
            println("Pembayaran sebesar $amount berhasil. Sisa saldo: $balance")
        } else {
            println("Saldo tidak cukup")
        }
    }

    // Fungsi spesifik E-Wallet
    fun topUp(amount: Double) {
        balance += amount
        println("Top up sebesar $amount berhasil. Saldo sekarang: $balance")
    }
}