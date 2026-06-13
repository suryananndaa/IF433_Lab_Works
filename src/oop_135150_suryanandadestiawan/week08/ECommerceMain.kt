package oop_135150_suryanandadestiawan.week08

fun main() {
    val rawApiData: List<Map<String, Any?>> = listOf(
        mapOf("id" to "E01", "name" to "Laptop", "type" to "ELECTRONIC", "warranty" to 24),
        mapOf("id" to "C01", "name" to "T-Shirt", "type" to "CLOTHING", "size" to "XL"),
        mapOf("id" to "E02", "name" to "Mouse", "type" to "ELECTRONIC", "warranty" to "Not An Integer"), // Corrupted warranty
        mapOf("name" to "Ghost Item", "type" to "CLOTHING"), // Missing ID!
        mapOf("id" to "X01", "name" to "Unknown", "type" to "FOOD") // Unknown type
    )

    val parser = ApiParser()

    println("=== E-COMMERCE BATCH PIPELINE ===")
    for (raw in rawApiData) {
        try {
            val product = parser.parseProduct(raw)

            // Hanya lanjut jika parseProduct tidak return null
            product?.let {
                when (it) {
                    is Product.Electronic ->
                        println("[PARSED] Electronic: ${it.name}, Warranty: ${it.warrantyMonths} months")
                    is Product.Clothing ->
                        println("[PARSED] Clothing: ${it.name}, Size: ${it.size}")
                }
                parser.checkout(it)
            } ?: println("[SKIPPED] Unknown product type, data di-skip.")

        } catch (e: IllegalArgumentException) {
            println("[ERROR] Data korup tertangkap: ${e.message}")
        }
    }
}
