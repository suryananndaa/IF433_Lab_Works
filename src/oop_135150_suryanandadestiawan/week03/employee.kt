package oop_001_suryanandadestiawan.week03

class Employee(val name: String) {

    // Encapsulation untuk salary
    var salary: Int = 0
        set(value) {
            if (value < 0) {
                println("ERROR: Gaji tidak boleh negatif! Di-set ke 0.")
                field = 0
            } else {
                field = value
            }
        }

    // Hanya bisa diakses di dalam class
    private var performanceRating: Int = 3

    // Function public untuk menaikkan rating
    fun increasePerformance() {
        performanceRating++
        println("Kinerja $name meningkat! Rating: $performanceRating")
    }

    // Function untuk melihat status karyawan
    fun printStatus() {
        println("Karyawan: $name, Gaji: $salary, Rating: $performanceRating")
    }
}
