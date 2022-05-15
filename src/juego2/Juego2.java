package juego2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import juego2.Movimiento.*;
import juego2.Random;


public class Juego2 extends JFrame {
    
    public JButton Play, Ram;
    public JLabel lblX, lblY, lblHP;
    public static JTextField Player1;
    public static JPanel Food;
    public static int X=350,Y=470, A=30, L=30, XX2, YY2;
    public static double XX=0,YY=0,AA=10,LL=10;
    public static boolean Game;
    public static String ch=null;
    public static int Border[]= new int[]{0,0,(500-A),(800-L)};
    public static int HitboxP1[] = new int[]{L,A};
    public static Timer timer, T2;
    
    public Juego2(){
        setTitle("Juego2");
        setLayout(null);
        setSize(820,540);
        setResizable(false);
        setLocationRelativeTo(null);
        
        Play = new JButton("Play");
        Play.setBounds(350,250,80,40);
        Play.setBackground(Color.GREEN);
        add(Play);
        
        Ram = new JButton("Random");
        Ram.setBounds(500,10,100,40);
        Ram.setBackground(Color.red);
        add(Ram);
        
        lblX = new JLabel("Coordenada X: "+ X);
        lblX.setBounds(10,10,200,30);
        add(lblX);
        
        lblY = new JLabel("Coordenada X: "+ Y);
        lblY.setBounds(200,10,200,30);
        add(lblY);
        
        Player1 = new JTextField("(*u*)");
        Player1.setBounds(X,Y,L,A);
        Player1.setBackground(Color.GREEN);
        Player1.setEditable(false);
        
        
        XX2 = Random.RandomX(XX);
        YY2 = Random.RandomY(YY);
        
        
        Food = new JPanel();
        Food.setBackground(Color.red);
        Food.setBounds(XX2,YY2,20,20);
        
        ///////////////////////////////////////// TIMER CAIDA
        /*Timer timer = new Timer(100, new ActionListener(){
                
                public void actionPerformed(ActionEvent e) {
                    if(Y < Border[2]){
                        Y = Y + 10;
                    }
                    
                    Player1.setLocation(X, Y);
                    
                }
            });
        
        */
        
        /////////////////////////////////////////TIMER SALTO
        
            
            Timer T2 = new Timer(25, new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                
                    
                        if(Y>250){
                        Y = Y-10;
                        }else{
                            
                        }
                    
                        
                    Player1.setLocation(X, Y);
                    lblY.setText("Coordenadas Y: "+Integer.toString(Y));
                        
            }
            
        });
            
        
        
            
        ////////////////////////////////////////
        
        Timer timer = new Timer(25, new ActionListener(){
                
                public void actionPerformed(ActionEvent e) {
                    if(Y < Border[2]){
                        Y = Y + 10;
                    }
                    if(Y <= 250){
                        T2.stop();
                    }
                    Player1.setLocation(X, Y);
                    lblY.setText("Coordenadas Y: "+Integer.toString(Y));
                    
                }
            });
        
        
        Ram.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent evt){
                
                XX2 = Random.RandomX(XX);
                YY2 = Random.RandomY(YY);
                    
                Food.setLocation(XX2,YY2);
                Player1.grabFocus();
                
            }
        });
        
        Play.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent evt){
                
                Play.setVisible(false);
                remove(Play);
                
                add(Player1);
                add(Food);
                Player1.grabFocus();
                
            }
        });
        
        Player1.addKeyListener(new KeyListener(){
            
            public void keyTyped(KeyEvent e) {
                
            }

            public void keyPressed(KeyEvent e) {
                ch = String.valueOf(e.getKeyChar());
                X = Movimiento.MovX(Player1, ch, X, Y, Border);
                Y = Movimiento.MovY(Player1, ch, X, Y, A, Border, T2, timer);
                    
                
                
                lblX.setText("Coordenadas X: "+Integer.toString(X));
                lblY.setText("Coordenadas Y: "+Integer.toString(Y));
            }

            
            public void keyReleased(KeyEvent e) {
                
            }
            
        });
        
        
        setDefaultCloseOperation(Juego2.EXIT_ON_CLOSE);
    }
    
    
    public static void main(String[] args) {
        
        
        new Juego2().setVisible(true);
        
        
    }
    
}
