package oop_135150_suryanandadestiawan.week10

class WalletRepository<T : Any> {
    private val items = mutableListOf<T>()

    fun add(item: T) {
        items.add(item)
    }

    fun getAll(): List<T> {
        return items
    }

    // Search logic: filter items berdasarkan predicate
    fun search(predicate: (T) -> Boolean): List<T> {
        return items.filter(predicate)
    }
}
