import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.util.Delay;

/**
 * Stop after 4 revolutions based on time, then based on tacho count
 * @author Roger
 *
 */
public class MotorTutor2 {

     public static void main(String[] args) 
     {

          // Mensaje y esperar antes de empezar
          LCD.drawString("Pulsa un boton", 0, 0);
          Button.waitForAnyPress();

          // Encender los motores a 2 revoluciones/segundo
          Motor.A.setSpeed(720);
          Motor.A.forward();
          Motor.B.setSpeed(720);
          Motor.B.forward();

          // Limpiar la pantalla
          LCD.clear();

          // Esperar 2 segundos
          Delay.msDelay(2000);

          // Mostrar el número de vueltas de A
          LCD.drawInt(Motor.A.getTachoCount(),0,0);
          
          // Parar los motores
          Motor.A.stop();
          Motor.B.stop();

          // Mostrar el número de vueltas de A
          LCD.drawInt(Motor.A.getTachoCount(),0,1);

          // Invertir los motores
          Motor.A.backward();
          Motor.B.backward();

          // Esperar a que los dos motores vuelvan a llegar a la posición 0
          while (Motor.A.getTachoCount()>0 && Motor.B.getTachoCount()>0); 

          // Mostrar el número de vueltas de A
          LCD.drawInt(Motor.A.getTachoCount(),0,2);

          // Parar los motores
          Motor.A.stop();
          Motor.B.stop();

          // Mostrar el número de vueltas de A
          LCD.drawInt(Motor.A.getTachoCount(),0,3);

          // Esperar una tecla para terminar
          Button.waitForAnyPress();

     }

}

