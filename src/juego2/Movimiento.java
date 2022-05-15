
package juego2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Movimiento {
    
    public static int MovY (JTextField Player1, String ch, int X, int Y, int A, int[] Border, Timer T2, Timer timer){
        //Border[]= new int[]{0,0,(500-A),(800-L)};
        
        
        
        switch(ch){
            case "s":
                /*if(Y < Border[2]){
                    Y = Y + 10;
                    
                }*/
               
                break;
            case "w":
                
                if(Y > Border[0]){
                    
                    if(Y>250){
                        T2.start();
                        timer.stop();
                        // Y = Y-10;        
                    }
                    if (Y <= 250){
                        T2.stop();
                        timer.start();
                    }
                        
                    
                    
                    
                    
                    Player1.setLocation(X, Y);
                    
                }
                
                break;
        }
            Player1.setLocation(X, Y);
            
            Timer t3 = new Timer(100, new ActionListener(){
                public void actionPerformed(ActionEvent evt){
                    
                }
            });
            return Y;
            
    }
    
    public static int MovX (JTextField Player1, String ch, int X, int Y, int[] Border){
        
        switch(ch){
            case "a":
                if(X > Border[1]){
                    X = X - 10;
                }
                
                
                break;
            case "d":
                if (X < Border[3]){
                    X = X + 10;
                }
                
                break;
                
            
        }
        Player1.setLocation(X, Y);
        
        return X;
    }
}
