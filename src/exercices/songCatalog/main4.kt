package exercices.songCatalog
fun main() {
    var song = Song("Destroy sabine", "crackhead", 1450, 100)
    song.printDescription()
    song = Song("Destroy sabine", "crackhead", 1450, 1500)
    song.printDescription()
}

data class Song ( val title : String, val artist : String, val publicationYear : Int, var numberOfPlay : Int) {

    private val isPopular : Boolean
        get() = numberOfPlay >= 1000

    fun printDescription() {
        println("$title, performed by $artist, was released in $publicationYear. the song is popular : $isPopular")
    }
}