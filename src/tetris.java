// Connexion IA
import java.net.* ;
import java.rmi.* ;
// Graphique
import javax.swing.*;
// Clavier
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class tetris {

    static Piece[] piecejeu= new Piece[7];
    static Piece pieceEnCours;
    static Matrice matrice;
    static Draw draw;
    static int Points=0;

    // useless
    static int encours=0;

    public static void action_right()
    {
        pieceEnCours.effacerPiece(matrice);
        pieceEnCours.droite();
        if(collision(pieceEnCours))
            pieceEnCours.gauche();
        pieceEnCours.dessinerPiece(matrice);
        draw.refresh();
    }

    public static void action_left()
    {
        pieceEnCours.effacerPiece(matrice);
        pieceEnCours.gauche();
        if(collision(pieceEnCours))
            pieceEnCours.droite();
        pieceEnCours.dessinerPiece(matrice);
        draw.refresh();
    }

    public static void action_rotation()
    {
        pieceEnCours.effacerPiece(matrice);
        pieceEnCours.rotationner();
        if(collision(pieceEnCours))
            pieceEnCours.antirotation();
        pieceEnCours.dessinerPiece(matrice);
        draw.refresh();
    }

    public static void action_fall()
    {
        pieceEnCours.effacerPiece(matrice);
        pieceEnCours.tomberPiece();
        if(collision(pieceEnCours)){
            pieceEnCours.remonterPiece();
            pieceEnCours.dessinerPiece(matrice);
            Points+=enleverLignesRemplies();
            itsShowTime();
        }
        else{
            pieceEnCours.dessinerPiece(matrice);
            draw.refresh();
        }
    }

    public static void action_tomber(){
        pieceEnCours.effacerPiece(matrice);
        encours=(encours+1)%7;
        pieceEnCours=piecejeu[encours];
        pieceEnCours.dessinerPiece(matrice);
        draw.refresh();
    }


    /**
     * Sert a faire "tomber une ligne"
     * @param n, la ligne a faire tomber
     */
    static void descendreLigne(int n){
        for (int i=0; i<matrice.sizeX; i++){
            matrice.put(i,n+1,matrice.get(i,n));
            matrice.put(i,n,false);
        }
    }

    /**
     * Détruit une ligne, et fais descendre toutes celles du dessus
     * @param n, la ligne à détruire
     */
    static void detruireLigne(int n){
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
        for (int i=0; bool && i<matrice.sizeX; i++)
            bool=bool && matrice.get(i,n);
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
            default :
                pts=0;
                break;
        }
        return pts;
    } 
    /**
     * Test le jeu, et regarde si des lignes ont été remplies par le coup précédent,
     * Si oui, les effaces, et attribue un score au coup
     * @return un entier, égal au nombre de point gagner par la personne
     */
    public static int enleverLignesRemplies(){
        int cpt=0;
        for (int i=0; i<matrice.sizeY; i++){
            if (ligneRemplie(i)){
                detruireLigne(i);
                i--;
                cpt++;
            }
        }
        return compterPoints(cpt);
    }

    static public boolean collision(Piece P){
        boolean colli=true;
        int x[]=P.getX();
        int y[]=P.getY();
        for(int i=0; colli && i< x.length; i++)
            colli= colli && !(x[i]>= matrice.sizeX || x[i] < 0 || y[i] >= matrice.sizeY || y[i] < 0 || (matrice.get(x[i],y[i])));
        return !colli;
    }

    static void finDuJeu(){
        System.out.println("Nombre de points : "+Points);
        System.exit(0);
    }

    static void itsShowTime(){ // fonction du jeu
            pieceEnCours=piecejeu[(int)(Math.random()*7)];
            pieceEnCours.reinit();
            if(collision(pieceEnCours))
                finDuJeu();
            pieceEnCours.dessinerPiece(matrice);
            draw.refresh();
    }

    public static void main(String[] args)
    {
        // Connexion IA
        try {
            matrice = new Matrice();
            Naming.rebind("matrice",matrice) ;
        } catch (RemoteException re) { System.out.println(re) ; }
        catch (MalformedURLException e) { System.out.println(e) ; }

        piecejeu[0]=new Piece4(matrice);
        piecejeu[1]=new Piece4Inv(matrice);
        piecejeu[2]=new PieceCarre(matrice);
        piecejeu[3]=new PieceF(matrice);
        piecejeu[4]=new PieceL(matrice);
        piecejeu[5]=new PieceT(matrice);
        piecejeu[6]=new PieceI(matrice);

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
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_RIGHT: action_right();    break;
                    case KeyEvent.VK_LEFT:  action_left();     break;
                    case KeyEvent.VK_UP:    action_rotation(); break;
                    case KeyEvent.VK_DOWN:  action_fall();     break;
                    default: action_tomber(); break;
                }
            }
            public void keyReleased(KeyEvent e) {
            }
        });

        itsShowTime();

    }

}

