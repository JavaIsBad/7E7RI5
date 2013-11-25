// Connexion IA
import java.net.* ;
import java.rmi.* ;
// Graphique
import javax.swing.JFrame;
import javax.swing.WindowConstants;
// Clavier
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class Tetris {

    public static void main(String[] args)
    {
        Matrice matrice=null;
        Piece[] piecejeu=new Piece[7];
        // Connexion IA
        try {
            matrice = new Matrice();
            Naming.rebind("matr",matrice) ;
        } catch (RemoteException re) { System.out.println(re); System.exit(42); }
        catch (MalformedURLException e) { System.out.println(e) ; System.exit(43); }

        piecejeu[0]=new Piece4(matrice);
        piecejeu[1]=new Piece4Inv(matrice);
        piecejeu[2]=new PieceCarre(matrice);
        piecejeu[3]=new PieceF(matrice);
        piecejeu[4]=new PieceL(matrice);
        piecejeu[5]=new PieceT(matrice);
        piecejeu[6]=new PieceI(matrice);

        // Base Graphique
        JFrame f = new JFrame("TetriS");
        GameWindow gamewindow = new GameWindow(matrice);
        f.getContentPane().add(gamewindow);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);


        // Clavier
        System.out.println("Début du jeu...");
        final Jeu j=new Jeu(piecejeu, matrice, gamewindow);

        f.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_RIGHT: j.action_right();    break;
                    case KeyEvent.VK_LEFT:  j.action_left();     break;
                    case KeyEvent.VK_UP:    j.action_rotation(); break;
                    case KeyEvent.VK_DOWN:  j.action_fall();     break;
                    case KeyEvent.VK_SPACE:  j.action_tomber();     break;
                    default: break;
                }
            }
            public void keyReleased(KeyEvent e) {
            }
        });
        j.itsShowTime();
    }

}

