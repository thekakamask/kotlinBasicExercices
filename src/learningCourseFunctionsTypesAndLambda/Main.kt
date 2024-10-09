package learningCourseFunctionsTypesAndLambda

fun main() {
    trick1() // appel a la methode

    val trickFunction1 = trick1() // appel a la methode

    val trickFunction2= ::trick1 // reference a la methode
    trickFunction2() // appel a la methode

    val trickFunction3 = trick2 // reference de la variable trick2
    trickFunction3() // appel de la methode dans la variable trickFunction3()
    trick2() // appel de la methode dans la variable trick2
    treat2() // appel de la fonction dans la variable treat2

    val coins: (Int) -> String = { quantity ->
        "$quantity quarters"
    }            // methode dans une variable qui va servir de parametre pour trickOrTreat
    // on peut omettre le parametre quand il n'y en a qu'un seul :
    // val coins: (Int) -> String = {
    //        "$it quarters"
    //    }

    val cupcake: (Int) -> String = {
        "Have a cupcake!"
    }          // methode dans une variable qui va servir de parametre pour trickOrTreat

    val treatFunction = trickOrTreat(false, coins) // appel de la methode ( ne declenche pas la methode sous jacente )
    // on peut transmettre directement l'expression lambda a un appel de fonction :
    // val treatFunction = trickOrTreat(false, { "$it quarters" })
    // val treatFunction = trickOrTreat(false) {"$it quarters" }  synthaxe lamba de fin

    val trickFunction = trickOrTreat(true, cupcake) // appel de la methode  ( ne declenche pas la methode sous jacente )
    treatFunction() // appel de la methode sous jacente (treat2)
    trickFunction() // appel de la methode sous jacente (trick2)

    repeat(4) {
        treatFunction()
    }   // fonction ordre superieur correspond a : repeat(times: Int, action: (Int) -> Unit) syntaxe lambda de fin

    val trickFunction4 = trickOrTreat(true, null) // appel de la methode  ( ne declenche pas la methode sous jacente )
    trickFunction4()// appel de la methode sous jacente (trick2)
}

fun trick1() {
    println("No treats!")
}

val trick2 = {
    println("No treats!")
}

val treat2: () -> Unit = {
    println("Have a treat!")
}

fun trickOrTreat(isTrick: Boolean, extraTreat: ((Int) -> String)?): () -> Unit {
    if (isTrick) {
        return trick2
    } else {
        if (extraTreat != null) {
            println(extraTreat(5))
        }
        return treat2
    }
}         // un parametre boolean , un parametre methode et renvoi un methode (trick2 ou treat2)