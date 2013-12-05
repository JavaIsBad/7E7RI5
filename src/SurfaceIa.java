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

    public static void isMatchingPattern(int piecenbr, int x, int y, int [][] game, int []retour){
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
	
	public static int plusbasDansColonne(int x, int[][] game){
		int enbas=game[x].length-1;
		for(int i=enbas; i>0; i--)
			if(game[x][i]!=0)
				enbas=i-1;
		return enbas;
	}
	
	public static void rempliePattern (int piece, int [] patternitude, int[][] game){
		int y;
		int pattern[]= new int[2];
		for(int i=0; i<game.length; i++){
			y=plusbasDansColonne(i,game);
			isMatchingPattern(piece, i, y, game, pattern);
			patternitude[i]=pattern[0];   // a changer si possible
		}
	}
	
	public static void piece(int x, int y, int[][] game, int[] pieceAndRotation){
		PieceCarre.isMe(x, y, game, pieceAndRotation);
		if(pieceAndRotation[0]!=0)
			return;
		Piece4.isMe(x, y, game, pieceAndRotation);
		if(pieceAndRotation[0]!=0)
			return;
		Piece4Inv.isMe(x, y, game, pieceAndRotation);
		if(pieceAndRotation[0]!=0)
			return;
		PieceT.isMe(x, y, game, pieceAndRotation);
		if(pieceAndRotation[0]!=0)
			return;
		PieceL.isMe(x, y, game, pieceAndRotation);
		if(pieceAndRotation[0]!=0)
			return;
		PieceF.isMe(x, y, game, pieceAndRotation);
		if(pieceAndRotation[0]!=0)
			return;
		PieceI.isMe(x, y, game, pieceAndRotation);
		if(pieceAndRotation[0]!=0)
			return;
	}
	
	public static int nombreDeRotationsAFairePourPasserDuneRotationALaBonneRotationPourUnePieceDonnee (int piece, int rotationDepart, int rotationFin){
		int nbrotation=0;
		if(piece==4 || piece==5 || piece==7){
			if(rotationDepart != rotationFin)
				nbrotation++;
		}
		else{
			if(piece==3 || piece==2 || piece==6){
				while(rotationDepart != rotationFin){
					nbrotation++;
					rotationFin=(rotationFin+1)%4;
				}
			}
		}
		return nbrotation;
	}
	
	public static int rotationPourPattern(int piece, int pattern){
		int valret=0;
		switch(piece){
			case 1: 
				valret=0;
				break;
			case 2:
				switch(pattern){
					case 1:
						valret=1;
						break;
					case 2:
						valret=0;
						break;
					case 3:
						valret=3;
						break;
					case 4:
						valret=2;
						break;
				}
				break;
			case 3:
				switch(pattern){
					case 1:
						valret=3;
						break;
					case 5:
						valret=0;
						break;
					case 6:
						valret=1;
						break;
					case 4:
						valret=2;
						break;
				}
				break;
			case 4:
				switch(pattern){
					case 7:
						valret=0;
						break;
					case 8:
						valret=1;
						break;
				}
				break;
			case 5:
				switch(pattern){
					case 9:
						valret=0;
						break;
					case 10:
						valret=1;
						break;
				}
				break;
			case 6:
				switch(pattern){
					case 4:
						valret=2;
						break;
					case 10:
						valret=1;
						break;
					case 11:
						valret=0;
						break;
					case 8:
						valret=3;
						break;
				}
				break;
			case 7:
				switch(pattern){
					case 12:
						valret=0;
						break;
					case 13:
						valret=1;
						break;
				}
				break;
		}
		return valret;
	}
	
/*
	public static void trouvePieceIsoleeDansLeVideIntersiderale(int[][] game, int[] xy){
		boolean trouvee=false;
		for(int i=game.length/2-3; i<game.length/2+3; i++)
			for(int j=0; j<3; j++){
				if(game[i][j]!=0 && estIsolee(i, j, game, 4)){
					plusBasGauche(i, j, xy);
					return;
				}
			}
	}
*/

/*
	public static boolean estIsoleebis(int x, int y, int[][]game, int nbmax){
		if(nbmax==0)
			return false;
		if(game[x-1][y]!=0 && game[x-1][y]!=-3){
			game[x-1][y]=-3;
			return estIsolee(x-1, y, game, nbmax-1);
		}
		if(game[x-1][y+1]!=0 && game[x-1][y+1]!=-3){
			game[x-1][y+1]=-3;
			return estIsolee(x-1, y+1, game, nbmax-1);
		}
		if(game[x][y+1]!=0 && game[x][y+1]!=-3){
			game[x][y+1]=-3;
			return estIsolee(x, y+1, game, nbmax-1);
		}
		if(game[x+1][y+1]!=0 && game[x+1][y+1]!=-3){
			game[x+1][y+1]=-3;
			return estIsolee(x+1, y+1, game, nbmax-1);
		}
		if(game[x+1][y]!=0 && game[x+1][y]!=-3){
			game[x+1][y]=-3;
			return estIsolee(x+1, y, game, nbmax-1);
		}
		return true;
	}
*/
	
/*
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
*/
}
