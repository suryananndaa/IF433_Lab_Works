package oop_001_suryanandadestiawan.week2

class Loan(
    val bookTitle: String,
    val borrower: String,
    val loanDuration: Int = 1   // Default Argument = 1 hari
) {

    fun calculateFine(): Int {
        return if (loanDuration > 3) {
            (loanDuration - 3) * 2000
        } else {
            0
        }
    }

}