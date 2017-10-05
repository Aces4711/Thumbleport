package org.usfirst.frc.team4711.robot.subsystems

import com.ctre.MotorControl.CANTalon
import com.ctre.MotorControl.SmartMotorController
import org.usfirst.frc.team4711.robot.Constants

object Misc {
    val m_shooterSRX = CANTalon(Constants.kMASTER_SHOOTER)
    val m_intakeSRX = CANTalon(Constants.kINTAKE)

    val m_shooterSlaveSRX = CANTalon(Constants.kSLAVE_SHOOTER)

    init {
        m_shooterSlaveSRX.changeControlMode(SmartMotorController.TalonControlMode.Follower)
        m_shooterSlaveSRX.set(m_shooterSRX.getDeviceID().toDouble())
    }

    fun setShooter(pow: Double) = m_shooterSRX.set(pow)
    fun setIntake(pow: Double) = m_intakeSRX.set(pow)
}