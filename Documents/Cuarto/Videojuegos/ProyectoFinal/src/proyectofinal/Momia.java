/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

/**
 * Clase Piedra
 *
 * @author Luis Reyna
 * @version 1.00 2014/9/4
 */
import java.awt.Image;
import java.awt.Toolkit;

public class Momia extends Base {

    private int direccion;

    /**
     * Metodo constructor que hereda los atributos de la clase
     * <code>Base</code>.
     *
     * @param posX es la <code>posiscion en x</code> del objeto elefante.
     * @param posY es el <code>posiscion en y</code> del objeto elefante.
     * @param anima es la <code>Animacion</code> del objeto elefante.
     */
    public Momia(int posX, int posY) {
        super(posX, posY);
        //Se cargan las imágenes(cuadros) para la animación
//        Image momia = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/momia.png"));
        Image momia1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/momia1.png"));
        Image momia2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/momia2.png"));
        Image momia3 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/momia3.png"));
        Image momia4 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/momia4.png"));
        Image momia5 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/momia5.png"));
        //Se crea la animación
        anima = new Animacion();
//        anima.sumaCuadro(momia, 100);
        anima.sumaCuadro(momia1, 200);
        anima.sumaCuadro(momia2, 200);
        anima.sumaCuadro(momia3, 200);
        anima.sumaCuadro(momia4, 200);
        anima.sumaCuadro(momia5, 200);

        direccion = 3;
    }

    /**
     * Metodo que hace llamada al metodo de anima para actualizar la imagen
     * segun el tiempo <code>Animacion</code>.
     *
     * @param tiempo es el tiempo <code>Int</code> del objeto Animacion.
     */
    public void actualiza(long tiempo) {
        anima.actualiza(tiempo);
    }

    /**
     * Metodo para cambiar la direccion de la momia
     *
     * @param x es la nueva direccion
     */
    public void setDireccion(int x) {
        direccion = x;
    }

    /**
     * Metodo para regresar la direccion de la momia
     *
     * @return direccion es la direccion de la momia
     */
    public int getDireccion() {
        return direccion;
    }
}
