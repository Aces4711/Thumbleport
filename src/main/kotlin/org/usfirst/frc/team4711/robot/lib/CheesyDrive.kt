package org.usfirst.frc.team4711.robot.lib

import java.lang.Math

object CheesyDrive {
    var m_turnInput: Double = 0.0
    var m_speedInput: Double = 0.0

    const val k_curveTurnSens: Double = 1.0
    const val k_throttleQuickTurnThreshold: Double = 0.2
    const val k_quickStopAccumulationFactor: Double = 0.2

    var m_motorSpeeds: DriveSignal = DriveSignal(0.0, 0.0)

    var m_quickTurn: Boolean = false
    var m_quickStopAccum: Double = 0.0

    fun updateInputs(turn: Double, speed: Double) {
        m_turnInput = turn
        m_speedInput = speed
    }

    fun updateQuickTurn(qt: Boolean) {
        m_quickTurn = qt
    }

    fun update() {
        var throttle: Double = m_speedInput
        var turn: Double = m_turnInput

        var powerOverride: Double = 0.0
        var turnPower: Double = 0.0

        if (m_quickTurn) {
            if (Math.abs(throttle) < k_throttleQuickTurnThreshold) {
                m_quickStopAccum = (1 - k_quickStopAccumulationFactor) * m_quickStopAccum + k_quickStopAccumulationFactor * 2 * turn
            }
            powerOverride = 1.0
            turnPower = turn
        } else {
            powerOverride = 0.0
            turnPower = Math.abs(throttle) * turn * k_curveTurnSens - m_quickStopAccum
        }

        m_quickStopAccum = if (m_quickStopAccum > 1) m_quickStopAccum - 1 else if (m_quickStopAccum < -1) m_quickStopAccum + 1 else 0.0

        var rightMotorPower = throttle - turnPower
        var leftMotorPower = throttle + turnPower


        if (leftMotorPower > 1.0) {
            rightMotorPower -= powerOverride * (leftMotorPower - 1.0);
            leftMotorPower = 1.0;
        } else if (rightMotorPower > 1.0) {
            leftMotorPower -= powerOverride * (rightMotorPower - 1.0);
            rightMotorPower = 1.0;
        } else if (leftMotorPower < -1.0) {
            rightMotorPower += powerOverride * (-1.0 - leftMotorPower);
            leftMotorPower = -1.0;
        } else if (rightMotorPower < -1.0) {
            leftMotorPower += powerOverride * (-1.0 - rightMotorPower);
            rightMotorPower = -1.0;
        }

        println("left: $leftMotorPower, right: $rightMotorPower")
        m_motorSpeeds = DriveSignal(leftMotorPower, rightMotorPower)
    }

    fun updateCheesy(turn: Double = 0.0, speed: Double = 0.0, quickTurn: Boolean = false): DriveSignal {
        updateInputs(turn, speed)
        updateQuickTurn(quickTurn)
        update()
        return m_motorSpeeds
    }
}
