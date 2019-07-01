package model.dishes


class Starter(dishName: String, type: DishType = DishType.STARTER) : Dish(dishName, type) {

    private val extraType: ExtraType = ExtraType.CUTLERY

    override fun setExtras(extras: Extras) {
        val extraType: ExtraType = extras.getExtratype()
        if (extraType != this.extraType) return
        else this.getExtras().put(extraType, extras.getExtravalue())
    }
}