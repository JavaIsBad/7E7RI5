// Connexion IA
import java.net.* ;
import java.rmi.* ;
// Graphique
import javax.swing.*;
// Clavier
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class tetris {

    static Matrice matrice;
    static Draw draw;
    static int rotate=1;

    static int x,y; // For example

    public static void action_right()
    { 
        // For example
        if (x<8) {
            x++;

            matrice.put(x,y,true);
            matrice.put(x+1,y,true);
            matrice.put(x-1,y,false);
            draw.refresh();
            System.err.print("0");
        }
    }

    public static void action_left()
    { 
        // For example
        if (x>1) {
            x--;
            matrice.put(x,y,true);
            matrice.put(x-1,y,true);
            matrice.put(x+1,y,false);
            draw.refresh();
            System.err.print("1");
        }
    }

    public static void action_rotation(int sens)
    { 
        // For example
        if (y>0) {
            if (sens==1){
                matrice.put(x,y,true);
                matrice.put(x,y-1,true);
                matrice.put(x+1,y,false);
                rotate=0;
            }
            else if (sens==0){
                matrice.put(x,y,true);
                matrice.put(x,y-1,false);
                matrice.put(x+1,y,true);
                rotate=1;
            }
        }
    }

    public static void action_fall()
    { 
        // For example
        if (y<19) {
            y++;
            matrice.put(x,y,true);
            draw.refresh();
            System.err.print("3");
        }
    }

    public static void action_tomber(){

        if (y<19){
            y++;
            matrice.put(x,y,true);
            matrice.put(x,y-1,false);
            draw.refresh();
            try{
                Thread.sleep(1000);}
            catch (InterruptedException re) {System.out.println(re) ;}
            System.err.print("ça tombe");
        }
    }

    public static void main(String[] args)
    {
        // Connexion IA
        try {
            matrice = new Matrice();
            Naming.rebind("matrice",matrice) ;
        } catch (RemoteException re) { System.out.println(re) ; }
        catch (MalformedURLException e) { System.out.println(e) ; }

        // Base Graphique
        JFrame f = new JFrame("TetriS");
        draw = new Draw(matrice);
        f.getContentPane().add(draw);
        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        f.pack();
        f.setVisible(true);

        // Clavier
        System.out.println("Début du jeu...");


        f.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                System.out.println("x :"+x+" y :"+y);
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_RIGHT: action_right();    break;
                    case KeyEvent.VK_LEFT:  action_left();     break;
                    case KeyEvent.VK_UP:    action_rotation(rotate); break;
                    case KeyEvent.VK_DOWN:  action_fall();     break;
                    default: action_tomber(); 			break;
                }
            }
            public void keyReleased(KeyEvent e) {
                // KEY RELEASED
            }		
        });

    }
}

