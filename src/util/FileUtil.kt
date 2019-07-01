package util

import model.orders.Order
import java.io.File
import java.io.FileWriter

class FileUtil {

    private val csvHeader = "customerName,dishName,type,gfd,vgd,hdm,sfd,extras"

    fun createFile(): File {
        var file = File("orders.csv")

        if (file.exists()) {
            file.delete()
            file.createNewFile()
        } else {
            file.createNewFile()
        }
        return file
    }

    fun writeToFile(file: File, orders: List<Order>) {

        var fileWriter = FileWriter(file)

        fileWriter.append("${this.csvHeader}\n")

        for (order in orders) {
            fileWriter.append("${order.toCSVFormat()}\n")
        }

        fileWriter.close()
    }

    fun getAllOrders(file: File) {
        val inputStream = file.inputStream()

        inputStream.bufferedReader().useLines { lines -> lines.forEach { println(it) } }
    }

    /*
    fun turnStringToOrderClass(line: String): MutableList<Order> {
        var result = line.split(",")
        val orders = mutableListOf<Order>()

        when(result[2]) {
            "MAIN_COURSE" -> orders.add(Order(result[0], MainDish(result[1], DishType.MAIN_COURSE)))
            "DESSERT" -> orders.add(Order(result[0], Dessert(result[1], DishType.DESSERT)))
            "STARTER" -> orders.add(Order(result[0], Starter(result[1], DishType.STARTER)))
        }
        return orders
    }
     */
}