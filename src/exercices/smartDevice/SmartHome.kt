package exercices.smartDevice

class SmartHome(
    val smartTvDevice: SmartTvDevice,
    val smartLightDevice: SmartLightDevice
) {

    var deviceTurnOnCount = 0
        private set

    private fun updateDeviceTurnOnCount() {
        deviceTurnOnCount = listOf(smartTvDevice, smartLightDevice)
            .count { it.deviceStatus == "on" }
    }

    fun turnOnTv() {
        if (smartTvDevice.deviceStatus != "on") {
            smartTvDevice.turnOn()
            updateDeviceTurnOnCount()
        }
    }

    fun turnOffTv() {
        if (smartTvDevice.deviceStatus == "on") {
            smartTvDevice.turnOff()
            updateDeviceTurnOnCount()
        }
    }

    fun turnOnLight() {
        if (smartLightDevice.deviceStatus != "on") {
            smartLightDevice.turnOn()
            updateDeviceTurnOnCount()
        }
    }

    fun turnOffLight() {
        if (smartLightDevice.deviceStatus == "on") {
            smartLightDevice.turnOff()
            updateDeviceTurnOnCount()
        }
    }

    fun turnOffAllDevices() {
        if (smartLightDevice.deviceStatus == "on" || smartTvDevice.deviceStatus == "on") {
            if (smartLightDevice.deviceStatus == "on") {
                smartLightDevice.turnOff()
            }
            if (smartTvDevice.deviceStatus == "on") {
                smartTvDevice.turnOff()
            }
        }
    }

    fun increaseTvVolume() {
        if (smartTvDevice.deviceStatus == "on") {
            smartTvDevice.increaseSpeakerVolume()
        } else {
            println("TV is off. Cannot adjust volume.")
        }
    }

    fun decreaseTvVolume() {
        if (smartTvDevice.deviceStatus == "on") {
            smartTvDevice.decreaseSpeakerVolume()
        } else {
            println("TV is off. Cannot adjust volume.")
        }
    }

    fun changeTvChannelToPrevious() {
        if (smartTvDevice.deviceStatus == "on") {
            smartTvDevice.previousChannel()
        } else {
            println("TV is off. Cannot change channel.")
        }
    }

    fun changeTvChannelToNext() {
        if (smartTvDevice.deviceStatus == "on") {
            smartTvDevice.nextChannel()
        } else {
            println("TV is off. Cannot change channel.")
        }
    }

    fun increaseLightBrightness() {
        if (smartLightDevice.deviceStatus == "on") {
            smartLightDevice.increaseBrightness()
        } else {
            println("Light is off. Cannot adjust brightness.")
        }
    }

    fun decreaseLightBrightness() {
        if (smartLightDevice.deviceStatus == "on") {
            smartLightDevice.decreaseBrightness()
        } else {
            println("Light is off. Cannot adjust brightness.")
        }
    }

    fun printDeviceInfos() {
        smartTvDevice.printDeviceInfo()
        smartLightDevice.printDeviceInfo()
    }
}