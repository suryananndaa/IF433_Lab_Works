package oop_135150_suryanandadestiawan.week11

fun main() {
    val homeDevices = mutableListOf<SmartDevice>()

    // Konfigurasi Pencahayaan menggunakan apply + also
    SmartDevice("Philips WiZ Living Room", "Lighting").apply {
        isOnline = true
        powerLoad = 12
    }.also {
        homeDevices.add(it)
    }
}
