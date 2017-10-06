package org.usfirst.frc.team4711.robot.lib

object FunkyDrive {
    fun update(throttle: Double, rate: Double): DriveSignal {
        val leftRoom = 1.0 - throttle
        val rightRoom = 1.0 - throttle

        val leftOverflow = leftRoom < rate
        val rightOverflow = rightRoom < rate

        val leftSpeed = throttle + if (!leftOverflow) { rate * getDir(rate) } else { 1.0 }
        val rightSpeed = throttle + if (!rightOverflow) { rate * getDir(rate) } else { 1.0 }

        return DriveSignal(leftSpeed, rightSpeed, false)
    }

    fun getDir(rate: Double): Double {
        if (rate < 0) { return -1.0 }
        return 1.0
    }
}