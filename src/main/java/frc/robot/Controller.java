package frc.robot;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Constants.OperatorConstants;

public class Controller {
    private final XboxController xbox = new XboxController(OperatorConstants.kDriverControllerPort);

    //Ignora valores pequenos do analógico para o robô não andar sozinho com o controle solto
    private static final double ZONA_MORTA = 0.1;

    //Analógico esquerdo (eixo Y): frente e trás. O Y do Xbox é negativo para frente, por isso o sinal de menos
    public double andarReto() {
        return MathUtil.applyDeadband(xbox.getLeftY(), ZONA_MORTA);
    }

    //Analógico direito (eixo X): virar. Sinal de menos porque no WPILib girar para a esquerda é positivo
    public double virar() {
        return MathUtil.applyDeadband(xbox.getRightX(), ZONA_MORTA);
    }

    //Botão A segurado = turbo
    public boolean turboApertado() {
        return xbox.getAButton();
    }
}
