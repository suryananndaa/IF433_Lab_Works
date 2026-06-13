package oop_135150_suryanandadestiawan.week10

fun main() {
    val coinRepo = WalletRepository<Coin>()

    // Mengisi dompet dengan koin
    coinRepo.add(Coin("BTC", 0.5))
    coinRepo.add(Coin("ETH", 3.2))
    coinRepo.add(Coin("USDT", 1500.0))

    // Bungkus data dalam ApiResponse generic
    val response = ApiResponse("200 OK", coinRepo.getAll())
}
