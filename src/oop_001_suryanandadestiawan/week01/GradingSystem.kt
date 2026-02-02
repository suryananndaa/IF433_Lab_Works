package oop_001_suryanandadestiawan.week01

fun main() {
    // refactor : gunakan val dan hapus tipe data eksplisit
    val name = "Surya Nanda"
    val score = 80

    // refactor: string template ($name)
    println("Nama: $name, Nilai: $score")

    val grade = when (score) {
        in 90..100 -> "A"
        in 80..89 -> "B"
        in 70..79 -> "C"
        else -> "D"
    }
    println("Grade kamu: $grade")

    println("status: ${calculateStatus(score)}")
}

fun calculateStatus(score: Int) = if (score > 75) "Lulus" else "Tidak lulus"