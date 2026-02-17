package oop_001_suryanandadestiawan.week03

class Employee(val name: String) {
    var salary: Int = 0
        set(value) {
            println("Mencoba set gaji ke: $value")
            //Kode di bawah ini sangat berbahaya
            this.salary = value
        }
}


