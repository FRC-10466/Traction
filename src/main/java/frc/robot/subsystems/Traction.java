package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.ResetMode;
import com.revrobotics.PersistMode;

public class Traction extends SubsystemBase{
    private final SparkMax Rightfront = new SparkMax(1,MotorType.kBrushed);
    private final SparkMax Leftfront = new SparkMax(2, MotorType.kBrushed);

    public final SparkMax Rightback = new SparkMax(3,MotorType.kBrushed);
    public final SparkMax Leftback = new SparkMax(4, MotorType.kBrushed);

    public final DifferentialDrive drive;

    public Traction() {
        SparkMaxConfig RightConfig = new SparkMaxConfig ();
        SparkMaxConfig LeftConfig = new SparkMaxConfig();


        SparkMaxConfig RightBackConfig = new SparkMaxConfig ();
        RightBackConfig.follow(Rightfront);
        Rightback.configure(RightBackConfig,ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);


        SparkMaxConfig LeftBackConfig = new SparkMaxConfig ();
        LeftBackConfig.follow(Leftfront);
        Leftback.configure(LeftBackConfig,ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

        //Inverter lado direito (right)
        RightConfig.inverted(true);

        Rightfront.configure(RightConfig,ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        Leftfront.configure(LeftConfig,ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

        //Para o sistema controlar a corrente e tensão e caso de segurança se travar ou o sistema não receptar ou transmitir dados
        drive = new DifferentialDrive(Leftfront, Rightfront);
        
        drive.setMaxOutput(0.7);
    }

    public void arcadeDrive(double forward, double rotation) {
        drive.arcadeDrive(forward, rotation);
    }

    public void StopTraction(){
        drive.stopMotor();
    }

}
