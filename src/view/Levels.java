
package view;

import controller.Controller;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Random;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import model.Statistics;

/**
 *
 * @author tokyo
 */
public class Levels extends JFrame {
//private JLabel L_up;
    private JLabel figure1,figure2,figure3;
    private JLabel figureFocus;
    private JLabel figureShown;
    private JLabel attempts;
    private JLabel failures;
//paneles de posiscionamiento 
    private JPanel panel;
    private JPanel mainPanelFigures;
    private JPanel focusPanel;
    private JPanel panelFigures;
    private JPanel panelF1;
    private JPanel panelF2;
    private JPanel panelF3;
    private ImageIcon pictureFocus;
    private ImageIcon picture1;
    private ImageIcon picture2;
    private ImageIcon picture3;  
// private JPanel figures;
    private JPanel panelUp;
    private Border borderPanelUp;
//Variables de juego
    private int winnerP;   
    private int imgR;
    
// Variable para los boton del juego.
    private JButton getOutL1;
    private Statistics statisicsGame;
//Controlador
    private Controller controllerGame;
    private String[] imageGroup;
    private  int groupSize;
    private EndGameWindow endGame; 
    /**
     * Constructor de la clase que recibe el nombre del jugador
     * @param namePlayer nombre del jugador
     */
    public Levels(String namePlayer ){
        //Establecemos el título de la ventana con el nombre del jugador
        super("Geometric-Jugador: " + namePlayer);
        statisicsGame = new Statistics();
        controllerGame = new Controller();
        imageGroup = controllerGame.getRandomImageGroup();
        settWindowLv();
        settPanelUp();
        settPanelFgures();
        updateStatisticsLabels();
        updateWindow();
        
        }
    
    public void settWindowLv(){
    //Establecemos el tamaño de la ventana
        setSize(976, 656);
    //Establecemos la operación al cerrar la ventana
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    //Establecemos la posición de la ventana en la pantalla
        setLocationRelativeTo(null);      
    //Establecemos el panel de contenido de la ventana (panel princilpal
       panel = new JPanel();
       panel.setLayout(new BorderLayout()); 
         
       getOutL1 = new JButton("Terminar Partida");
       getOutL1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                endGame = new EndGameWindow(statisicsGame.getAttempts(),statisicsGame. getSucesses(),statisicsGame.getFailures());
                endGame.setVisible(true);
                
            }
        });
        
       panel.add(getOutL1,BorderLayout.SOUTH);
       add(panel);
   
    }
//metodo de panel para las labels (parte superior)
    private void settPanelUp() {
          
       
//panel para mostrar estadisticas (parte superiro)
       panelUp = new JPanel();      
       panelUp.setLayout(new GridBagLayout());
       
       
// Crear un borde visible (en este caso, un borde de línea negra)
       borderPanelUp = new LineBorder(Color.BLACK,2);
// Aplicar el borde al panel
       panelUp.setBorder(borderPanelUp);
       
       figureShown = new JLabel ("Figuras Mostradas: " + statisicsGame.getFigureShown());
       GridBagConstraints gbcLabelFihureShown = new GridBagConstraints ();
       gbcLabelFihureShown.gridx = 3;
       gbcLabelFihureShown.gridy = 1;
       gbcLabelFihureShown.insets = new Insets(20,10,20,10);
       panelUp.add(figureShown,gbcLabelFihureShown);
       
        attempts = new JLabel ("Intentos: " + statisicsGame.getAttempts());
        GridBagConstraints gbcLabelaAttempts =  new GridBagConstraints ();
        gbcLabelaAttempts.gridx = 1;
        gbcLabelaAttempts.gridy = 1;
        gbcLabelaAttempts.insets = new Insets(20,10,20,10);
        panelUp.add(attempts,gbcLabelaAttempts);
        
        failures = new JLabel ("Fallos: " + statisicsGame.getFailures());
        GridBagConstraints gbcLabelFailure =  new GridBagConstraints ();
        gbcLabelFailure.gridx = 4;
        gbcLabelFailure.gridy = 1;
        gbcLabelFailure.insets = new Insets(20,10,20,10);
        panelUp.add(failures,gbcLabelFailure);
     
       panel.add(panelUp,BorderLayout.NORTH);
        
    }
    
    
//metodo de panel para las figuras (parte central)
    private void settPanelFgures() { 
        
    groupSize = imageGroup.length;
    winnerP = controllerGame.getnumWinner(groupSize);
    imgR = controllerGame.getnumImg();
    //CARGAR IMAGENES 
     pictureFocus = controllerGame.getImageByIndex(imgR,winnerP);
     picture1 = controllerGame.getImageByIndex(imgR,0);
     picture2 =controllerGame.getImageByIndex(imgR,1);
     picture3 = controllerGame.getImageByIndex(imgR,2);
     
    // Crear el panel principal con un GridLayout de 1x4
       mainPanelFigures = new JPanel (new GridLayout(2, 4)); //(new BorderLayout())
       
    // Panel izquierdo (no interactivo)
       focusPanel = new JPanel();
       figureFocus = new JLabel(pictureFocus);
       focusPanel.add(figureFocus);
       focusPanel.setBackground(Color.GRAY);
       focusPanel.setPreferredSize(new Dimension(200,350)); // ajuste de tamaño
       mainPanelFigures.add(focusPanel); //mainPanelFigures.add(focusPanel, BorderLayout.WEST);
       
       
    
       panelFigures = new JPanel();
       panelFigures.setLayout(new GridLayout(1,3));
       mainPanelFigures.add(panelFigures);
    //panel y posicionamiento de la primera imagen  
       panelF1 = new JPanel();
       figure1 = new JLabel(picture1);
       panelF1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
       panelF1.add(figure1);
       
    // Agrega un ActionListener al panelF1 
        panelF1.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseClicked(java.awt.event.MouseEvent evt) {
        // Muestra un mensaje al hacer clic en el panel
        if(winnerP == 0){
            JOptionPane.showMessageDialog(null, "¡Bien hecho!"); 
            statisicsGame.setFigureShown();
            statisicsGame.setAttempts();
            statisicsGame.setSuccesses();
            updateWindow();
        }
        else{
        statisicsGame.setFailures();
        statisicsGame.setAttempts();
        updateStatisticsLabels();
        }   
        
          }
        });
      
    //panel y posicionamiento de la segunda imagen     
       panelF2 = new JPanel();
       figure2 = new JLabel(picture2);
       panelF2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
       panelF2.add(figure2);
       
    // Agrega un ActionListener al panelF2
        panelF2.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseClicked(java.awt.event.MouseEvent evt) {
        // Muestra un mensaje al hacer clic en el panel
        if(winnerP == 1){
            JOptionPane.showMessageDialog(null, "¡Bien hecho!");  
            statisicsGame.setFigureShown();
            statisicsGame.setAttempts();
            statisicsGame.setSuccesses();
            updateWindow();
        }
        else{
        statisicsGame.setFailures();
        statisicsGame.setAttempts();
        updateStatisticsLabels();
        }   
           
          }
        });
    //panel y posicionamiento de la primera imagen    
       panelF3 = new JPanel();
       figure3 = new JLabel(picture3);
       panelF3.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
       panelF3.add(figure3);
  
    // Agrega un ActionListener al panelF1 
        panelF3.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseClicked(java.awt.event.MouseEvent evt) {
        // Muestra un mensaje al hacer clic en el panel
        
        
        if(winnerP == 2){
            JOptionPane.showMessageDialog(null, "¡Bien hecho!");  
            statisicsGame.setFigureShown();
            statisicsGame.setAttempts();
            statisicsGame.setSuccesses();
            updateWindow(); 
        }
        else{
        statisicsGame.setFailures();
        statisicsGame.setAttempts();
        updateStatisticsLabels();
        }   
        
        
          }
        });  
        
       panelFigures.add(panelF1);
       panelFigures.add(panelF2);
       panelFigures.add(panelF3);
    
       panel.add(mainPanelFigures,BorderLayout.CENTER);
    
    }

    
    
//metodo para actualizar las estadisticas constantemente 
    private void updateStatisticsLabels() {
        
        figureShown.setText("Figuras Mostradas: " + statisicsGame.getFigureShown());
        attempts.setText("Intentos: " + statisicsGame.getAttempts());
        failures.setText("Fallos: " + statisicsGame.getFailures());
    }

    private void updateWindow() {
    // Genera nuevos valores aleatorios para el ganador y el arreglo de imágenes
    groupSize = imageGroup.length;
    winnerP = controllerGame.getnumWinner(groupSize);
    imgR = controllerGame.getnumImg();

    // Carga las nuevas imágenes en los JLabel
    pictureFocus = controllerGame.getImageByIndex(imgR, winnerP);
    picture1 = controllerGame.getImageByIndex(imgR, 0);
    picture2 = controllerGame.getImageByIndex(imgR, 1);
    picture3 = controllerGame.getImageByIndex(imgR, 2);

    // Actualiza los JLabel de las imágenes
    figureFocus.setIcon(pictureFocus);
    figure1.setIcon(picture1);
    figure2.setIcon(picture2);
    figure3.setIcon(picture3);

    // Actualiza las estadísticas en la ventana
    updateStatisticsLabels();
    }

    
}


