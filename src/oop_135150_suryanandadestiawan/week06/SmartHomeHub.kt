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
                device.turnOff()
            }
        }
    }

    fun activateSecurityMode() {
        println("\n MODE KEAMANAN DIAKTIFKAN!")
        for (device in devices) {
            if (device is Recordable) {
                device.startRecord() // Smart Cast: otomatis jadi Recordable
            }
            if (device is SmartSpeaker) {
                device.playMusic("Sirine Peringatan") // Smart Cast: otomatis jadi SmartSpeaker
            }
        }
    }
}