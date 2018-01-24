import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.util.Delay;

public class Viajero {

     public static void main(String[] args) 
     {
          // Crear el rover
          Coche rover = new Coche();

          // Mensaje y esperar antes de empezar
          LCD.drawString("Pulsa un boton", 0, 0);
          Button.waitForAnyPress();

          // Limpiar la pantalla
          LCD.clear();

          // Continuar hasta que se pulse el botón gris
          while (!Button.ESCAPE.isDown()) {

               // Avanzar
               rover.adelante(100);
               
               if( rover.obstaculoDetectado() ) {

              		// Retrocedemos y giramos
                    rover.parar();
                    rover.atras(1000);
                    rover.parar();
                    rover.girar(1000, false);	// true -> Izquierda, false -> Derecha
                    rover.parar();

                    // Estamos quietos un momento para poder cogerlo
                    Delay.msDelay(2000);
               }
          }

          rover.parar();
     }

}
