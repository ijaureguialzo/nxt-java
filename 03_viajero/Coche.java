import lejos.nxt.Motor;
import lejos.nxt.NXTRegulatedMotor;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.util.Delay;

public class Coche {

     private NXTRegulatedMotor motorIzquierdo = Motor.A;
     private NXTRegulatedMotor motorDerecho = Motor.B;
     private UltrasonicSensor sensor = new UltrasonicSensor(SensorPort.S1);

     public Coche() {
          motorIzquierdo.setSpeed(720); // 2 rev/s
          motorDerecho.setSpeed(720);
     }

     public void adelante(int milisegundos) {
          motorIzquierdo.forward();
          motorDerecho.forward();
          Delay.msDelay(milisegundos);
     }

     public void atras(int milisegundos) {
          motorIzquierdo.backward();
          motorDerecho.backward();
          Delay.msDelay(milisegundos);
     }

     public void parar() {
          motorIzquierdo.stop();
          motorDerecho.stop();
     }

     public boolean obstaculoDetectado() {
          return sensor.getDistance() < 30;
     }

     public void girar(int milisegundos, boolean izquierda) {
          if( izquierda == false) {
               motorIzquierdo.forward();
               motorDerecho.backward();
          } else {
               motorIzquierdo.backward();
               motorDerecho.forward();
          }
          Delay.msDelay(milisegundos);
     }

}
