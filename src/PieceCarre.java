/**
 * [ 1 ][ 0 ]
 * [ 2 ][ 3 ]
 */

public class PieceCarre extends Piece{
    /// Les positions x et y des pièces en haut au milieu du jeu lors de leur apparition (permet de réinitialiser la position lorque la pièce à déjà fini sa course vers le bas)
    private int xMid[]=new int[4], yMid[]=new int[4];
    /// La position actuel dans le jeu
    private int x[]=new int[4], y[]=new int[4];
    /// Indique dans quel état de rotation la pièce se trouve (ici que 1 possible)
    private boolean rotation;

    public PieceCarre(Matrice m){
        initPosition(m);
        rotation=false;
    }

    private void initPosition(Matrice m){
        int mid= m.sizeX/2;
        xMid[0]=mid;
        yMid[0]=0;
        xMid[1]=mid-1;
        yMid[1]=0;
        xMid[2]=mid-1;
        yMid[2]=1;
        xMid[3]=mid;
        yMid[3]=1;
    }

    public void dessinerPiece(Matrice m){
        for(int i=0; i<x.length; i++)
            m.put(x[i],y[i],true);
    }

    public void effacerPiece(Matrice m){
        for(int i=0; i<x.length; i++)
            m.put(x[i],y[i],false);
    }

    public void remonterPiece(){
        for(int i=0; i<y.length; i++)
            y[i]-=1;
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
    }

    public void antirotation(){
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
