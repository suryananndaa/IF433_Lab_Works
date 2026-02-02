package oop_001_suryanandadestiawan.week01

fun main() {
    val gameTitle = "Cyber Adventure 2077"
    val price = 650000
}

fun calculateDiscount(price: Int) =
    if (price > 500000) price * 80 / 100
    else price * 90 / 100
