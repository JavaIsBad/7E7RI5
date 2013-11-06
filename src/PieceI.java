/**
 * [ 1 ][ 0 ][ 2 ][ 3 ]
 * 
 * 	[ 1 ]
 * 	[ 0 ]
 *  [ 2 ]
 *  [ 3 ]
 */

public class PieceI extends Piece{
    /// Les positions x et y des pièces en haut au milieu du jeu lors de leur apparition (permet de réinitialiser la position lorque la pièce à déjà fini sa course vers le bas)
    private int xMid[]=new int[4], yMid[]=new int[4];
    /// La position actuel dans le jeu
    private int x[]=new int[4], y[]=new int[4];
    /// Indique dans quel état de rotation la pièce se trouve (ici que 2 possible)
    private boolean rotation;


    public PieceI(Matrice m){ // la piece est en haut
        initPosition(m);
        rotation=true;
    }

    private void initPosition(Matrice m){
        int mid= m.sizeX/2;
        xMid[0]=mid;
        yMid[0]=0;
        xMid[1]=mid-1;
        yMid[1]=0;
        xMid[2]=mid+1;
        yMid[2]=0;
        xMid[3]=mid+2;
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
        if(rotation){ // déjà en position de rotation
            x[1]+=1;
            y[1]-=1;
            x[2]-=1;
            y[2]+=1;
            x[3]-=2;
            y[3]+=2;
        }
        else{
            x[1]-=1;
            y[1]+=1;
            x[2]+=1;
            y[2]-=1;
            x[3]+=2;
            y[3]-=2;
        }
        rotation=!rotation;
    }

    public void antirotation(){
        rotationner(); // ici il suffit de faire une rotation pour revenir aux positions de départ
    }

    /**
     * Remet la pièce dans sa position de départ de descente
     */

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
