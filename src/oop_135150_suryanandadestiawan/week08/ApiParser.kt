package oop_135150_suryanandadestiawan.week08

class ApiParser {

    fun parseProduct(rawJson: Map<String, Any?>): Product? {
        // requireNotNull will throw IllegalArgumentException if null
        val id = requireNotNull(rawJson["id"] as? String) {
            "API Invalid: Missing ID"
        }
        val name = requireNotNull(rawJson["name"] as? String) {
            "API Invalid: Missing Name"
        }

        val type = rawJson["type"] as? String

        return when (type) {
            "ELECTRONIC" -> {
                val warranty = rawJson["warranty"] as? Int ?: 12 // fallback to 12 if corrupted
                Product.Electronic(id, name, warranty)
            }
            "CLOTHING" -> {
                val size = rawJson["size"] as? String ?: "All Size" // fallback if missing
                Product.Clothing(id, name, size)
            }
            else -> null // Unknown or null type
        }
    }

    fun checkout(product: Product) {
        val id = when (product) {
            is Product.Electronic -> product.id
            is Product.Clothing -> product.id
        }

        val transactionId = JavaPaymentService.processPayment(id)!!
        println("Payment processed! Transaction ID: $transactionId")
    }
}
