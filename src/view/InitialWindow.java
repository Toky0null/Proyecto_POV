
package view;

    import javax.swing.*;
    import java.awt.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.awt.Font;
   // import controller.Controlador;
    import model.Music;
    import model.Player;
/**
 *
 * @author Soporte
 */
public class InitialWindow extends JFrame {
    
    // Variables para los JLabel de la ventana.
    private JLabel L_geometricFig;
    private JLabel L_creators;
   
    
    // Variables para los botones del menu.
    private JButton B_getOut;
    private JButton B_init;
    private JButton B_instructions;
    
    // Variable para el JTextFiel de la ventana.
    private JTextField TFname;
   // Marcar que el sonido se ha iniciado 
    public boolean soundstarted;
    
    // Variable para colocar el fondo de la ventana.
    private BackGround background;
    // Variable que crea la ventana del juego.
    private static LevelOne level1;
    // Variable para guardar el nombre del jugador.
    public static String player;
    //Variable para crear la ventana de instrucciones
    public static WindowsIntr instr; 
    private Player playert;
    
    
    public InitialWindow() {
        super("Menú Principal");
        settWindow();
        initLabels();
        initButtons();
        initTextFields();
        initWindowGame();
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
    
    //metodo que inicia los botones
    public void initButtons(){
        B_init = new JButton("Iniciar");
        B_init.setOpaque(true);
        B_init.setBounds(125, 175, 110, 35);
        B_init.setFont(new Font("Arial Black", 0, 16));
        B_init.setHorizontalAlignment(SwingConstants.CENTER);
        B_init.setBackground(new Color(240, 240, 240));
        B_init.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.add(B_init);
    
        
        B_instructions = new JButton ("Instruciones");
        B_instructions.setOpaque(true);
        B_instructions.setBounds(125, 230, 110, 35);
        B_instructions.setFont(new Font("Arial Black", 0, 11));
        B_instructions.setHorizontalAlignment(SwingConstants.CENTER);
        B_instructions.setBackground(new Color(240, 240, 240));
        B_instructions.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.add(B_instructions);
        
        
        B_getOut = new JButton("Salir");
        B_getOut.setOpaque(true);
        B_getOut.setBounds(125, 280, 110, 35);
        B_getOut.setFont(new Font("Arial Black", 0, 16));
        B_getOut.setHorizontalAlignment(SwingConstants.CENTER);
        B_getOut.setBackground(new Color(240, 240, 240));
        B_getOut.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.add(B_getOut);
        
    }
    
     // Método para crear la caja de texto de la ventana.
    public void initTextFields() {
        TFname = new JTextField(10);
        TFname.setBounds(105, 105, 150, 35);
        TextPrompt placeholder = new TextPrompt("Ingrese su sombre", TFname);
        placeholder.setFont(new Font("Arial", 2, 13));
        placeholder.setForeground(Color.lightGray);
        this.add(TFname);
    }
    
   //metodo para iniciar ventana inicio de juego
    public void initWindowGame (){
        B_init.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                
                playert = new Player(TFname.getText());
                if (playert.getPlayerLg()== 0) {
                    playert.setPlayerName();
                }

                level1 = new LevelOne(playert.getPlayerName());
                

                // Controlador
                //controller buffer = new controller();
                //level *****.addKeyListener();

            if (!soundstarted){
                
                Music soundtrack = new Music();
                soundtrack.soundtrackstart();
                soundstarted = true; // Marcar que el sonido se ha iniciado
           
                }
             level1.setVisible(true); 
            }
        });     
    }    
        
    public void initWindowsIntr(){
       B_instructions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                
                

                instr = new WindowsIntr();

                // Controlador
                //controller buffer = new controller();
                //level *****.addKeyListener();

                instr.setVisible(true); 
            }
        });     
        
    }    
    
    public void getOut(){
    
      B_getOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(InitialWindow.this, "¡Gracias por jugar! :)");
                System.exit(0);
            }
        });
    
    } 
    
}




