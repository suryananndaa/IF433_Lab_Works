package oop_001_suryanandadestiawan.week2

import java.util.Scanner

fun main() {

    val scanner = Scanner(System.`in`)

    println("=== MINI RPG BATTLE ===")

    // 1. Input Hero
    print("Masukkan Nama Hero: ")
    val heroName = scanner.nextLine()

    print("Masukkan Base Damage Hero: ")
    val heroDamage = scanner.nextInt()

    val hero = Hero(heroName, heroDamage)

    // 2. Enemy sebagai variabel
    var enemyHp = 100

    // 3. Main Loop
    while (hero.isAlive() && enemyHp > 0) {

        println("\n--- MENU ---")
        println("1. Serang")
        println("2. Kabur")
        print("Pilih: ")

        val choice = scanner.nextInt()

        if (choice == 1) {

            // Hero menyerang
            hero.attack("Enemy")
            enemyHp -= hero.baseDamage

            if (enemyHp < 0) {
                enemyHp = 0
            }

            println("HP Enemy sekarang: $enemyHp")

            // Enemy membalas jika masih hidup
            if (enemyHp > 0) {

                val enemyDamage = (10..20).random()
                println("Enemy menyerang balik! Damage: $enemyDamage")

                hero.takeDamage(enemyDamage)
                println("HP ${hero.name} sekarang: ${hero.hp}")
            }

        } else if (choice == 2) {

            println("${hero.name} kabur dari pertarungan!")
            break

        } else {

            println("Pilihan tidak valid!")
        }
    }

    // 4. Hasil Akhir
    println("\n=== HASIL PERTARUNGAN ===")

    if (hero.isAlive() && enemyHp <= 0) {
        println("${hero.name} MENANG!")
    } else if (!hero.isAlive() && enemyHp > 0) {
        println("Enemy MENANG!")
    } else {
        println("Pertarungan dihentikan.")
    }

}


