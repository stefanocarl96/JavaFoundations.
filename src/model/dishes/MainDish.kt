package model.dishes

class MainDish(dishName: String, type: DishType = DishType.MAIN_COURSE) : Dish(dishName, type) {

    override fun setExtras(extras: Extras) {
        val extraType: ExtraType = extras.getExtratype()
        if (extraType != ExtraType.MAIN_INGREDIENT || extraType != ExtraType.PREF_DRINK) return
        else this.getExtras().put(extraType, extras.getExtravalue())
    }
}