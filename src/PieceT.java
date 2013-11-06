/**
 * [ 3 ][ 0 ][ 2 ]  |  [ 2 ]      |      [ 1 ]      |      [ 3 ]
 *      [ 1 ]       |  [ 0 ][ 1 ] | [ 2 ][ 0 ][ 3 ] | [ 1 ][ 0 ]
 *                  |  [ 3 ]      |                 |	   [ 2 ]
 * rotation 0       |  rotation 1 | rotation 2      | rotation 3 
 */

public class PieceT extends Piece{
    /// Les positions x et y des pièces en haut au milieu du jeu lors de leur apparition (permet de réinitialiser la position lorque la pièce à déjà fini sa course vers le bas)
    private int xMid[]=new int[4], yMid[]=new int[4];
    /// La position actuel dans le jeu
    private int x[]=new int[4], y[]=new int[4];
    /// Indique dans quel état de rotation la pièce se trouve (ici que 4 possible)
    private int rotation; 

    public PieceT(Matrice m){
        initPosition(m);
        rotation=0;
    }

    private void initPosition(Matrice m){
        int mid= m.sizeX/2;
        xMid[0]=mid;
        yMid[0]=0;
        xMid[1]=mid;
        yMid[1]=1;
        xMid[2]=mid+1;
        yMid[2]=0;
        xMid[3]=mid-1;
        yMid[3]=0;
    }

    public void dessinerPiece(Matrice m){
        for(int i=0; i<x.length; i++)
            m.put(x[i],y[i],true);
    }

    public void effacerPiece(Matrice m){
        for(int i=0; i<x.length; i++)
            m.put(x[i],y[i],false);
    }

    public void tomberPiece(){
        for(int i=0; i<y.length; i++)
            y[i]+=1;
    }

    public void gauche(){
        for (int i=0; i<x.length; i++)
            x[i]-=1;
    }

    public void droite(){
        for (int i=0; i<x.length; i++)
            x[i]+=1;
    }

    public void rotationner(){ 
        switch(rotation){
            case 0 :
                x[1]+=1;
                y[1]-=1;
                x[2]-=1;
                y[2]-=1;
                x[3]+=1;
                y[3]+=1;
                break;

            case 1 :
                x[1]-=1;
                y[1]-=1;
                x[2]-=1;
                y[2]+=1;
                x[3]+=1;
                y[3]-=1;
                break;

            case 2 :
                x[1]-=1;
                y[1]+=1;
                x[2]+=1;
                y[2]+=1;
                x[3]-=1;
                y[3]-=1;
                break;

            case 3 :
                x[1]+=1;
                y[1]+=1;
                x[2]+=1;
                y[2]-=1;
                x[3]-=1;
                y[3]+=1;
                break;
        }
        rotation=(rotation+1)%4;
    }

    public void antirotation(){
        switch(rotation){
            case 0 :
                x[1]-=1;
                y[1]+=1;
                x[2]+=1;
                y[2]+=1;
                x[3]-=1;
                y[3]-=1;
                break;

            case 1 :
                x[1]+=1;
                y[1]+=1;
                x[2]+=1;
                y[2]-=1;
                x[3]-=1;
                y[3]+=1;
                break;

            case 2 :
                x[1]+=1;
                y[1]-=1;
                x[2]-=1;
                y[2]-=1;
                x[3]+=1;
                y[3]+=1;
                break;

            case 3 :
                x[1]-=1;
                y[1]-=1;
                x[2]-=1;
                y[2]+=1;
                x[3]+=1;
                y[3]-=1;
                break;
        }
        if (rotation==0) //je sais pas si le modulo marche pour la négativité
            rotation=3;
        else{
            rotation-=1;
        }
    }

    public void reinit(){
        for(int i=0; i<x.length; i++){
            x[i]=xMid[i];
            y[i]=yMid[i];
        }
    }

    public int[] getX(){
        return x;
    }

    public int[] getY(){
        return y;
    }
}
