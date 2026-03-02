package oop_001_suryanandadestiawan.week05

abstract class PaymentMethod(val accountName: String) {

    // Abstract function (tidak memiliki body)
    abstract fun processPayment(amount: Double)
}