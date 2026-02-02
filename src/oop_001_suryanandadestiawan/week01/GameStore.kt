package oop_001_suryanandadestiawan.week01

fun main() {
    val gameTitle = "Cyber Adventure 2077"
    val price = 650000

    val finalPrice = calculateDiscount(price = price)

    printReceipt(title = gameTitle, finalPrice = finalPrice)
}

fun calculateDiscount(price: Int) =
    if (price > 500000) price * 80 / 100
    else price * 90 / 100

fun printReceipt(title: String, finalPrice: Int) {
    println("Game Title     : $title")
    println("Final Price    : Rp $finalPrice")
}

