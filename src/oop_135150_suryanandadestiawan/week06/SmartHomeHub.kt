package oop_001_suryanandadestiawan.week06

// SmartHomeHub.kt

class SmartHomeHub {
    val devices = mutableListOf<SmartDevice>()

    fun addDevice(device: SmartDevice) {
        devices.add(device)
        println(" ${device.name} berhasil ditambahkan ke Hub.")
    }

    fun turnOffAllSwitches() {
        println("\n Mematikan semua perangkat Switchable...")
        for (device in devices) {
            if (device is Switchable) {
                device.turnOff() // Smart Cast: otomatis jadi Switchable di sini
            }
        }
    }
}