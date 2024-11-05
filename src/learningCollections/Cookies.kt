package learningCollections

fun main() {
    //High order functions "forEach"
    //executes the function passed as a parameter once
    // for each element in the collection.
    cookies.forEach {
        println("Menu item: $it")
        println("Menu item: ${it.name}")
    }

    //High order functions "map"
    //transform a collection into a new collection
    // with the same number of elements (here a list of String)
    val fullMenu = cookies.map {
        "${it.name} - $${it.price}"
    }
    println("Full menu:")
    fullMenu.forEach {
        println(it)
    }

    //High order functions "filter"
    //create a subset within a collection.
    val softBakedMenu = cookies.filter {
        it.softBaked
    }
    println("Soft cookies:")
    softBakedMenu.forEach {
        println("${it.name} - $${it.price}")
    }

    //High order functions "groupeBy"
    //transform a list into a map. Each unique return
    // value from the function becomes a key to the
    // resulting mapping. The values of each
    // key correspond to all elements in the collection
    // that produced that single return value.
    val groupedMenu = cookies.groupBy { it.softBaked }
    val softBakeMenu = groupedMenu[true] ?: listOf()
    val crunchyMenu = groupedMenu[false] ?: listOf()
    println("Soft cookies:")
    softBakeMenu.forEach {
        println("${it.name} - $${it.price}")
    }
    println("Crunchy cookies:")
    crunchyMenu.forEach {
        println("${it.name} - $${it.price}")
    }

    //High order functions "fold"
    //generate unique value from a collection
    val totalPrice = cookies.fold(0.0) {total, cookie ->
        total + cookie.price
    }
    println("Total price: $${totalPrice}")

    //High order functions "sortedBy"
    //allows you to specify a lambda
    //that returns the property you want to sort on

    val alphabeticalMenu = cookies.sortedBy {
        it.name
    }

    println("Alphabetical menu:")
    alphabeticalMenu.forEach {
        println(it.name)
    }
}

class Cookie(
    val name: String,
    val softBaked: Boolean,
    val hasFilling: Boolean,
    val price: Double
)

val cookies = listOf(
    Cookie(
        name = "Chocolate Chip",
        softBaked = false,
        hasFilling = false,
        price = 1.69
    ),
    Cookie(
        name = "Banana Walnut",
        softBaked = true,
        hasFilling = false,
        price = 1.49
    ),
    Cookie(
        name = "Vanilla Creme",
        softBaked = false,
        hasFilling = true,
        price = 1.59
    ),
    Cookie(
        name = "Chocolate Peanut Butter",
        softBaked = false,
        hasFilling = true,
        price = 1.49
    ),
    Cookie(
        name = "Snickerdoodle",
        softBaked = true,
        hasFilling = false,
        price = 1.39
    ),
    Cookie(
        name = "Blueberry Tart",
        softBaked = true,
        hasFilling = true,
        price = 1.79
    ),
    Cookie(
        name = "Sugar and Sprinkles",
        softBaked = false,
        hasFilling = false,
        price = 1.39
    )
)

//You can make a loop that applies to each element in a collection successively using forEach().
//Expressions can be inserted into strings.
//map() allows you to format the elements of a collection, often by organizing them into a collection using another data type.
//filter() can generate a subset of a collection.
//groupBy() divides a collection based on the value returned by a function.
//fold() transforms a collection into a single value.
//sortedBy() allows you to sort a collection according to a specified property.
