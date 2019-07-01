package model.dishes

class Dessert(dishName: String, type: DishType = DishType.DESSERT) : Dish(dishName, type) {

    private val extraType: ExtraType = ExtraType.CAL

    override fun setExtras(extras: Extras) {
        val extraType: ExtraType = extras.getExtratype()
        if (extraType != this.extraType) return
        else this.getExtras().put(extraType, extras.getExtravalue())
    }
}