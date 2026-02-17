package oop_001_suryanandadestiawan.week03

fun main() {
    val e = Employee("Budi")

    //tes validasi
    e.salary = -1000 //harusnya print error
    e.salary = 5000000
    println("Gaji: ${e.salary}")
    // test encapsulation
    e.increasePerformance()
    //tes computed property
    println("Pajak yang harus dibayar: ${e.tax}")
}