package oop_135150_suryanandadestiawan.week09

fun main() {
    val tradeHistory = listOf(
        TradeLog("BTCUSDT", "LONG",  20,  15.5,  "CLOSED"), // WIN
        TradeLog("ETHUSDT", "SHORT", 10,  -5.2,  "CLOSED"), // LOSS
        TradeLog("BTCUSDT", "SHORT", 15,   8.3,  "CLOSED"), // WIN
        TradeLog("SOLUSDT", "LONG",  10, -12.0,  "CLOSED"), // LOSS
        TradeLog("ETHUSDT", "LONG",  25,  22.7,  "CLOSED"), // WIN
        TradeLog("SOLUSDT", "SHORT",  5,   3.1,  "CLOSED"), // WIN
        TradeLog("BTCUSDT", "LONG",  10,   6.0,  "OPEN"),   // OPEN - tidak masuk pipeline
        TradeLog("ETHUSDT", "SHORT", 20,  -8.5,  "OPEN")    // OPEN - tidak masuk pipeline
    )

    // Pipeline 1: Filter hanya CLOSED trades
    val closedTrades = tradeHistory.filter { it.status == "CLOSED" }

    // Pipeline 2: Winning trades (roe > 0)
    val winningTrades = closedTrades.filter { it.roe > 0 }

    // Pipeline 3: Losing trades (roe <= 0)
    val losingTrades = closedTrades.filter { it.roe <= 0 }

    // Pipeline 4: Top performers — sorted highest ROE, formatted as String
    val topPerformersString = winningTrades
        .sortedByDescending { it.roe }
        .map { "WIN [${it.pair} - ${it.position}]: +${it.roe}% ROE (Lev: ${it.leverage}x)" }

    // Pipeline 5: Worst performers — sorted lowest ROE (paling minus dulu), formatted
    val worstPerformersString = losingTrades
        .sortedBy { it.roe }
        .map { "LOSS [${it.pair} - ${it.position}]: ${it.roe}% ROE (Lev: ${it.leverage}x)" }

    // Pipeline tambahan: Semua pasangan koin unik yang pernah ditradingkan
    val uniquePairs = tradeHistory
        .map { it.pair }
        .toSet()

    // === CRYPTO TRADING DASHBOARD ===
    println("=== CRYPTO TRADING DASHBOARD ===")
    println("\n--- TOP PERFORMERS (WIN) ---")
    topPerformersString.forEach { println(it) }

    println("\n--- WORST PERFORMERS (LOSS) ---")
    worstPerformersString.forEach { println(it) }

    println("\n--- UNIQUE TRADING PAIRS ---")
    println("Pairs traded: $uniquePairs")
}
