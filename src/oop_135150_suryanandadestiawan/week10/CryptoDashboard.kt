package oop_135150_suryanandadestiawan.week10

fun main() {
    val coinRepo = WalletRepository<Coin>()

    // Mengisi dompet dengan koin
    coinRepo.add(Coin("BTC", 0.5))
    coinRepo.add(Coin("ETH", 3.2))
    coinRepo.add(Coin("USDT", 1500.0))

    // Bungkus data dalam ApiResponse generic
    val response = ApiResponse("200 OK", coinRepo.getAll())

    // Tampilkan dashboard
    println("=== CRYPTO WALLET DASHBOARD ===")
    println("API Status: ${response.status}")
    println("\n--- COIN PORTFOLIO ---")
    response.data.forEach { coin ->
        println("Coin: ${coin.name} | Balance: ${coin.balance}")
    }

    // Transaction Repository
    val txRepo = WalletRepository<Transaction>()
    txRepo.add(Transaction("TRX-001", 250.0))
    txRepo.add(Transaction("TRX-002", -50.0))
    txRepo.add(Transaction("TRX-003", 1000.0))

    println("\n--- TRANSACTION HISTORY ---")
    txRepo.getAll().forEach { tx ->
        println("ID: ${tx.id} | Amount: ${tx.amount}")
    }
}
