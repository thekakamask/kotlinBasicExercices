package learningExtensionsAndInterface

fun main() {
    //1) Instance declaration of Object Quiz
    val quizInstance = Quiz()
    //2) Access to question1 by the Instance of Object Quiz
    println("${quizInstance.question1}")
    //3) Access to Singleton
    println("${StudentProgress.answered} of ${StudentProgress.total} answered.")
    //4) Access to Object companion of Quiz Object
    println("${Quiz.answered} of ${Quiz.total} answered.")
    //5) Access to Extension Variable of the Object Companion of Object Quiz
    println(Quiz.progressText)
    //6) Access to Extension Function of the Object Companion of Object Quiz
    Quiz.printProgressBar()
    //7) Access to Override function of the Instance of the Object Quiz
    Quiz().printProgressBar()
    //8) New Object for use Scope functions
    val quiz = Quiz()
    quiz.printQuiz()

    //9) Use of Extension Function Apply ( No need to Variable Declaration)
    // val quiz = Quiz().apply No need to a Variable to call Quiz Instance Functions
    Quiz().apply {
        printQuiz()
    }

}

interface ProgressPrintable {
    val progressText: String
    fun printProgressBar()
}

//1)
class Quiz : ProgressPrintable{
    override val progressText: String
        get() = "$answered of $total answered"
    //7)
    override fun printProgressBar() {
        repeat(Quiz.answered) { print("▓") }
        repeat(Quiz.total - Quiz.answered) { print("▒") }
        println()
        println(progressText)
    }
    //2), A) Instances of Data Class with generic data type and B) call Constant of the Enum Class
    val question1 = Question("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question("How many days are there between full moons?", 28, Difficulty.HARD)

    //4)
    companion object StudentProgress {
        var total : Int = 10
        var answered: Int = 3
    }

    //8) Scope Functions Let and identifier It
    fun printQuiz() {
        println()
        question1.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question2.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question3.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
    }
}

//5)
val Quiz.StudentProgress.progressText: String
    get() = "$answered of $total answered"

//6)
fun Quiz.StudentProgress.printProgressBar() {
    repeat(Quiz.answered) { print("▓") }
    repeat(Quiz.total - Quiz.answered) { print("▒") }
    println()
    println(Quiz.progressText)
}

//3)
object StudentProgress {
    var total: Int = 10
    var answered: Int = 3
}

//A) Data Class with generic data type
data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)
//B) Enumeration Class with Constant
enum class Difficulty {
    EASY, MEDIUM, HARD
}