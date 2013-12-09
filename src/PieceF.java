/**
 * Classe d'une pieceF
 * @author SCHMITT Maxime && SCHIMCHOWITSCH Raphaël
 */

/**
 * [ 1 ][ 0 ][ 2 ] |      [ 2 ][ 3 ]  |  [ 3 ]              |       [ 1 ]
 *           [ 3 ] |      [ 0 ]       |  [ 2 ][ 0 ][ 1 ]    |       [ 0 ]
 *                 |      [ 1 ]       |                     |  [ 3 ][ 2 ]
 *
 *  rotation 0     |  rotation 1 | rotation 2      | rotation 3
 */
public class PieceF extends Piece{
    ///Le nombre maximum de rotation de la pièce
    public int maxRotation=4;

    /**
     * Constructeur de PieceF
     * @param sizeX, le nombre de colonne de la matrice
     */
    public PieceF(int sizex){
        xMid=new int[4];
        yMid=new int[4];
        x=new int[4];
        y=new int[4];
        initPosition(sizex);
        rotation=0;
    }

    /**
     * Réinitialise les coordonnées de la pièce comme elles sont lors de son apparition
     */
    public void reinit(){
        super.reinit();
        rotation=0;
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
        xMid[2]=mid+1;
        yMid[2]=0;
        xMid[3]=mid+1;
        yMid[3]=1;
    }

    /**
     * Effectue la rotation de la piece vers la gauche
     */
    public void rotationner(){
        switch(rotation){
            case 0 :
                x[1]+=1;
                y[1]+=1;
                x[2]-=1;
                y[2]-=1;
                y[3]-=2;
                break;

            case 1 :
                x[1]+=1;
                y[1]-=1;
                x[2]-=1;
                y[2]+=1;
                x[3]-=2;
                break;

            case 2 :
                x[1]-=1;
                y[1]-=1;
                x[2]+=1;
                y[2]+=1;
                y[3]+=2;
                break;

            case 3 :
                x[1]-=1;
                y[1]+=1;
                x[2]+=1;
                y[2]-=1;
                x[3]+=2;
                break;
        }
        rotation=(rotation+1)%4;
    }

    /**
     * Effectue la rotation vers la droite de la piece
     */
    public void antirotation(){
        switch(rotation){
            case 0 :
                x[1]+=1;
                y[1]-=1;
                x[2]-=1;
                y[2]+=1;
                x[3]-=2;
                break;

            case 1 :
                x[1]-=1;
                y[1]-=1;
                x[2]+=1;
                y[2]+=1;
                y[3]+=2;
                break;

            case 2 :
                x[1]-=1;
                y[1]+=1;
                x[2]+=1;
                y[2]-=1;
                x[3]+=2;
                break;

            case 3 :
                x[1]+=1;
                y[1]+=1;
                x[2]-=1;
                y[2]-=1;
                y[3]-=2;
                break;
        }
        if (rotation==0) 
            rotation=3;
        else{
            rotation-=1;
        }
    }

    /**
     * Renvoie le nombre maximum de rotation de la piece
     *@return le nombre maximale de rotation d'une piece
     */
    public int getrotation(){
        return maxRotation;
    }

    /**
     * Regarde si la piece est une PieceF
     * @param x, la colonne de la case la plus en bas a gauche de la piece
     * @param y, la ligne de la case la plus en bas a gauche de la piece
     * @param game, le jeu dans lequel on se trouve
     * @param tab, tableau dans lequel on trouve la piece et la rotation
     */
    public static void isMe(int x, int y, int[][] game ,int[] tab){
        if(x-2>=0 && y-1>=0 &&  game[x][y]!=0 && game[x][y-1]!=0 && game[x-1][y-1]!=0 && game[x-2][y-1]!=0){
            tab[0]=3;
            tab[1]=0;
        }
        else{
            if(x+1<game.length && y-2>=0 && game[x][y]!=0 && game[x][y-1]!=0 && game[x][y-2]!=0 && game[x+1][y-2]!=0){
                tab[0]=3;
                tab[1]=1;
            }
            else{
                if(x+2<game.length  && y-1>=0 && game[x][y]!=0 && game[x][y-1]!=0 && game[x+1][y]!=0 && game[x+2][y]!=0){
                    tab[0]=3;
                    tab[1]=2;
                }
                else{
                    if(x+1<game.length && y-2>=0 &&game[x][y]!=0 && game[x+1][y]!=0 && game[x+1][y-1]!=0 && game[x+1][y-2]!=0){
                        tab[0]=3;
                        tab[1]=3;
                    }
                    else{
                        tab[0]=0;
                    }
                }
            }
        }
    }

}
