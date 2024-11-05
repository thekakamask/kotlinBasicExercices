package learningCollections

fun main() {
    //Array creation (mutable but same type and fixed size)
    val rockPlanets = arrayOf("Mercury", "Venus", "Earth", "Mars")
    val gasPlanets = arrayOf("Jupiter", "Saturn", "Uranus", "Neptune")
    val solarSystem = rockPlanets + gasPlanets
    // Use ContentToString to display data
    println(solarSystem.contentToString())
    println(solarSystem.size)
    println(solarSystem[0])
    println(solarSystem[1])
    println(solarSystem[2])
    println(solarSystem[3])
    println(solarSystem[4])
    println(solarSystem[5])
    println(solarSystem[6])
    println(solarSystem[7])
    println()
    //Change value of index 3
    solarSystem[3] = "Little Earth"
    println(solarSystem[3])
    val newSolarSystem = arrayOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto")
    println(newSolarSystem[8])
    println()
    //List creation (fixed size and unmutable)
    val solarSystemList = listOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
    println(solarSystemList.size)
    println(solarSystemList)
    println(solarSystemList[2])
    println(solarSystemList.get(3))
    //find index of value
    println(solarSystemList.indexOf("Earth"))
    println(solarSystemList.indexOf("Pluto"))
    //Loop for
    for (planet in solarSystemList) {
        println(planet)
    }
    println()
    //MutableList creation (size and data are mutable)
    val solarSystemMutableList = mutableListOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
    //Add value at the end of the MutableList
    solarSystemMutableList.add("Pluto")
    println(solarSystemMutableList)
    //Add value in a specific index
    solarSystemMutableList.add(3, "Theia")
    println(solarSystemMutableList)
    //Modify value in a specific index
    solarSystemMutableList[3] = "Future Moon"
    println(solarSystemMutableList[3])
    println(solarSystemMutableList[9])
    println(solarSystemMutableList)
    //Remove value at a specific index
    solarSystemMutableList.removeAt(9)
    //Remove value by it name
    solarSystemMutableList.remove("Future Moon")
    //Boolean to verify if value by it name is contain
    println(solarSystem.contains("Pluto"))
    //Boolean to verify if value by it name is contain with the in operator
    println("Future Moon" in solarSystem)
    println()

    //MutableSet creation (unordered value, (Set exist also (not mutable), no two same values in the MutableSet or Set)
    val solarSystemMutableSet = mutableSetOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
    println(solarSystemMutableSet.size)
    solarSystemMutableSet.add("Pluto")
    println(solarSystemMutableSet.size)
    println(solarSystemMutableSet.contains("Pluto"))
    solarSystemMutableSet.add("Pluto")
    println(solarSystemMutableSet.size)
    println()
    //MutableMap creation (unordered value,Map exist (no mutable))
    val solarSystemMutableMap = mutableMapOf(
        "Mercury" to 0,
        "Venus" to 0,
        "Earth" to 1,
        "Mars" to 2,
        "Jupiter" to 79,
        "Saturn" to 82,
        "Uranus" to 27,
        "Neptune" to 14
    )
    println(solarSystemMutableMap.size)
    //Add value to Mutable Map
    solarSystemMutableMap["Pluto"] = 5
    println(solarSystemMutableMap.size)
    //Print the key value pair of Pluto
    println(solarSystemMutableMap["Pluto"])
    //null value (Theia doesn't exist in this MutableMap)
    println(solarSystemMutableMap.get("Theia"))
    solarSystemMutableMap.remove("Pluto")
    println(solarSystemMutableMap.size)
    solarSystemMutableMap["Jupiter"] = 78
    println(solarSystemMutableMap["Jupiter"])
}