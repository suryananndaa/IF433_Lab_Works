package oop_001_suryanandadestiawan.week06

// SmartSpeaker.kt

class SmartSpeaker(
    override val id: String,
    override val name: String
) : SmartDevice, Switchable {

    override fun turnOn() {
        println(" $name menyala! Siap memutar musik.")
    }

    override fun turnOff() {
        println(" $name dimatikan. Sampai jumpa!")
    }

    fun playMusic(song: String) {
        println(" Memutar lagu $song dari Spotify.")
    }
}