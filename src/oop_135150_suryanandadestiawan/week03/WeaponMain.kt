package oop_001_suryanandadestiawan.week03

fun main() {

    val weapon = Weapon("Shadow Blade")

    // Coba set damage ke -50 (harus gagal)
    weapon.damage = -50

    // Coba set damage ke 9999 (harus jadi 1000)
    weapon.damage = 9999

    // Print tier
    println("Weapon: ${weapon.name}")
    println("Damage: ${weapon.damage}")
    println("Tier: ${weapon.tier}")
}
