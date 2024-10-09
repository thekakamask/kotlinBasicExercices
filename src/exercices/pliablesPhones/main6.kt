package exercices.pliablesPhones

fun main() {

    val samsung = Phone(false)
    samsung.checkPhoneScreenLight()
    samsung.switchOn()
    samsung.checkPhoneScreenLight()

    val newFoldablePhone = FoldablePhone()

    newFoldablePhone.switchOn()
    newFoldablePhone.checkPhoneScreenLight()
    newFoldablePhone.unfold()
    newFoldablePhone.switchOn()
    newFoldablePhone.checkPhoneScreenLight()
}

open class Phone(var isScreenLightOn: Boolean = false){

    open fun switchOn() {
        isScreenLightOn = true
    }

    fun switchOff() {
        isScreenLightOn = false
    }

    fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}

class FoldablePhone(var isFold: Boolean = true) : Phone() {

    fun fold() {
        isFold = true
    }

    fun unfold() {
        isFold = false
    }

    override fun switchOn() {
        if (!isFold) {
            isScreenLightOn = true
        }
    }


    fun checkPhoneScreenFold() {
        val phoneScreenFold = if (isFold) "on" else "off"
        println("The phone screen's fold is $phoneScreenFold.")
    }
}
