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

/**
 *
 * @author Soporte
 */
public class LevelOne extends JFrame {
    private JLabel L_up;
    private JLabel figure1;
    private JLabel figure2;
    private JLabel figure3;
   //paneles de posiscionamiento 
    private JPanel panel;
    private JPanel panelFigures;
    private JPanel panelF1;
    private JPanel panelF2;
    private JPanel panelF3;
    private JPanel figures;
    private JPanel panelUp;
    
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
       
       //panel para mostrar estadisticas (parte superiro)
       panelUp = new JPanel();
       L_up = new JLabel("Estadisticas");
       panelUp.add(L_up);
       
       //panel para las figuras (parte central)
       
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
    panel.add(panelUp,BorderLayout.NORTH);
    panel.add(panelFigures,BorderLayout.CENTER);
    panel.add(getOutL1,BorderLayout.SOUTH);
    add(panel);
   
    }
    
}
