
package game;

import controller.Controller;
import view.InitialWindow;
import view.WindowsIntr;

/**
 *
 * @author tokyo
 */
public class MainGame {
    
    public static void main(String[] args) {     
       Controller controller = new Controller();
        // Crear una instancia de InitialWindow y pasar el controlador como argumento
        InitialWindow initialWindow = new InitialWindow(controller);
        // Mostrar la ventana inicial
        initialWindow.setVisible(true);
    }
    
}