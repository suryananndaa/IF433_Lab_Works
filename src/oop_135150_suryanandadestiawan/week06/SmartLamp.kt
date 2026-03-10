package oop_001_suryanandadestiawan.week06

// SmartLamp.kt

class SmartLamp(
    override val id: String,
    override val name: String
) : SmartDevice, Switchable {

    override fun turnOn() {
        println("💡 $name menyala! Ruangan kini terang.")
    }

    override fun turnOff() {
        println("🌙 $name dimatikan. Selamat beristirahat!")
    }
}