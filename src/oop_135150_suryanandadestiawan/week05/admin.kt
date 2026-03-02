package oop_001_suryanandadestiawan.week05

class Admin(nama: String) : Pegawai(nama) {

    override fun bekerja() {
        println("[$nama] sedang duduk di depan komputer melayani administrasi.")
    }

    // Fungsi unik/spesifik yang hanya dimiliki Admin
    fun doAdminWork() {
        println("[$nama] sedang merekap data absensi mahasiswa.")
    }
}