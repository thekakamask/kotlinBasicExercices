package exercices.followEvents

// Data class representing an event with a title, an optional description,
// a time of day (Daypart) and a duration in minutes
data class Event(
    val title: String,
    val description: String? = null,
    val daypart: Daypart,
    val duration: Int
)

// Enumeration for the different parts of the day
// (morning, afternoon and evening)
enum class Daypart {
    MORNING,AFTERNOON,EVENING
}

fun main() {
    // Creation of several Event objects with titles, times of day,
    // and varied durations
    val event1 = Event(title = "Wake up", description = "Time to get up", daypart = Daypart.MORNING, duration = 0)
    val event2 = Event(title = "Eat breakfast", daypart = Daypart.MORNING, duration = 15)
    val event3 = Event(title = "Learn about Kotlin", daypart = Daypart.AFTERNOON, duration = 30)
    val event4 = Event(title = "Practice Compose", daypart = Daypart.AFTERNOON, duration = 60)
    val event5 = Event(title = "Watch latest DevBytes video", daypart = Daypart.AFTERNOON, duration = 10)
    val event6 = Event(title = "Check out latest Android Jetpack library", daypart = Daypart.EVENING, duration = 45)

    // Creation of a mutable list containing all created events
    val events = mutableListOf(event1, event2, event3, event4, event5, event6)

    // Filtering events with a duration less than 60 minutes and storing them in a list
    val shortEvents = events.filter { it.duration < 60 }

    // Grouping events by their time of day (Daypart) in a Map
    val groupedEvents = events.groupBy { it.daypart }

    // Retrieving morning, afternoon and evening events from the Map
    // Using an empty list by default if no events for a specific time
    val morningEvents = groupedEvents[Daypart.MORNING] ?: listOf()
    val afternoonEvents = groupedEvents[Daypart.AFTERNOON] ?: listOf()
    val eveningEvents = groupedEvents[Daypart.EVENING] ?: listOf()

    println(events)
    println(shortEvents)
    println("You have ${shortEvents.size} short events.")
    println("Morning: ${morningEvents.size} events")
    println("Afternoon: ${afternoonEvents.size} events")
    println("Evening: ${eveningEvents.size} events")

    // Browse the Map to display the number of events by time of day
    groupedEvents.forEach { (daypart, events) ->
        println("$daypart: ${events.size} events")
    }


// Display the last event in the list by its title, using two methods
    println("Last event of the day: ${events[events.size - 1].title}") // Access by index
    println("Last event of the day: ${events.last().title}") // Direct access by last()


// Using an if expression to determine if the first event is short or long
    val durationOfEvent = if (events[0].duration < 60) {
        "short"
    } else {
        "long"
    }
    println("Duration of first event of the day: $durationOfEvent") // display "short" ou "long"

    // Using the extension property to display the duration of the first event
    println("Duration of first event of the day: ${events[0].durationOfEventExt}")

}

// Extension property for the Event class, allowing you to check if an event
// is "short" (less than 60 minutes) or "long" (60 minutes or more)
val Event.durationOfEventExt: String
    get() = if (this.duration < 60) {
        "short"
    } else {
        "long"
    }