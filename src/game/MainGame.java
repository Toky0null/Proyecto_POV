/**
 *
 * @author tokyo - Juna Sebastian Hurtado Batioja 2179288
 * @author kevin David Londoño Valencia-2224551
 */
package game;

import controller.Controller;
import view.InitialWindow;
import view.WindowsIntr;


public class MainGame {
    
    public static void main(String[] args) {     
       Controller controller = new Controller();
        // Crear una instancia de InitialWindow y pasar el controlador como argumento
        InitialWindow initialWindow = new InitialWindow(controller);
        // Mostrar la ventana inicial
        initialWindow.setVisible(true);
    }
    
}