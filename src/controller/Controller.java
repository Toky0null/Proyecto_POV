/**
 *
 * @author tokyo - Juna Sebastian Hurtado Batioja 2179288
 * @author kevin David Londoño Valencia-2224551
 */

package controller;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.util.Random;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Music;
import model.Player;
import view.InitialWindow;
import view.Levels;
import view.WindowsIntr;


public class Controller {
    private int num1, num2;
    private Random random,randomImg;
    private InitialWindow initialWindows;
    private WindowsIntr windowsIntr;
    private Player player;
    private Levels levels;
    private Music soundtrack;
    private boolean soundStarted;
    private float volume;
  
     
    private static final String[][] IMAGE_GROUPS = {
    {  
    "/view/img/level1/box.png",
    "/view/img/level1/box2.png",
    "/view/img/level1/box3.png"
    },
        
    {
        
    "/view/img/level2/triangle.png",
    "/view/img/level2/triangle2.png",
    "/view/img/level2/triangle3.png" 
        
    },
    
    {
        
    "/view/img/level3/pentagon.png",
    "/view/img/level3/pentagon2.png",
    "/view/img/level3/pentagon3.png" 
    },
    {
        
    "/view/img/level4/rectangle.png",
    "/view/img/level4/rectangle2.png",
    "/view/img/level4/rectangle3.png" 
        
    },
    
    {
        
    "/view/img/level5/star.png",
    "/view/img/level5/star2.png",
    "/view/img/level5/star3.png" 
        
    }
    
            
    };
    
     private List <String[]> unusedImageGroups;
     
     public Controller(){
       random = new Random();
       randomImg = new Random(); 
       unusedImageGroups = new ArrayList<>();
       this.soundStarted = false;
       initialWindows = new InitialWindow(this);
       windowsIntr = new WindowsIntr(this);
       // Agregar todos los grupos de imágenes a la lista de no utilizados
        Collections.addAll(unusedImageGroups, IMAGE_GROUPS);
        // Mezclar la lista para obtener grupos aleatorios
        Collections.shuffle(unusedImageGroups);
   } 
    /** 
    private static final ImageIcon[] IMAGES = new ImageIcon[IMAGE_PATHS.length];

    static {
        try {
            for (int i = 0; i < IMAGE_PATHS.length; i++) {
                IMAGES[i] = new ImageIcon(ImageIO.read(Controller.class.getResource(IMAGE_PATHS[i])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    */
    public ImageIcon getImageByIndex(int groupIndex, int imageIndex) {
        if (groupIndex >= 0 && groupIndex < IMAGE_GROUPS.length && imageIndex >= 0 && imageIndex < IMAGE_GROUPS[groupIndex].length) {
            try {
                return new ImageIcon(ImageIO.read(Controller.class.getResource(IMAGE_GROUPS[groupIndex][imageIndex])));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

   

    public int getnumWinner(int groupSize) {
        
        num1 = random.nextInt(groupSize);
        return num1;
    }
    
     public int getnumImg() {
        
        num2 = randomImg.nextInt(0,5);
        return num2;
    }

    public String[] getRandomImageGroup() {
        if (!unusedImageGroups.isEmpty()) {
            return unusedImageGroups.remove(0);
        } else {
            return null; // Se han utilizado todos los grupos de imágenes
        }
    }
    
    
    public void startGame(String playerName) {
        player = new Player(playerName);
    
        if (playerName.isEmpty()) {
        playerName = "User";
        }
        
        levels = new Levels(playerName, this);

        if (!soundStarted) {
            soundtrack = new Music();
            volume = -15.0f;
            soundtrack.soundtrackstart(volume);
            soundStarted = true;
        }

        levels.setVisible(true);
    }

    public void startIntroduccion (){
    
     windowsIntr.setVisible(true);
    
    } 
    
    public void getPlayErrorSound(){
         soundtrack.playErrorSound();
    }
     public void getpPlayCorrectSound(){
         soundtrack.playCorrectSound();
    }
    
}
