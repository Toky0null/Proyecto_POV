/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import javax.swing.*;
import java.awt.*;
/**
 *
 * @author Soporte
 */
public class WindowsIntr extends JFrame {
     public Container paneIntr;
     
     public WindowsIntr(){
        super("Geometric-Manual de instrucciones: ");
        setSize(976, 656);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        //Establecemos el panel de contenido de la ventana
        paneIntr = getContentPane();
        //Solicitamos el foco en el panel
        paneIntr.requestFocus();
        //Habilitamos la solicitud automática de foco en el panel
        setAutoRequestFocus(true);
        //Establecemos el layout del panel
        paneIntr.setLayout((new FlowLayout()));
     
     
     } 
}
