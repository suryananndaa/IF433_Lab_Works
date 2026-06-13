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
}
