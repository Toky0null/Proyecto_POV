
package model;

/**
 *
 * @author tokyo
 */
public class Statistics {
    private int figureShown;
    private int attempts;
    private int failures;
    private int successes;
    

 public Statistics (){
     
    getFigureShown();
    getAttempts(); 
    getFailures();
    getSucesses();
    setFigureShown();
    setAttempts(); 
    setFailures();
    setSuccesses();
    figureShown = 1;
    attempts = 0;
    failures = 0;
    successes = 0;

 }

//metodos para obtener los varoles de las variables locales
 public int getFigureShown(){
  
  return figureShown;
 }

 public int getAttempts(){
 
 return attempts;

}

public int getFailures(){
    return failures;
}
 
public int getSucesses(){
 
    return successes;
 
}
 //metodos para modificar los varoles de las variables locales
 public void setFigureShown(){
    figureShown++;
}
 
 public void setAttempts(){
    attempts++;
 }
 
 public void setFailures(){
    failures++;
 }
 
 public void setSuccesses(){
    successes ++;
 }
 
}