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
    
    // Variables para los JLabel de la ventana.
    private JLabel L_geometricFig;
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
    //public static String jugadorLab;
    
    
    public InitialWindow() {
        super("Menú Principal");
        settWindow();
        initLabels();
        //iniciarBotones();
        //iniciarTextFields();
        //iniciarVentana2();
        //iniciarColor();
        //cerrarJuego();
    }
    
    // Método para la Configuracion de la ventana.
    public void settWindow(){
        background = new background();
        this.setContentPane(background);
        this.setSize(360, 390);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
    }
    
    //metodo que se encarga de iniciar las etiquetas de la ventana.
    public void initLabels(){
        L_geometricFig = new JLabel ("Geometric");
        L_geometricFig.setOpaque(true);
        L_geometricFig.setBounds(80, 30, 200, 40);
        L_geometricFig.setFont(new Font("Arial Black", 1, 30));
        L_geometricFig.setHorizontalAlignment(SwingConstants.CENTER);
        L_geometricFig.setBackground(new Color(255, 255, 255, 0));
        this.add(L_geometricFig);  
        
        L_creators = new JLabel ("by:@Toky0null");
        L_creators.setOpaque(true);
        L_creators.setBounds(182, 325, 200, 30);
        L_creators.setFont(new Font("Arial", 0, 11));
        L_creators.setHorizontalAlignment(SwingConstants.CENTER);
        L_creators.setBackground(new Color(255, 255, 255, 0));
        this.add(L_creators);
        
    }
}




