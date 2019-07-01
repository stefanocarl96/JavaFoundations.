package model.dishes

abstract class Dish(private val dishName: String, private val type: DishType) : DishInt {

    private var gfd: Boolean = false
    private var vgd: Boolean = false
    private var hmd: Boolean = false
    private var sfd: Boolean = false
    private lateinit var extras : HashMap<ExtraType, String>

    abstract override fun setExtras (extras: Extras)

    fun getExtras(): HashMap<ExtraType, String> {
        return this.extras
    }

    fun getType(): DishType {
        return this.type
    }

    fun setCourseAttribute(attribute: AttributeType, value: Boolean) {
        when(attribute) {
            AttributeType.GFD -> this.gfd = value
            AttributeType.VGD -> this.vgd = value
            AttributeType.HMD -> this.hmd = value
            AttributeType.SFD -> this.sfd = value
        }
    }

    fun toCSVFormat(): String {
        return "${this.dishName},${this.type},${this.gfd},${this.vgd},${this.hmd},${this.sfd}"
    }

    override fun toString(): String {
        return "${this.dishName}, ${this.type}, Gluten-free: ${this.gfd}, Vegetarian: ${this.vgd}, Halal-meat: ${this.hmd}, Seafood-free: ${this.sfd}"
    }
}