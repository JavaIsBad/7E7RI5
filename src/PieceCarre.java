/**
 * [ 1 ][ 0 ]
 * [ 2 ][ 3 ]
 */

public class PieceCarre extends Piece{
	public int maxRotation=0;

    public PieceCarre(Matrice m){
        xMid=new int[4];
        yMid=new int[4];
        x=new int[4];
        y=new int[4];
        initPosition(m);
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

    public void rotationner(){
    }

    public void antirotation(){
    }
    public int getrotation(){
		return maxRotation;
	}
	
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
