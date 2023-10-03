package model;


import java.awt.*;

/**
 *
 * @author tokyo
 */
public class Player {
    private String namePlayer;
    private int log;
    
    
    public Player(String name){
    this.namePlayer = name;
    // getPlayerName();
    //setPlayerName();
      getPlayerLg ();
    }
    
    public String getPlayerName (){

     return namePlayer;
    }  

    public void setPlayerName(){
    
     namePlayer = "User";
    }
    
    public int getPlayerLg (){
    
    log = namePlayer.length();
    return log;
    }
}
