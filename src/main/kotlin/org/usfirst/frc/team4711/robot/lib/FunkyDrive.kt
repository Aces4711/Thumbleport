package org.usfirst.frc.team4711.robot.lib

object FunkyDrive {
    fun update(throttle: Double, turn: Double): DriveSignal {


        return DriveSignal(0.0, 0.0, false)
    }
}