
package model;

/**
 *
 * @author tokyo
 */
public class Statistics {
    private int figureShown;
    private int attempts;
    private int failures;
    

 public Statistics (){
     
     getFigureShown();
     getAttempts(); 
     getFailures();
     setFigureShown();
     setAttempts(); 
     setFailures();
    

 }

    
 public int getFigureShown(){
  
  return figureShown;
 }
 
 
 public int getAttempts(){
 
 return attempts;

}

 public int getFailures(){
 return failures;
}
 
 public void setFigureShown(){
  
  figureShown++;
 }
 
 public void setAttempts(){
  
  attempts++;
 }
 
 public void setFailures(){
  
  failures++;
 }
 
 
}