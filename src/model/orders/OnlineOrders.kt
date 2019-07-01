package model.orders

import model.dishes.AttributeType
import model.dishes.Dish
import model.dishes.DishType
import model.dishes.ExtraType

class OnlineOrders: OnlineOrderOps {

    private var orders : MutableList<Order> = mutableListOf()

    fun addOrder(order: Order) {
        this.orders.add(order)
    }

    override fun getNumberOrders(): Int {
        return this.orders.size
    }

    override fun getOrder(index: Int): Order {
        return this.orders[index]
    }

    override fun getAllOrdersToString(): String {
        return this.orders.toString()
    }

    override fun getDish(index: Int): Dish {
        return this.orders[index].getCourse()
    }

    override fun getAllDishesToString(): String {
        var dishes: String = ""
        for (order in this.orders) {
            dishes += (order.getCourse().toString() + "\n")
        }
        return dishes
    }

    override fun getDishesByType(type: DishType): List<Dish> {
        var dishes : MutableList<Dish> = mutableListOf()

        for (order in this.orders) {
            if (order.getCourse().getType() == type) {
                dishes.add(order.getCourse())
            }
        }
        return dishes
    }

    override fun getStatsByDishType(type: DishType): String {
        val dishesByType = this.getDishesByType(type).size
        val totalDishes = this.getNumberOrders()
        val percentage = String.format("%.2f", (dishesByType.toDouble() / totalDishes.toDouble()) * 100)
        return "$percentage%"
    }
}