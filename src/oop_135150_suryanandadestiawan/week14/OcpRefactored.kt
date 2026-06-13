package oop_135150_suryanandadestiawan.week14

interface DiscountStrategy {
    fun apply(price: Double): Double
}

class StudentDiscount : DiscountStrategy {
    override fun apply(price: Double) = price * 0.80
}

class MemberDiscount : DiscountStrategy {
    override fun apply(price: Double) = price * 0.85
}

class SafeDiscountCalculator(private val strategy: DiscountStrategy) {
    fun calculate(price: Double) = strategy.apply(price)
}
