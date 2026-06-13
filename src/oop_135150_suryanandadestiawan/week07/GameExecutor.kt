package oop_135150_suryanandadestiawan.week07

fun processEvent(event: BattleState) {
    when (event) {
        is BattleState.MonsterEncounter -> {
            println("⚔️  Monster muncul: ${event.monsterName}! Bersiaplah untuk bertarung!")
        }
        is BattleState.LootDropped -> {
            println("🎁 Item jatuh: ${event.item.name} | Damage: ${event.item.damage} | Rarity: ${event.item.rarity} (drop chance: ${event.item.rarity.dropChance}%)")
        }
        is BattleState.GameOver -> {
            println("💀 Game Over! Alasan: ${event.reason}")
        }
        is BattleState.SafeZone -> {
            println("🛡️  Kamu berada di Safe Zone. Tidak ada ancaman.")
        }
    }
}
