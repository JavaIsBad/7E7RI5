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
    public int maxRotation=2;

    public Piece4Inv(int sizex){
        xMid=new int[4];
        yMid=new int[4];
        x=new int[4];
        y=new int[4];
        initPosition(sizex);
        rotation=0;
    }

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

    public void antirotation(){
        rotationner(); // ici il suffit de faire une rotation pour revenir aux positions de départ
    }

    public void reinit(){
        super.reinit();
        rotation=0;
    }
    public int getrotation(){
		return maxRotation;
	}
	
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
