// Robot
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
// Client
import java.rmi.* ; 
import java.net.MalformedURLException ; 
import java.util.*; 

/**
 * Classe de l'IA
 */

public class IA {
    /// La matrice à laquel on se connect
    static MatriceInterface matrice;
    /// Un robot qui envoie les touches
    static Robot robot;

    /**
     * Dort ms millisecondes
     * @param ms Le temps en millisecondes
     */
    static void my_sleep(int ms)
    {
        try {
            Thread.sleep(ms);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Lance le programme exec
     * @param exec Le nom du programme
     */

    static public void run(String exec)
    {
        try {
            Runtime.getRuntime().exec(exec);
            System.out.println("IA : Wait running "+exec);
            my_sleep(1000);
        } catch (IOException ex) {
            Logger.getLogger(IA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Envoit une touche à la fenêtre
     * @param key La touche à envoyer
     */ 

    public static void send_key(int key) 
    { int k=0;
        switch (key) {
            case 0:k = KeyEvent.VK_RIGHT;	break; 	// 0:Droite
            case 1:k = KeyEvent.VK_LEFT; 	break;	// 1:Gauche
            case 2:k = KeyEvent.VK_UP;	break;	// 2:Rotation
            case 3:k = KeyEvent.VK_DOWN; 	break;	// 3:Tomber
            case 4:k = KeyEvent.VK_SPACE; break;  // 4: fall
        };
        robot.keyPress(k);
        robot.keyRelease(k); 	        
    }
    /**
     * Recoit la matrice de jeu
     * @return La matrice de jeu
     */

    public static int[][] get_matrice()
    { int [][] result=null;
        try {
            do {
                result = matrice.get_matrice();
                if (result == null) my_sleep(10);
            } while (result == null);
        } catch (RemoteException re) {System.exit(0);}
        return result;
    }
    /**
     * La fonction main
     */
    public static void main(String[] args) throws AWTException, IOException {
        try {
            robot = new Robot();
            robot.setAutoDelay(20);
            robot.setAutoWaitForIdle(false);
        } catch (AWTException ex) {
            Logger.getLogger(IA.class.getName()).log(Level.SEVERE, null, ex);
        }
        Piece []pieceia=new Piece[7];
        Piece pieceJeu=null;
        // Execution 
        run("java -cp bytecode Tetris");
        // Client
        try {
            matrice = (MatriceInterface)Naming.lookup("//localhost/matrice");
        } catch (MalformedURLException e) { System.out.println(e) ; }
        catch (NotBoundException re) { System.out.println(re) ; }
        int[] coordBasGauche=new int[2];
        int[] pieceEtSaRotation=new int[2];
        int[][] game;
        while((game=get_matrice())==null); //tente d'acceder à la matrice tant qu'elle ne peut pas
        pieceia[0]=new PieceCarre(game.length);
        pieceia[1]=new PieceL(game.length);
        pieceia[2]=new PieceF(game.length);
        pieceia[3]=new Piece4(game.length);
        pieceia[4]=new Piece4Inv(game.length);
        pieceia[5]=new PieceT(game.length);
        pieceia[6]=new PieceI(game.length);
        int []tabDePattern=new int[game.length]; // Un pattern par colonne
        while(true){
            while((game=get_matrice())==null);
            int[] basGauche=null;
            try{
                basGauche=matrice.get_coord(); //recupere la position la plus bas à gauche de la pièce
            }
            catch(Exception e){
                System.exit(0);
            }
            // Phase de depistage de la pièce
            SurfaceIa.piece(basGauche[0], basGauche[1], game, pieceEtSaRotation);  // Trouve la piece en jeu par rapport a la coordonnée la plus basse puis à gauche et retourne la rotation dans laquel elle se trouve
            if(pieceEtSaRotation[0]<=0){
                System.out.println("Piece non reconnue");
                continue;
            }
            //Phase de calcul du meilleur coup à jouer
            pieceJeu=pieceia[pieceEtSaRotation[0]-1]; // choisit la piece avec laquel on va jouer 
            pieceJeu.placerPieceAUnEndroitDonneDansLeJeuAvecUneRotationPrecise(basGauche[0], basGauche[1], pieceEtSaRotation[1], game, 0); // On efface la pièce du jeu pour eviter un calcul du jeu faussé
            SurfaceIa.rempliePattern(pieceEtSaRotation[0], tabDePattern, game); // Remplie tabDePattern avec les patterns trouvées pour chaque colonne en fonction de la piece en cours
            int[] emplacementEtRotation={0,0};
            SurfaceIa.getTheMaxiMenuBestOfPlusPlus(emplacementEtRotation, pieceEtSaRotation[0], pieceJeu, tabDePattern, game); // calcul le meilleur coup
            int nbrotationafaire=SurfaceIa.nombreDeRotationsAFairePourPasserDuneRotationALaBonneRotationPourUnePieceDonnee(pieceEtSaRotation[0], pieceEtSaRotation[1], emplacementEtRotation[1]); //calcul le nombre de rotation pour passer de la rotation dans laquel la pièce ce trouve et celle désirée avec une rotation dans le sens des aiguilles d'une montre
            if(nbrotationafaire!=0)
                send_key(3);
            for(int i=0;i<nbrotationafaire;i++){
                send_key(2);
            }
            int gauche=0;
            try{
                gauche=matrice.getGauche();
            }catch(Exception e){}
            if(gauche>emplacementEtRotation[0])
                for(;gauche>emplacementEtRotation[0];gauche--)
                    send_key(1);
            else
                for(;gauche<emplacementEtRotation[0];gauche++)
                    send_key(0);
            send_key(4);
        }
    }
} 
