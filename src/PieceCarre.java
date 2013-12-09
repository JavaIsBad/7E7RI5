/**
 * Classe d'une pieceCarre
 * @author SCHMITT Maxime && SCHIMCHOWITSCH Raphaël
 */

/**
 * [ 1 ][ 0 ]
 * [ 2 ][ 3 ]
 */

public class PieceCarre extends Piece{
	///Le nombre maximum de rotation de la pièce
	public int maxRotation=0;

/**
 * Constructeur de PieceCarre
 * @param sizeX, le nombre de colonne de la matrice
 */
    public PieceCarre(int sizex){
        xMid=new int[4];
        yMid=new int[4];
        x=new int[4];
        y=new int[4];
        initPosition(sizex);
    }

/**
   * Initialise la position de la Piece
   * @param sizex, le nombre de colonne de la matrice
   */
    private void initPosition(int sizex){
        int mid= sizex/2;
        xMid[0]=mid;
        yMid[0]=0;
        xMid[1]=mid-1;
        yMid[1]=0;
        xMid[2]=mid-1;
        yMid[2]=1;
        xMid[3]=mid;
        yMid[3]=1;
    }

/**
 * Effectue la rotation de la piece vers la gauche
 */
    public void rotationner(){
    }

/**
 * Effectue la rotation vers la droite de la piece
 */
    public void antirotation(){
    }
    
    /**
     * Renvoie le nombre maximum de rotation de la piece
     *@return le nombre maximale de rotation d'une piece
     */
    public int getrotation(){
		return maxRotation;
	}
	
	/**
	 * Regarde si la piece est une PieceCarre
	 * @param x, la colonne de la case la plus en bas a gauche de la piece
	 * @param y, la ligne de la case la plus en bas a gauche de la piece
	 * @param game, le jeu dans lequel on se trouve
	 * @param tab, tableau dans lequel on trouve la piece et la rotation
	 */
	public static void isMe(int x, int y, int[][] game ,int[] tab){
		if(x+1<game.length && y-1>=0 && game[x][y]!=0 && game[x+1][y]!=0 && game[x+1][y-1]!=0 && game[x][y-1]!=0){
			tab[0]=1;
			tab[1]=0;
		}
		else{
				tab[0]=0;
			}
	}

}
