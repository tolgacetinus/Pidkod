package frc.robot;

import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class PidController {
    float dconstant;
    float iconstant;
    float pconstant;
    float error, previouserror, integral, derivative,sum;
    Gyro gyro;
    DifferentialDrive robotturn;
    


    public float PID(float setpoint)
    {
        error=setpoint-gyro.getAngle();
        integral+=(error*.02);
        derivative=(error-previouserror)/.02;
        sum= (pconstant*error)+(iconstant*integral)+(dconstant*derivative);
        return sum;
        
        
        

    }
    public void turn()
    {
        robotturn.arcadeDrive(0,sum);


    }

    

   
}