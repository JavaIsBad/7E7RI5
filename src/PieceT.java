/**
 * [ 3 ][ 0 ][ 2 ]  |  [ 2 ]      |      [ 1 ]      |      [ 3 ]
 *      [ 1 ]       |  [ 0 ][ 1 ] | [ 2 ][ 0 ][ 3 ] | [ 1 ][ 0 ]
 *                  |  [ 3 ]      |                 |	   [ 2 ]
 * rotation 0       |  rotation 1 | rotation 2      | rotation 3 
 */

public class PieceT extends Piece{
    /// Indique dans quel état de rotation la pièce se trouve (ici que 4 possible)
    public int maxRotation=4;

    public PieceT(int sizex){
        xMid=new int[4];
        yMid=new int[4];
        x=new int[4];
        y=new int[4];
        initPosition(sizex);
        rotation=0;
    }

    public void reinit(){
        super.reinit();
        rotation=0;
    }

    private void initPosition(int sizex){
        int mid= sizex/2;
        xMid[0]=mid;
        yMid[0]=0;
        xMid[1]=mid;
        yMid[1]=1;
        xMid[2]=mid+1;
        yMid[2]=0;
        xMid[3]=mid-1;
        yMid[3]=0;
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
                y[1]-=1;
                x[2]-=1;
                y[2]+=1;
                x[3]+=1;
                y[3]-=1;
                break;

            case 1 :
                x[1]-=1;
                y[1]+=1;
                x[2]+=1;
                y[2]+=1;
                x[3]-=1;
                y[3]-=1;
                break;

            case 2 :
                x[1]+=1;
                y[1]+=1;
                x[2]+=1;
                y[2]-=1;
                x[3]-=1;
                y[3]+=1;
                break;

            case 3 :
                x[1]+=1;
                y[1]-=1;
                x[2]-=1;
                y[2]-=1;
                x[3]+=1;
                y[3]+=1;
                break;
        }
        if (rotation==0) 
            rotation=3;
        else{
            rotation-=1;
        }
    }
    public int getrotation(){
		return maxRotation;
	}
	
	public static void isMe(int x, int y, int[][] game ,int[] tab){
		if(x-1>=0 && x+1<game.length && y-1>=0 && game[x][y]!=0 && game[x][y-1]!=0 && game[x-1][y-1]!=0 && game[x+1][y-1]!=0){
			tab[0]=6;
			tab[1]=0;
		}
		else{
			if(x+1<game.length && y-2>=0 && game[x][y]!=0 && game[x][y-1]!=0 && game[x][y-2]!=0 && game[x+1][y-1]!=0){
				tab[0]=6;
				tab[1]=1;
			}
			else{
				if(x+2<game.length && y-1>=0 &&game[x][y]!=0 && game[x+1][y]!=0 && game[x+2][y]!=0 && game[x+1][y-1]!=0){
					tab[0]=6;
					tab[1]=2;
				}
				else{
					if(x-1>=0 && y-2>=0 && game[x][y]!=0 && game[x][y-1]!=0 && game[x][y-2]!=0 && game[x-1][y-1]!=0){
						tab[0]=6;
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
