package exercices.smartDevice

fun main() {
    val smartDevice = SmartTvDevice("Android TV", "Entertainment")
    smartDevice.turnOn()
    smartDevice.increaseSpeakerVolume()
    smartDevice.decreaseSpeakerVolume()
    smartDevice.nextChannel()
    smartDevice.previousChannel()
    smartDevice.printDeviceInfo()
    smartDevice.turnOff()

    val smartDevice2 = SmartLightDevice("Google Light", "Utility")
    smartDevice2.turnOn()
    smartDevice2.increaseBrightness()
    smartDevice2.decreaseBrightness()
    smartDevice2.printDeviceInfo()
    smartDevice2.turnOff()

    val smartHome = SmartHome(smartDevice, smartDevice2)
    smartHome.turnOnTv()
    smartHome.turnOnLight()
    smartHome.increaseTvVolume()
    smartHome.decreaseTvVolume()
    smartHome.changeTvChannelToNext()
    smartHome.changeTvChannelToPrevious()
    smartHome.increaseLightBrightness()
    smartHome.decreaseLightBrightness()
    smartHome.printDeviceInfos()
    smartHome.turnOffAllDevices()
}