import model.dishes.*
import model.orders.Order
import model.orders.OnlineOrders
import util.FileUtil

fun main() {

    val mainCourse = MainDish("Kyoto-style ramen")

    val order1 = Order("Bruce Wayne", mainCourse)

    mainCourse.setCourseAttribute(AttributeType.SFD, true)

    mainCourse.setCourseAttribute(AttributeType.VGD, true)

    mainCourse.setExtras(Extras(ExtraType.PREF_DRINK, "Coke"))

    val dessert = Dessert("cinnamon custard")

    val order2 = Order("Peter Parker", dessert)

    val starter = Starter("cottage salad")

    val order3 = Order("Dora the explorer", starter)

    starter.setCourseAttribute(AttributeType.GFD, true)

    starter.setCourseAttribute(AttributeType.SFD, true)

    val orders = listOf(order1, order2, order3)

    for (order in orders) {
        println(order.toString())
    }

    var fileUtil = FileUtil()

    val file = fileUtil.createFile()

    fileUtil.writeToFile(file, orders)

    fileUtil.getAllOrders(file)

    var onlineOrders = OnlineOrders()

    onlineOrders.addOrder(order1)

    onlineOrders.addOrder(order2)

    onlineOrders.addOrder(order3)

    println("Number of oders: ${onlineOrders.getNumberOrders()}")

    println("First order: ${onlineOrders.getOrder(0)}")

    println("All orders: ${onlineOrders.getAllOrdersToString()}")

    println("Dish for last order: ${onlineOrders.getDish(2)}")

    println("All dishes: ${onlineOrders.getAllDishesToString()}")

    println("All main courses: ${onlineOrders.getDishesByType(DishType.MAIN_COURSE)}")

    println("Stats for desserts: ${onlineOrders.getStatsByDishType(DishType.DESSERT)}")

}