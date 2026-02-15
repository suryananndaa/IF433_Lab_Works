package oop_001_suryanandadestiawan.week2

class Student(
    val name: String,
    val nim: String,
    var major: String,
    var gpa: Double = 0.0   // Default Argument
) {

    init {
        // Validasi Sederhana: Cek panjang NIM
        if (nim.length != 5) {
            println("WARNING: Objek tercipta dengan NIM ($nim) yang tidak valid!")
            println("Data mahasiswa $name mungkin akan bermasalah di sistem.")
        } else {
            println("LOG: Objek Student $name berhasil dialokasikan di Memory.")
        }
    }

    // Secondary Constructor
    // Sekarang otomatis memakai gpa = 0.0
    constructor(name: String, nim: String) :
            this(name, nim, "Non-Matriculated")

}
