
package juego2;


public class Random {
    public static int RandomX(double XX){
        
        
        do{
        XX = Math.random()*1000;
        
        
        
        }while(XX>770);
        int XX2 = (int)XX;
        return XX2;
        
    }
    
    public static int RandomY(double YY){
        
        
        do{
            
            YY = Math.random()*1000;
            
        }while(YY>470);
        int YY2 = (int) YY;
        
        return YY2;
    }
}
