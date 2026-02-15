package oop_001_suryanandadestiawan.week2

class Hero(
    val name: String,
    val baseDamage: Int,
    var hp: Int = 100   // Default Argument
) {

    fun attack(targetName: String) {
        println("$name menebas $targetName!")
    }

    fun takeDamage(damage: Int) {
        hp -= damage

        if (hp < 0) {
            hp = 0
        }
    }

    fun isAlive(): Boolean {
        return hp > 0
    }

}
