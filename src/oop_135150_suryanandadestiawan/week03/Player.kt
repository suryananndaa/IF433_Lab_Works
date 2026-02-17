package oop_001_suryanandadestiawan.week03

class Player(val username: String) {

    // Hanya bisa diakses di dalam class
    private var xp: Int = 0

    // Computed Property
    val level: Int
        get() = (xp / 100) + 1

    fun addXp(amount: Int) {
        if (amount <= 0) {
            println("XP harus berupa angka positif!")
            return
        }

        val oldLevel = level   // simpan level sebelum XP bertambah
        xp += amount
        val newLevel = level   // level setelah XP bertambah

        if (newLevel > oldLevel) {
            println("Level Up! Selamat $username naik ke level $level")
        }
    }
}


