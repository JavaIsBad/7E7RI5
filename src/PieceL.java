/**
 * [ 2 ][ 0 ][ 1 ] | [ 1 ]      | [ 2 ][ 0 ][ 1 ] | [ 3 ][ 2 ]
 * [ 3 ]           | [ 0 ]      | [ 3 ]           |      [ 0 ]
 *                 | [ 2 ][ 3 ] |                 |      [ 1 ]
 *
 *  rotation 0     | rotation 1 | rotation 2      | rotation 3
 */

public class PieceL extends Piece{
    private int rotation;
    public int maxRotation=4;

    public PieceL(Matrice m){
        xMid=new int[4];
        yMid=new int[4];
        x=new int[4];
        y=new int[4];
        initPosition(m);
        rotation=0;
    }

    public void reinit(){
        super.reinit();
        rotation=0;
    }

    private void initPosition(Matrice m){
        int mid= m.sizeX/2;
        xMid[0]=mid;
        yMid[0]=0;
        xMid[1]=mid+1;
        yMid[1]=0;
        xMid[2]=mid-1;
        yMid[2]=0;
        xMid[3]=mid-1;
        yMid[3]=1;
    }

    public void rotationner(){
        switch(rotation){
            case 0 :
                x[1]-=1;
                y[1]-=1;
                x[2]+=1;
                y[2]+=1;
                x[3]+=2;
                break;

            case 1 :
                x[1]-=1;
                y[1]+=1;
                x[2]+=1;
                y[2]-=1;
                y[3]-=2;
                break;

            case 2 :
                x[1]+=1;
                y[1]+=1;
                x[2]-=1;
                y[2]-=1;
                x[3]-=2;
                break;

            case 3 :
                x[1]+=1;
                y[1]-=1;
                x[2]-=1;
                y[2]+=1;
                y[3]+=2;
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
                y[2]-=1;
                y[3]-=2;
                break;

            case 1 :
                x[1]+=1;
                y[1]+=1;
                x[2]-=1;
                y[2]-=1;
                x[3]-=2;
                break;

            case 2 :
                x[1]+=1;
                y[1]-=1;
                x[2]-=1;
                y[2]+=1;
                y[3]+=2;
                break;

            case 3 :
                x[1]-=1;
                y[1]-=1;
                x[2]+=1;
                y[2]+=1;
                x[3]+=2;
                break;
        }
        if (rotation==0)
            rotation=3;
        else{
            rotation-=1;
        }
    }
}
