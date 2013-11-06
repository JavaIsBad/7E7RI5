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
    static int Points=0;
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


    /**
     * Sert a faire "tomber une ligne"
     * @param n, la ligne a faire tomber
     */
    static void descendreLigne(int n){
        for (int i=0; i<=m.getX(); i++){
            m.put(i,n+1,m.get(i,n));
            m.put(i,n,false);
        }
    }

    /**
     * Détruit une ligne, et fais descendre toutes celles du dessus
     * @param n, la ligne à détruire
     */
    static void detruireLigne(int n){
        for (int i=0; i<=m.getX(); i++){ //on enleve tous les trucs de la ligne
            m.put(i,n,false);
        }
        for (int j=n-1; j>=0;j--){ //on fait descendre toutes les cases
            descendreLigne(j);
        }
    }
    /* Test si la ligne est remplie
     * @param n, la ligne a testé
     * @return true si oui, false sinon
     */
    static boolean ligneRemplie(int n){
        boolean bool = true;
        for (int i=0; i<m.getX(); i++){
            if (!(m.get(i,n)))
                bool=false;
        }
        return bool;
    }

    /**
     * Fonction servant a calculer le nombre de points gagnés par un coup
     * @param n, le nombre de ligne détruites
     * @return le nombre de points gagnés
     */
    static int compterPoints(int n){
        int pts;
        switch(n){
            case 0 :
                pts=0;
                break;
            case 1 :
                pts=40;
                break;
            case 2 :
                pts = 100;
                break;
            case 3 :
                pts = 300;
                break;
            case 4 :
                pts = 1200;
                break;
        }
        return pts;
    } 
    /**
     * Test le jeu, et regarde si des lignes ont été remplies par le coup précédent,
     * Si oui, les effaces, et attribue un score au coup
     * @return un entier, égal au nombre de point gagner par la personne
     */
    public int enleverLignesRemplies(){
        int cpt=0;
        for (int i=0; i<=m.getY(); i++){
            if (ligneRemplie(i)){
                detruireLigne(i);
                cpt++;
            }
        }
        return compterPoints(cpt);
    }

    public boolean aAtteintLeBas(Piece p){

    }

    public boolean collision(piece P){
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

