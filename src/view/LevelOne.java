/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author Soporte
 */
public class LevelOne extends JFrame {
    private JLabel L_up;
    private JLabel figure1;
    private JLabel figure2;
    private JLabel figure3;
    private JLabel figureShown;
    private JLabel attempts;
    private JLabel failures;
   //paneles de posiscionamiento 
    private JPanel panel;
    private JPanel panelFigures;
    private JPanel panelF1;
    private JPanel panelF2;
    private JPanel panelF3;
   // private JPanel figures;
    private JPanel panelUp;
    private Border borderPanelUp;
    
    
    // Variable para los boton del juego.
    private JButton getOutL1;
    /**
     * Constructor de la clase que recibe el nombre del jugador
     * @param namePlayer nombre del jugador
     */
    public LevelOne(String namePlayer ){
        //Establecemos el título de la ventana con el nombre del jugador
        super("Geometric-Jugador: " + namePlayer);
        settWindowLv();
        settPanelUp();
        
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
       
       
    //panel para las figuras (parte central)
    // panelUp.setBorder(borderPanelUp);
       panelFigures = new JPanel();
       panelFigures.setLayout(new GridLayout(1,3));
    //panel y posicionamiento de la primera imagen  
       panelF1 = new JPanel();
       figure1 = new JLabel("test");
       panelF1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
       panelF1.add(figure1);
      
    //panel y posicionamiento de la segunda imagen     
       panelF2 = new JPanel();
       figure2 = new JLabel("test");
       panelF2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
       panelF2.add(figure2);
      
  //panel y posicionamiento de la primera imagen    
       panelF3 = new JPanel();
       figure3 = new JLabel("test");
       panelF3.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
       panelF3.add(figure3);
  
      
       panelFigures.add(panelF1);
       panelFigures.add(panelF2);
       panelFigures.add(panelF3);
    /**    panel = getContentPane();
        //Solicitamos el foco en el panel
        panel.requestFocus();
        //Habilitamos la solicitud automática de foco en el panel
        setAutoRequestFocus(true);
        //Establecemos el layout del panel
        panel.setLayout((new FlowLayout()));
        
        
     */
       getOutL1 = new JButton("Salir");
       getOutL1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cierra solo la ventana actual
            }
        });
     
       panel.add(panelFigures,BorderLayout.CENTER);
       panel.add(getOutL1,BorderLayout.SOUTH);
       add(panel);
   
    }

    private void settPanelUp() {
          
       
       //panel para mostrar estadisticas (parte superiro)
       panelUp = new JPanel();      
       panelUp.setLayout(new GridBagLayout());
       
       
       // Crear un borde visible (en este caso, un borde de línea negra)
       borderPanelUp = new LineBorder(Color.BLACK,2);
       // Aplicar el borde al panel
       panelUp.setBorder(borderPanelUp);
       
       // Agregar contenido al panel (etiquetas de estadísticas)
       /** 
       L_up = new JLabel("Estadisticas");
       GridBagConstraints gbcLabelUp = new GridBagConstraints ();
       gbcLabelUp.gridx = 9;
       gbcLabelUp.gridy = 1;
       gbcLabelUp.insets = new Insets(10, 10, 60, 10); // Espaciado
       panelUp.add(L_up, gbcLabelUp);
         */
       
       figureShown = new JLabel ("Figuras Mostradas: ");
       GridBagConstraints gbcLabelFihureShown = new GridBagConstraints ();
       gbcLabelFihureShown.gridx = 3;
       gbcLabelFihureShown.gridy = 1;
       gbcLabelFihureShown.insets = new Insets(20,10,20,10);
       panelUp.add(figureShown,gbcLabelFihureShown);
       
        attempts = new JLabel ("Intentos: ");
        GridBagConstraints gbcLabelaAttempts =  new GridBagConstraints ();
        gbcLabelaAttempts.gridx = 1;
        gbcLabelaAttempts.gridy = 1;
        gbcLabelaAttempts.insets = new Insets(20,10,20,10);
        panelUp.add(attempts,gbcLabelaAttempts);
        
        failures = new JLabel ("Fallos: ");
        GridBagConstraints gbcLabelFailure =  new GridBagConstraints ();
        gbcLabelFailure.gridx = 4;
        gbcLabelFailure.gridy = 1;
        gbcLabelFailure.insets = new Insets(20,10,20,10);
        panelUp.add(failures,gbcLabelFailure);
     
       panel.add(panelUp,BorderLayout.NORTH);
        
    }
      
    
    
    
    
    }


