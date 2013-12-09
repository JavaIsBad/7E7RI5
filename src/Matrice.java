import java.rmi.server.UnicastRemoteObject ;
import java.rmi.RemoteException ;

/**
 * Classe de matrice
 */

class Matrice extends UnicastRemoteObject implements MatriceInterface {
    ///La matrice vue par l'IA
    int matrice_IA[][];
    /// La matrice de jeu
    int matrice[][];
    /// Taille de la matrice
    int sizeX, sizeY;
    /// Position de la piece
    public int[] positionPiece;
    /// La position gauche de la piece
    public int positionGauche;
    /// Si refrash de matrice_IA est a true
    private boolean is_busy;

    /**
     * Constructeur de matrice
     */

    public Matrice() throws RemoteException
    {
        super();
        matrice = new int[10][20];
        matrice_IA = new int[10][20];
        positionPiece = new int[2];
        sizeX=10;
        sizeY=20;
    }

    /**
     * Renvoit la position la plus a gauche de la piece en cours
     * @return Le plus à gauche de la piece en cours
     */

    public int getGauche() throws RemoteException{
        return positionGauche;
    }


    /**
     * Renvoit la position la plus en bas a gauche de la piece en cours
     * @return Les coordonnées x et y
     */

    public int[] get_coord() throws RemoteException{
        return positionPiece;
    }

    /**
     * Renvoit la matrice de jeu
     * @return La matrice de jeu
     */

    public int[][] get_matrice() throws RemoteException {
        if (is_busy) return null;
        return matrice_IA;
    }

    /**
     * Rafraichit la matrice_IA
     */

    public void refresh()
    {  int x,y;
        is_busy = true;
        for (y=0;y<20;y++) for (x=0;x<10;x++) matrice_IA[x][y] = matrice[x][y];
        is_busy = false;
    }

    /**
     * Inscrit une valeur dans la matrice
     * @param x La coordonnée
     * @param y La deuxieme coordonnée
     * @param v La Valeure
     */

    public void put(int x,int y,int v)
    {
        matrice[x][y] = v;
    }
    /**
     * Recoit une valeur de la matrice
     * @param x La coordonnée
     * @param y La deuxieme coordonnée
     * @return La valeur a la position x,y
     */

    public int get(int x,int y)
    {
        return matrice[x][y];
    }

    /**
     * Test si quelque chose se trouve à cet endroit de la matrice
     * @param x La coordonnée
     * @param y La deuxieme coordonnée
     * @return Vrai si quelque chose s'y trouve
     */

    public boolean isSomething(int x, int y){
        boolean b=false;
        if(matrice[x][y]!=0)
            b=true;
        return b;
    }
}
