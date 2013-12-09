/**
 * Classe d'une piece4Inv
 * @author SCHMITT Maxime && SCHIMCHOWITSCH Raphaël
 */

/**
 *  [ 3 ][ 2 ]
 * 	    [ 0 ][ 1 ]
 * -----------------------
 *           [ 3 ]
 *      [ 0 ][ 2 ]
 *      [ 1 ]
 */
public class Piece4Inv extends Piece{
    ///Le nombre maximum de rotation de la pièce
    public int maxRotation=2;

    /**
     * Constructeur de Piece4Inv
     * @param sizeX, le nombre de colonne de la matrice
     */
    public Piece4Inv(int sizex){
        xMid=new int[4];
        yMid=new int[4];
        x=new int[4];
        y=new int[4];
        initPosition(sizex);
        rotation=0;
    }

    /**
     * Initialise la position de la Piece
     * @param sizex, le nombre de colonne de la matrice
     */
    private void initPosition(int sizex){
        int mid= sizex/2;
        xMid[0]=mid;
        yMid[0]=1;
        xMid[1]=mid+1;
        yMid[1]=1;
        xMid[2]=mid;
        yMid[2]=0;
        xMid[3]=mid-1;
        yMid[3]=0;
    }

    /**
     * Effectue la rotation de la piece vers la gauche
     */
    public void rotationner(){
        if(rotation==0){ // déjà en position de rotation
            x[1]-=1;
            y[1]-=1;
            x[2]-=1;
            y[2]+=1;
            y[3]+=2;
            rotation=1;
        }
        else{
            x[1]+=1;
            y[1]+=1;
            x[2]+=1;
            y[2]-=1;
            y[3]-=2;
            rotation=0;
        }
    }

    /**
     * Effectue la rotation vers la droite de la piece
     */
    public void antirotation(){
        rotationner(); // ici il suffit de faire une rotation pour revenir aux positions de départ
    }

    /**
     * Réinitialise les coordonnées de la pièce comme elles sont lors de son apparition
     */
    public void reinit(){
        super.reinit();
        rotation=0;
    }

    /**
     * Renvoie le nombre maximum de rotation de la piece
     *@return le nombre maximale de rotation d'une piece
     */
    public int getrotation(){
        return maxRotation;
    }

    /**
     * Regarde si la piece est une Piece4Inv
     * @param x, la colonne de la case la plus en bas a gauche de la piece
     * @param y, la ligne de la case la plus en bas a gauche de la piece
     * @param game, le jeu dans lequel on se trouve
     * @param tab, tableau dans lequel on trouve la piece et la rotation
     */
    public static void isMe(int x, int y, int[][] game ,int[] tab){
        if(x+1<game.length && x-1>=0 && y-1>=0 && game[x][y]!=0 && game[x+1][y]!=0 && game[x][y-1]!=0 && game[x-1][y-1]!=0){
            tab[0]=5;
            tab[1]=0;
        }
        else{
            if(y-2>=0 && game[x][y]!=0 && game[x][y-1]!=0 && game[x+1][y-1]!=0 && game[x+1][y-2]!=0){
                tab[0]=5;
                tab[1]=1;
            }
            else{
                tab[0]=0;
            }
        }
    }

}
