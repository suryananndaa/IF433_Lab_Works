package oop_001_suryanandadestiawan.week05

fun main() {

    val dosen1 = Dosen(nama = "Pak Alex", nidn = "0123456")
    val admin1 = Admin(nama = "Bu Siti")

    // Polymorphic Collection: List yang berisi tipe Parent, tapi isinya objek Anak
    val daftarPegawai: List<Pegawai> = listOf(dosen1, admin1)

    println("=== AKTIVITAS PEGAWAI ===")
    for (pegawai in daftarPegawai) {

        // Pemanggilan Runtime Polymorphism
        pegawai.bekerja()

        // Smart Casting dengan is dan when
        when (pegawai) {
            is Dosen -> {
                println("=> Terdeteksi sebagai Dosen (NIDN: ${pegawai.nidn})")
                pegawai.mengajar()
            }

            is Admin -> {
                println("=> Terdeteksi sebagai Admin")
                pegawai.doAdminWork()
            }
        }

        println("------------------------")
    }

    println("=== TEST MATH HELPER ===")

    val mathHelper = MathHelper()

    println("Luas Persegi (sisi = 4): ${mathHelper.hitungLuas(4)}")
    println("Luas Persegi Panjang (5 x 3): ${mathHelper.hitungLuas(5, 3)}")
    println("Luas Lingkaran (r = 7.0): ${mathHelper.hitungLuas(7.0)}")
}