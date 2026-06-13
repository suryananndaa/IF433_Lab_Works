package oop_135150_suryanandadestiawan.week09

// roe = Return on Equity dalam persentase
// status = "OPEN" atau "CLOSED"
data class TradeLog(
    val pair: String,
    val position: String,
    val leverage: Int,
    val roe: Double,
    val status: String
)
