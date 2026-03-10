package oop_001_suryanandadestiawan.week06

// SmartCCTV.kt

class SmartCCTV(
    override val id: String,
    override val name: String
) : SmartDevice, Switchable, Recordable {

    override fun turnOn() {
        println(" $name menyala! Memulai pemantauan area.")
        startRecord()
    }

    override fun turnOff() {
        println(" $name dimatikan. Pemantauan dihentikan.")
        stopRecord()
    }

    override fun startRecord() {
        println(" $name mulai merekam...")
    }
}