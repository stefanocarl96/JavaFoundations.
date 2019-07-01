package model.orders

import model.dishes.Dish
import model.dishes.DishType
import model.dishes.ExtraType

interface OnlineOrderOps {

    fun getNumberOrders(): Int

    fun getOrder(index: Int): Order

    fun getAllOrdersToString(): String

    fun getDish(index: Int): Dish

    fun getAllDishesToString(): String

    fun getDishesByType(type: DishType): List<Dish>

    fun getStatsByDishType(type: DishType): String
}