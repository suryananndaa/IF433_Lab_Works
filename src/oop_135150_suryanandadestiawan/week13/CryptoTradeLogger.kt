package oop_135150_suryanandadestiawan.week13

import java.io.File
import java.io.FileNotFoundException

data class TradeRecord(
    val id: Int,
    val symbol: String,
    val type: String,
    val margin: Double,
    val pnl: Double
)

// Serialization (Object -> CSV)
fun TradeRecord.toCsv(): String = "$id,$symbol,$type,$margin,$pnl"

// Deserialization (CSV -> Object), nullable return type
fun fromCsvTrade(line: String): TradeRecord? {
    return try {
        val parts = line.split(",")
        TradeRecord(
            id = parts[0].toInt(),
            symbol = parts[1],
            type = parts[2],
            margin = parts[3].toDouble(),
            pnl = parts[4].toDouble()
        )
    } catch (e: Exception) {
        println("(Log) Data korup diabaikan: $line")
        null
    }
}

// Write System
fun saveTrades(trades: List<TradeRecord>, path: String) {
    File(path).printWriter().use { writer ->
        trades.forEach { trade ->
            writer.println(trade.toCsv())
        }
    }
}

// Load System (Safe Skip)
fun loadTrades(path: String): List<TradeRecord> {
    return try {
        File(path).readLines().mapNotNull { fromCsvTrade(it) }
    } catch (e: FileNotFoundException) {
        println("Error: File $path tidak ditemukan!")
        emptyList()
    }
}

fun main() {
    // Dashboard Setup & Mock Data
    val trades = listOf(
        TradeRecord(id = 1, symbol = "BTCUSDT", type = "Long",  margin = 500.0,  pnl = 120.5),
        TradeRecord(id = 2, symbol = "ETHUSDT", type = "Short", margin = 300.0,  pnl = -45.0),
        TradeRecord(id = 3, symbol = "SOLUSDT", type = "Long",  margin = 200.0,  pnl = 80.25)
    )

    saveTrades(trades, path = "crypto_trades.csv")
    println("Trade records berhasil disimpan ke crypto_trades.csv")

    // Injecting Malformed Data untuk test robustness
    File("crypto_trades.csv").appendText("CORRUPT_ID,DOGEUSDT,Hold,XX,YY\n")
    println("Baris korup berhasil di-inject ke crypto_trades.csv")

    // Aggregation & Calculation
    val loadedData = loadTrades(path = "crypto_trades.csv")
    val totalPnl = loadedData.sumOf { it.pnl }
}
