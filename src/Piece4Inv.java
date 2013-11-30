/**
 *  [ 3 ][ 2 ]
 * 	    [ 0 ][ 1 ]
 * -----------------------
 *           [ 3 ]
 *      [ 0 ][ 2 ]
 *      [ 1 ]
 */
public class Piece4Inv extends Piece{
    /// Indique dans quel état de rotation la pièce se trouve (ici que 2 possible)
    private boolean rotation;
    public int maxRotation=2;

    public Piece4Inv(Matrice m){
        xMid=new int[4];
        yMid=new int[4];
        x=new int[4];
        y=new int[4];
        initPosition(m);
        rotation=true;
    }

    private void initPosition(Matrice m){
        int mid= m.sizeX/2;
        xMid[0]=mid;
        yMid[0]=1;
        xMid[1]=mid+1;
        yMid[1]=1;
        xMid[2]=mid;
        yMid[2]=0;
        xMid[3]=mid-1;
        yMid[3]=0;
    }

    public void rotationner(){
        if(rotation){ // déjà en position de rotation
            x[1]-=1;
            y[1]-=1;
            x[2]-=1;
            y[2]+=1;
            y[3]+=2;
        }
        else{
            x[1]+=1;
            y[1]+=1;
            x[2]+=1;
            y[2]-=1;
            y[3]-=2;
        }
        rotation=!rotation;
    }

    public void antirotation(){
        rotationner(); // ici il suffit de faire une rotation pour revenir aux positions de départ
    }

    public void reinit(){
        super.reinit();
        rotation=true;
    }
    public int getrotation(){
		return maxRotation;
	}
}
