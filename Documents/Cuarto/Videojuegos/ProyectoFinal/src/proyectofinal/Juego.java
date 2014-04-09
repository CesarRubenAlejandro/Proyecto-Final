/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

/**
 *
 * @author Aaron
 */
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Toolkit;
import java.awt.Color;
import java.util.LinkedList;

/**
 *
 * @author Cesar , Angela A01036009, A01139764
 */
public class Juego extends JFrame implements Runnable, KeyListener, MouseListener {

    // Declarar todas las variable
    private Image dbImage;    // Imagen a proyectar	 
    private Graphics dbg;	// Objeto grafico
    
    
    private int nivel; // Nivel actual
    private boolean menu; // Bandera para indicar la pantalla de menu
    private boolean instrucciones; // Bandera para indicar la pantalla de instrucciones
    private boolean ajustes; // Bandera para indicar la pantalla de ajustes
    private boolean creditos; // Bandera para indicar la pantalla de creditos
    private boolean puntajes; // Bandera para indicar la pantalla de puntajes
    
    //BOTONES
    private Boton botonCreditos;
    private Boton botonIniciar;
    private Boton botonInstrucciones;
    private Boton botonAjustes;
    private Boton botonMejPuntajes;
    
    //Imagenes botones
    private Image imagenBotonCreditos;
    private Image imagenBotonInstrucciones;
    private Image imagenBotonIniciar;
    private Image imagenBotonAjustes;
    private Image imagenBotonMejPuntajes;
    
    private Image imFondoMenu;
    private Image imFondoAjustes;
    private Image imFondoCreditos;
    private Image imFondoPuntajes;
     private Image imFondoInstrucciones;
 
    
    
    //Constructor
    public Juego() {
        setTitle("Deep in the shadows");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600); //tamaño del jframe
        addKeyListener(this);
        addMouseListener(this);
        imagenBotonCreditos = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Botones/botonCred.png"));
        imagenBotonInstrucciones = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Botones/botonInst.png"));
        imagenBotonIniciar = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Botones/botonIniciar.png"));
        imagenBotonAjustes = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Botones/botonIniciar.png"));
        imagenBotonMejPuntajes= Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Botones/botonIniciar.png"));
        
        botonCreditos = new Boton (0,0 );
        botonCreditos.getAnima().sumaCuadro(imagenBotonCreditos, 300);
        botonCreditos.setPosX(getWidth() / 2 - botonCreditos.getAncho() / 2);
        botonCreditos.setPosY(getHeight() / 2);
       
        botonInstrucciones = new Boton (0,0 );
        botonInstrucciones.getAnima().sumaCuadro(imagenBotonInstrucciones, 300);
        botonInstrucciones.setPosX(getWidth() / 2 - botonInstrucciones.getAncho() / 2);
        botonInstrucciones.setPosY(getHeight() / 2 + 50);
        
        botonIniciar= new Boton (0,0 );
        botonIniciar.getAnima().sumaCuadro(imagenBotonIniciar, 300);
        botonIniciar.setPosX(getWidth() / 2 - botonIniciar.getAncho() / 2 );
        botonIniciar.setPosY(getHeight() / 2 + 100);
        
        botonAjustes= new Boton (0,0 );
        botonAjustes.getAnima().sumaCuadro(imagenBotonAjustes, 300);
        botonAjustes.setPosX(getWidth() / 2 - botonAjustes.getAncho() / 2);
        botonAjustes.setPosY(getHeight() / 2 + 150);
        
        botonMejPuntajes = new Boton (0,0 );
        botonMejPuntajes.getAnima().sumaCuadro(imagenBotonMejPuntajes, 300);
        botonMejPuntajes.setPosX(getWidth() / 2 - botonMejPuntajes.getAncho() / 2);
        botonMejPuntajes.setPosY(getHeight() / 2 + 200);
        
        
        
        
        imFondoMenu = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Fondos/Menu.jpg")); // imagen de fondo del menu
        imFondoAjustes = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Fondos/ajustes.jpg"));
        imFondoPuntajes = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Fondos/puntajes.jpg"));
        imFondoCreditos = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Fondos/creditos.jpg"));
        imFondoInstrucciones =  Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Fondos/instrucciones.jpg"));
        nivel = 0;// Nivel 0 indica que todavia no inicia
        menu = true; // comenzamos en el menu
        // Las demas pantallas estan apagadas
        instrucciones = false; 
        ajustes = false;
        creditos = false;
        puntajes = false;
        
       // botInstrucciones = new Boton(0,0);
       // Image botInst = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Botones/botonInst.png"));
       // botInstrucciones.getAnima().sumaCuadro(botInst, 300);
        //HILO
        Thread th = new Thread(this);
        // Empieza el hilo
        th.start();
    }

    /**
     * Reset - limpia y prepara todo para el inicio del nuevo juego.
     */
    public void reset() {

    }

    /**
     * Metodo <I>run</I> sobrescrito de la clase <code>Thread</code>.<P>
     * En este metodo se ejecuta el hilo, es un ciclo indefinido donde se
     * incrementa la posicion en x o y dependiendo de la direccion, finalmente
     * se repinta el <code>JFrame</code> y luego manda a dormir el hilo.
     *
     */
    public void run() {

        //si esta pausado no actualizas ni checas colision 
        if (true) {
            actualiza();
            checaColision();
        }
        repaint(); // Se actualiza el <code>JFrame</code> repintando el contenido.
        try {
            // El thread se duerme.
            Thread.sleep(80);
        } catch (InterruptedException ex) {
            System.out.println("Error en " + ex.toString());
        }

    }

    /**
     * Metodo <I>actualiza</I>
     * Es usado para actualizar la posicion de los personajes y los valores de
     * las variables.
     */
    public void actualiza() {

    }

    /**
     * Metodo <I>checaColision</I>
     * Metodo usado para checar las colisiones de los objetos barquito y rayito
     * entre sí y con las orillas del <code>JFrame</code>.
     */
    public void checaColision() {
        //revisa si la barra intenta salir del JFrame  

    }

    /**
     * Metodo <I>paint</I>
     * En este metodo lo que hace es actualizar el contenedor (Update)
     *
     * @param g es el <code>objeto grafico</code> usado para dibujar.
     */
    public void paint(Graphics g) {
    // Inicializan el DoubleBuffer
        if (dbImage == null) {
            dbImage = createImage(this.getSize().width, this.getSize().height);
            dbg = dbImage.getGraphics();
        }

        // Actualiza la imagen de fondo.
        dbg.setColor(getBackground());
        dbg.fillRect(0, 0, this.getSize().width, this.getSize().height);

        // Actualiza el Foreground.
        dbg.setColor(getForeground());
        paint1(dbg);

        // Dibuja la imagen actualizada
        g.drawImage(dbImage, 0, 0, this);   
    }

    /**
     * Metodo <I>paint1</I>
     * En este metodo se dibuja la imagen con la posicion actualizada, ademas
     * que cuando la imagen es cargada te despliega una advertencia. (Paint)
     *
     * @param g es el <code>objeto grafico</code> usado para dibujar.
     */
    public void paint1(Graphics g) {
        if (menu) {
            g.drawImage(imFondoMenu, 0, 0, this);
            g.drawImage(botonIniciar.getImagenI(), botonIniciar.getPosX(), botonIniciar.getPosY(), this);
            g.drawImage(botonInstrucciones.getImagenI(), botonInstrucciones.getPosX(), botonInstrucciones.getPosY(), this);
            g.drawImage(botonCreditos.getImagenI(), botonCreditos.getPosX(), botonCreditos.getPosY(), this);
            g.drawImage(botonAjustes.getImagenI(), botonAjustes.getPosX(), botonAjustes.getPosY(), this);
            g.drawImage(botonMejPuntajes.getImagenI(), botonMejPuntajes.getPosX(), botonMejPuntajes.getPosY(), this);

        }
        if(ajustes){
             g.drawImage(imFondoAjustes, 0, 0, this);
        }
        
        if(creditos){
             g.drawImage(imFondoCreditos, 0, 0, this);
        }
        
        if(puntajes){
             g.drawImage(imFondoPuntajes, 0, 0, this);
        }
         if(instrucciones){
             g.drawImage(imFondoInstrucciones, 0, 0, this);
        }
    }

    /**
     * Metodo <I>keyTyped</I> sobrescrito de la interface
     * <code>KeyListener</code>.<P>
     * En este metodo maneja el evento que se genera al presionar una tecla que
     * no es de accion.
     *
     * @param e es el <code>evento</code> que se genera en al presionar las
     * teclas.
     */
    public void keyTyped(KeyEvent e) {
        
    }

    /**
     * Metodo <I>keyPressed</I> sobrescrito de la interface
     * <code>KeyListener</code>.<P>
     * En este metodo maneja el evento que se genera al presionar cualquier la
     * tecla.
     *
     * @param e es el <code>evento</code> generado al presionar las teclas.
     */
    public void keyPressed(KeyEvent e) {

    }

    /**
     * Metodo <I>keyReleased</I> sobrescrito de la interface
     * <code>KeyListener</code>.<P>
     * En este metodo maneja el evento que se genera al soltar la tecla
     * presionada.
     *
     * @param e es el <code>evento</code> que se genera en al soltar las teclas.
     */
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    /**
     * Metodo mouseClicked sobrescrito de la interface MouseListener. En este
     * metodo maneja el evento que se genera al hacer click con el mouse sobre
     * algun componente. e es el evento generado al hacer click con el mouse.
     */
    public void mouseClicked(MouseEvent e) {
             int clickX = e.getX();
             int clickY = e.getY();
             
          if (menu) {
            if (botonIniciar.clickEnPersonaje(clickX, clickY)) {
              nivel  = 1;
              menu = false;
          
            }
             if (botonAjustes.clickEnPersonaje(clickX, clickY)) {
              ajustes = true;
              menu = false;
          
            }
              if (botonCreditos.clickEnPersonaje(clickX, clickY)) {
              creditos = true;
              menu = false;
          
            }
              if (botonMejPuntajes.clickEnPersonaje(clickX, clickY)) {
                  puntajes = true;
                  menu = false;

              }
              if (botonInstrucciones.clickEnPersonaje(clickX, clickY)) {
                  instrucciones = true;
                  menu = false;

              }
        }
    }

    /**
     * Metodo mousePressed sobrescrito de la interface MouseListener. En este
     * metodo maneja el evento que se genera al presionar un botón del mouse
     * sobre algun componente. e es el evento generado al presionar un botón del
     * mouse sobre algun componente.
     */
    public void mousePressed(MouseEvent e) {
    }

    /**
     * Metodo mouseReleased sobrescrito de la interface MouseListener. En este
     * metodo maneja el evento que se genera al soltar un botón del mouse sobre
     * algun componente. e es el evento generado al soltar un botón del mouse
     * sobre algun componente.
     */
    public void mouseReleased(MouseEvent e) {
    }

    /**
     * Metodo mouseEntered sobrescrito de la interface MouseListener. En este
     * metodo maneja el evento que se genera cuando el mouse entra en algun
     * componente. e es el evento generado cuando el mouse entra en algun
     * componente.
     */
    public void mouseEntered(MouseEvent e) {
    }

    /**
     * Metodo mouseExited sobrescrito de la interface MouseListener. En este
     * metodo maneja el evento que se genera cuando el mouse sale de algun
     * componente. e es el evento generado cuando el mouse sale de algun
     * componente.
     */
    public void mouseExited(MouseEvent e) {
    }

}
