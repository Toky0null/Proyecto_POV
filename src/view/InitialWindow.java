/**
 *
 * @author tokyo - Juna Sebastian Hurtado Batioja 2179288
 * @author kevin David Londoño Valencia-2224551
 */
package view;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
// import controller.Controlador;
import controller.Controller;

public class InitialWindow extends JFrame {   
    // Variables para los JLabel de la ventana.
    private JLabel geometricFig;
    private JLabel creators;   
    // Variables para los botones del menu.
    private JButton getOut;
    private JButton init;
    private JButton instructions;    
    // Variable para el JTextFiel de la ventana.
    public JTextField TFname;
    // Variable para colocar el fondo de la ventana.
    private BackGround background;
    //Variable para crear la ventana de instrucciones
    public static WindowsIntr instr; 
    public String playerT;
    private Controller controller;
    
    public InitialWindow(Controller controller) {
        super("Menú Principal");
        this.controller = controller;
        settWindow();
        initiaLabels();
        initButtons();
        initTextFields();
        initialWindowGame();
        initWindowsIntr();
        getOut();
       
        
    }
    
    // Método para la Configuracion de la ventana.
    public void settWindow(){
        background = new BackGround();
        this.setContentPane(background);
        this.setSize(360, 390);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
    }
    
    //metodo que se encarga de iniciar las etiquetas de la ventana.
    public void initiaLabels(){
        geometricFig = new JLabel ("Geometric");
        geometricFig.setOpaque(true);
        geometricFig.setBounds(80, 30, 200, 40);
        geometricFig.setFont(new Font("Arial Black", 1, 30));
        geometricFig.setHorizontalAlignment(SwingConstants.CENTER);
        geometricFig.setBackground(new Color(255, 255, 255, 0));
        this.add(geometricFig);  
        
        creators = new JLabel ("by:@Toky0null");
        creators.setOpaque(true);
        creators.setBounds(182, 325, 200, 30);
        creators.setFont(new Font("Arial", 0, 11));
        creators.setHorizontalAlignment(SwingConstants.CENTER);
        creators.setBackground(new Color(255, 255, 255, 0));
        this.add(creators);
        
    }
    
    //metodo que inicia los botones
    public void initButtons(){
        init = new JButton("Iniciar");
        init.setOpaque(true);
        init.setBounds(125, 175, 110, 35);
        init.setFont(new Font("Arial Black", 0, 16));
        init.setHorizontalAlignment(SwingConstants.CENTER);
        init.setBackground(new Color(240, 240, 240));
        init.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.add(init);
    
        
        instructions = new JButton ("Instruciones");
        instructions.setOpaque(true);
        instructions.setBounds(125, 230, 110, 35);
        instructions.setFont(new Font("Arial Black", 0, 11));
        instructions.setHorizontalAlignment(SwingConstants.CENTER);
        instructions.setBackground(new Color(240, 240, 240));
        instructions.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.add(instructions);
        
        
        getOut = new JButton("Salir");
        getOut.setOpaque(true);
        getOut.setBounds(125, 280, 110, 35);
        getOut.setFont(new Font("Arial Black", 0, 16));
        getOut.setHorizontalAlignment(SwingConstants.CENTER);
        getOut.setBackground(new Color(240, 240, 240));
        getOut.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.add(getOut);
        
    }
    
    // Método para crear la caja de texto de la ventana.
    public void initTextFields() {
        TFname = new JTextField(10);
        TFname.setBounds(105, 105, 150, 35);
        TextPrompt placeholder = new TextPrompt("Ingrese su nombre", TFname);
        placeholder.setFont(new Font("Arial", 2, 13));
        placeholder.setForeground(Color.lightGray);
        this.add(TFname);
    }
    
   //metodo para iniciar ventana inicio de juego
    public void initialWindowGame (){
         init.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerT = TFname.getText();
                if (!playerT.isEmpty()) {
                    controller.startGame(playerT);
                }
            }
        });
    }    
       
    public void initWindowsIntr(){
       instructions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {     
              controller.startIntroduccion();
               
            } 
        });     
         
    }    
    
    public void getOut(){
    
      getOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(InitialWindow.this, "¡Gracias por jugar! :)");
                System.exit(0);
            }
        });
    
    } 
    
    public String  getname(){
    return TFname.getText();
    }

    public void setController(Controller controller) {
       this.controller = controller;
    }
    
}




