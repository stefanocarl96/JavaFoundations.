package model.orders

import model.dishes.Dish

class Order (private val customerName: String, private val dish: Dish) {

    fun toCSVFormat(): String {
        return "${this.customerName},${this.dish.toCSVFormat()}"
    }

    fun getCourse(): Dish {
        return this.dish
    }

    override fun toString(): String {
        return "Customer: ${this.customerName}. Dish: ${this.dish}"
    }
}