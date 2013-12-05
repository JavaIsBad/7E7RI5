/*
 * http://www.ryanheise.com/tetris/tetris_stacking.html
 * pièce 1 : carrée
 * pièce 2 : L
 * pièce 3 : L revers
 * pièce 4 : S
 * pièce 5 : Z
 * pièce 6 : T
 * pièce 7 : I
 */
public class SurfaceIa{
    private int[] surfaces=new int[14];

    private static boolean s1(int x, int y, int[][] game){
        return ((x+1)< game.length) && (game[x][y]==0) && (game[x+1][y]==0);
    }

    private static boolean s2(int x, int y, int[][] game){
        return ((x+2)< game.length) && (y-1)>=0 && (game[x][y]==0) && (game[x+1][y-1]==0) && game[x+2][y-1]==0 && game[x][y-1]==0;
    }

    private static boolean s3(int x, int y, int[][] game){
        return ((x+1)< game.length) && (y+2)<game[0].length && (game[x][y]==0) && (game[x+1][y+1]==0) && game[x+1][y+2]==0 && game[x+1][y]==0;
    }

    private static boolean s4(int x, int y, int[][] game){
        return ((x+2)< game.length) && (game[x][y]==0) && (game[x+1][y]==0) && game[x+2][y]==0;
    }

    private static boolean s5(int x, int y, int[][] game){
        return ((x+2)< game.length) && (y+1)<game[0].length && (game[x][y]==0) && (game[x+1][y]==0) && game[x+2][y+1]==0 && game[x+2][y]==0;
    }

    private static boolean s6(int x, int y, int[][] game){
        return ((x+1)< game.length) && (y-2)>=0 && (game[x][y]==0) && (game[x][y-1]==0) && game[x][y-2]==0 && game[x+1][y-2]==0;
    }

    private static boolean s7(int x, int y, int[][] game){
        return ((x+2)< game.length) && (y-1)>=0 && (game[x][y]==0) && (game[x+1][y]==0) && game[x+1][y-1]==0 && game[x+2][y-1]==0;
    }

    private static boolean s8(int x, int y, int[][] game){
        return ((x+1)< game.length) && (y+1)<game[0].length && (game[x][y]==0) && (game[x+1][y]==0) && game[x+1][y+1]==0;
    }

    private static boolean s9(int x, int y, int[][] game){
        return ((x+2)< game.length) && (y+1)<game[0].length && (game[x][y]==0) && (game[x+1][y]==0) && game[x+1][y+1]==0 && game[x+2][y+1]==0;
    }

    private static boolean s10(int x, int y, int[][] game){
        return ((x+1)< game.length) && (y-1)>=0 && (game[x][y]==0) && (game[x][y-1]==0) && game[x+1][y-1]==0;
    }

    private static boolean s11(int x, int y, int[][] game){
        return ((x+2)< game.length) && (y+1)<game[0].length && (game[x][y]==0) && (game[x+1][y]==0) && game[x+1][y+1]==0 && game[x+2][y]==0;
    }

    private static boolean s12(int x, int y, int[][] game){
        return ((x+3)< game.length) && (game[x][y]==0) && (game[x+1][y]==0)&& game[x+2][y]==0 && game[x+3][y]==0;
    }

    private static boolean s13(int x, int y, int[][] game){
        return game[x][y]==0;
    }

    public void isMatchingPattern(int piecenbr, int x, int y, int [][] game, int []retour){
		boolean boo;
		for(int i=0; i<2; i++)
			retour[i]=0;
		switch(piecenbr){
			case 1: 
				if(s1(x,y,game)){
					 retour[0]=1;
					 retour[1]=-1;
				 }
				 else{
					retour[0]=-1;
					retour[1]=-1;
				}
				break;
			case 2:
				if(s4(x,y,game)){
					retour[0]=4;
					retour[1]=1;
					break;
				}
				if(s2(x,y,game)){
					retour[0]=2;
					retour[1]=-1;
					break;
				} 
				if(s3(x,y,game)){
					retour[0]=3;
					retour[1]=-1;
					break;
				}
				if(s1(x,y,game)){
					retour[0]=1;
					retour[1]=-1;
					break;
				}
				retour[0]=-1;
				retour[1]=-1;
				break;
			case 3:
				if(s4(x,y,game)){
					retour[0]=4;
					retour[1]=1;
					break;
				}
				if(s5(x,y,game)){
					retour[0]=5;
					retour[1]=-1;
					break;
				} 
				if(s6(x,y,game)){
					retour[0]=6;
					retour[1]=-1;
					break;
				}
				if(s1(x,y,game)){
					retour[0]=1;
					retour[1]=-1;
					break;
				}
				retour[0]=-1;
				retour[1]=-1;
				break;
			case 4:
				if(s7(x,y,game)){
					retour[0]=7;
					retour[1]=-1;
					break;
				}
				if(s8(x,y,game)){
					retour[0]=8;
					retour[1]=-1;
					break;
				}
				retour[0]=-1;
				retour[1]=-1;
				break;
			case 5:
				if(s9(x,y,game)){
					retour[0]=9;
					retour[1]=-1;
					break;
				}
				if(s10(x,y,game)){
					retour[0]=10;
					retour[1]=-1;
					break;
				}
				retour[0]=-1;
				retour[1]=-1;
				break;
			case 6:
				if(s11(x,y,game)){
					retour[0]=11;
					retour[1]=8;
					break;
				}
				if(s4(x,y,game)){
					retour[0]=4;
					retour[1]=-1;
					break;
				} 
				if(s10(x,y,game)){
					retour[0]=10;
					retour[1]=-1;
					break;
				}
				if(s8(x,y,game)){
					retour[0]=8;
					retour[1]=-1;
					break;
				}
				retour[0]=-1;
				retour[1]=-1;
				break;
			case 7:
				if(s12(x,y,game)){
					retour[0]=12;
					retour[1]=13;
					break;
				}
				if(s13(x,y,game)){
					retour[0]=13;
					retour[1]=-1;
					break;
				}
				retour[0]=-1;
				retour[1]=-1;
				break;
		}
	}
    public static void main(String[] argvs){
        int[][]tab=new int[10][20];
        tab[1][19]=1;
        tab[2][19]=1;
        tab[1][18]=1;
        tab[2][18]=1;
        System.out.println("S01 :" +s1(0,19,tab));
        System.out.println("S02 :" +s2(0,19,tab));
        System.out.println("S03 :" +s3(0,19,tab));
        System.out.println("S04 :" +s4(0,19,tab));
        System.out.println("S05 :" +s5(0,19,tab));
        System.out.println("S06 :" +s6(0,19,tab));
        System.out.println("S07 :" +s7(0,19,tab));
        System.out.println("S08 :" +s8(0,19,tab));
        System.out.println("S09 :" +s9(0,19,tab));
        System.out.println("S10 :" +s10(0,19,tab));
        System.out.println("S11 :" +s11(0,19,tab));
        System.out.println("S12 :" +s12(0,19,tab));
        System.out.println("S13 :" +s13(0,19,tab));
    }
}
