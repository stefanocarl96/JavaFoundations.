package model.dishes

class Extras(private val extraType: ExtraType, private val extraValue: String) {

    fun getExtratype(): ExtraType {
        return this.extraType
    }

    fun getExtravalue(): String {
        return this.extraValue
    }
}