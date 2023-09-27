/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

    import javax.swing.*;
    import java.awt.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.awt.Font;
   // import controller.Controlador;
   // import model.Music;
/**
 *
 * @author Soporte
 */
public class InitialWindow extends JFrame {
    // Variable para el guardar el color de la bola.
    // Variables para los JLabel de la ventana.
    private JLabel L_laberinto;
    private JLabel L_creators;
    private JLabel L_color;
    // Variable para el boton de iniciar y salir.
    private JButton btnSalir;
    private JButton btnIniciar;
    // Variable para el JTextFiel de la ventana.
    private JTextField TFnombre;
    // Variable para colocar el fondo de la ventana.
    private background background;
    // Variable que crea la ventana del juego.
   // private static VentanaNivel1 nivel1;
    // Variable para mostrar las opciones de colores.
   // public JComboBox<String> listaColores;
    // Variable para guardar el nombre del jugador.
    public static String jugadorLab;
    
    
    public InitialWindow() {
        super("Menú Principal");
        settWindow();
        //iniciarLabels();
        //iniciarBotones();
        //iniciarTextFields();
        //iniciarVentana2();
        //iniciarColor();
        //cerrarJuego();
    }
    
    public void settWindow(){
        background = new background();
        this.setContentPane(background);
        this.setSize(350, 380);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
    }
    
}




