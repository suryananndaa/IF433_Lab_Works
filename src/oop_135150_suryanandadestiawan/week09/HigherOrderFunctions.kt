package oop_135150_suryanandadestiawan.week09

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8)
    println("Original Data: $numbers")

    println("\n=== HOF: FILTER ===")
    // filter() membuat list baru berisi elemen yang memenuhi kondisi (true)
    val evens = numbers.filter { it % 2 == 0 }
    println("Evens only: $evens")

    println("\n=== HOF: MAP ===")
    // map() merubah bentuk/nilai data, tapi ukurannya tetap sama
    val multiplied = evens.map { it * 10 }
    val asStrings = multiplied.map { "Rp ${it}k" }
    println("Multiplied: $multiplied")
    println("Formatted: $asStrings")
}
