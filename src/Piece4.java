/**
 *      [ 2 ][ 3 ]
 * [ 1 ][ 0 ]
 *
 * rotation autour du 0 :
 * [ 3 ]
 * [ 2 ][ 0 ]
 *      [ 1 ]
 *
 */

public class Piece4 extends Piece{
    /// Indique dans quel état de rotation la pièce se trouve (ici que 2 possible)
    private boolean rotation;
    public int maxRotation=2;

    public Piece4(Matrice m){
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
        xMid[1]=mid-1;
        yMid[1]=1;
        xMid[2]=mid;
        yMid[2]=0;
        xMid[3]=mid+1;
        yMid[3]=0;
    }

    public void rotationner(){
        if(rotation){ // déjà en position de rotation
            x[1]+=1;
            y[1]+=1;
            x[2]-=1;
            y[2]+=1;
            x[3]-=2;
        }
        else{
            x[1]-=1;
            y[1]-=1;
            x[2]+=1;
            y[2]-=1;
            x[3]+=2;
        }
        rotation=!rotation;
    }

    public void antirotation(){
        rotationner();
    }

    public void reinit(){
        super.reinit();
        rotation=true;
    }
    
    public int getrotation(){
		return maxRotation;
	}
}
