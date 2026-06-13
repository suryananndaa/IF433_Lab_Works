package oop_135150_suryanandadestiawan.week07

class Weapon private constructor(val item: GameItem, val durability: Int) {

    companion object {
        fun forgeStarterSword(): Weapon {
            val item = GameItem("Pedang Kayu Bapuk", damage = 5, rarity = ItemRarity.COMMON)
            println("Menempa senjata: ${item.name} (${item.rarity})")
            return Weapon(item, durability = 50)
        }

        fun forgeEpicSword(): Weapon {
            val item = GameItem("Pedang Api Abadi", damage = 150, rarity = ItemRarity.EPIC)
            println("Menempa senjata: ${item.name} (${item.rarity})")
            return Weapon(item, durability = 200)
        }
    }

    override fun toString(): String {
        return "Weapon(name=${item.name}, damage=${item.damage}, rarity=${item.rarity}, durability=$durability)"
    }
}
