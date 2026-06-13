package oop_135150_suryanandadestiawan.week12

fun dispenseKibble(requestedGram: Int, availableGram: Int, isJammed: Boolean): Int {
    require(requestedGram > 0) { "Porsi kibble harus lebih dari 0 gr" }
    if (isJammed) {
        throw DispenserJamException()
    }
    if (requestedGram > availableGram) {
        throw FoodEmptyException(requestedGram, availableGram)
    }
    println("Kibble berhasil dikeluarkan!")
    return availableGram - requestedGram
}

fun main() {
    var currentKibbleStock = 50

    // === JADWAL MAKAN 1: Makan Pagi - Multiple Catch ===
    println("=== JADWAL MAKAN PAGI ===")
    try {
        currentKibbleStock = dispenseKibble(
            requestedGram = 80,
            availableGram = currentKibbleStock,
            isJammed = false
        )
    } catch (e: DispenserJamException) {
        println("ERROR HARDWARE: ${e.message}")
    } catch (e: FoodEmptyException) {
        println("ERROR STOK: ${e.message}")
    } catch (e: Exception) {
        println("ERROR UMUM: ${e.message}")
    }
}
