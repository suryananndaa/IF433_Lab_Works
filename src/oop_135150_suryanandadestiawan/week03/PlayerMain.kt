package oop_001_suryanandadestiawan.week03

fun main() {

    val player = Player("Surya")

    // Coba akses xp langsung (HARUS ERROR)
    // println(player.xp)

    player.addXp(50)   // masih level 1
    println("Level sekarang: ${player.level}")

    player.addXp(60)   // total 110 -> level up
    println("Level sekarang: ${player.level}")
}
