
package proyectofinal;
/**
 * Clase Personaje
 *
 * @author Luis Reyna 
 * @version 1.00 2014/9/4
 */
import java.awt.Image;
import java.awt.Toolkit;

public class Personaje extends Base {

    private final static String PAUSE = "PAUSADO";
    private final static String DISP = "DESAPARECE";

    /**
     * @return the DISP
     */
    public static String getDISP() {
        return DISP;
    }

    /**
     * @return the PAUSE
     */
    public static String getPAUSE() {
        return PAUSE;
    }

    /**
     * Metodo constructor que hereda los atributos de la clase
     * <code>Base</code>.
     *
     * @param posX es la <code>posiscion en x</code> del objeto elefante.
     * @param posY es el <code>posiscion en y</code> del objeto elefante.
     * @param elefN es la <code>imagen</code> del los objetos elefs.
     * @param anima es la <code>Animacion</code> del objeto elefante.
     * @param num es la cantidad de elefes <code>Int</code> del objeto elefante.
     */
    public Personaje(int posX, int posY) {
        super(posX, posY);
        //Se cargan las imágenes(cuadros) para la animación
        Image corre1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/corre1.gif"));
        Image corre2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/corre2.gif"));
        Image corre3 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/corre3.gif"));
        Image corre4 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/corre4.gif"));

        //Se crea la animación
        anima = new Animacion();
        anima.sumaCuadro(corre1, 100);
        anima.sumaCuadro(corre2, 100);
        anima.sumaCuadro(corre3, 100);
        anima.sumaCuadro(corre4, 100);
    }
    /**
     * Metodo que hace llamada al metodo de anima para actualizar la imagen segun el tiempo
     * <code>Animacion</code>.
     *
     * @param tiempo es el tiempo <code>Int</code> del objeto Animacion.
     */
    public void actualiza(long tiempo) {
        anima.actualiza(tiempo);
    }
}