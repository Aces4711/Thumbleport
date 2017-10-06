package org.usfirst.frc.team4711.robot

import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj.XboxController

object OI {
    val deadzoneThreshold: Double = 0.15

    fun deadzone(value: Double): Double {
        if (Math.abs(value) < deadzoneThreshold) return 0.0
        return value
    }

    val driverController: XboxController = XboxController(0)

    fun getLeftThrottle() = deadzone(driverController.getRawAxis(1))
    fun getRightThrottle() = deadzone(driverController.getRawAxis(5))

    fun getThrottle() = deadzone(-driverController.getY())
    fun getRate() = deadzone(-driverController.getX())

    fun getIntake() = driverController.getXButton()
    fun getShooter() = driverController.getYButton()

    fun getBrake() = driverController.getAButton()
    fun getQuickturn() = driverController.getBButton()
}