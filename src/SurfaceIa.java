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
        return x+1< game.length && game[x][y]==0 && game[x+1][y]==0 && (y+1==game[0].length || game[x][y+1]!=0 && game[x+1][y+1]!=0);
    }

    private static boolean s2(int x, int y, int[][] game){
        return x+2< game.length && y-1>=0 && game[x][y]==0 && game[x+1][y-1]==0 && game[x+2][y-1]==0 && game[x][y-1]==0 && (y+1==game[0].length || game[x][y+1]!=0) && game[x+1][y]!=0 && game[x+2][y]!=0;
    }

    private static boolean s3(int x, int y, int[][] game){
        return x+1< game.length && y+2<game[0].length && game[x][y]==0 && game[x+1][y+1]==0 && game[x+1][y+2]==0 && game[x+1][y]==0 && (y+3==game[0].length || game[x+1][y+3]!=0) && game[x][y+1]!=0 && game[x][y+2]!=0;
    }

    private static boolean s4(int x, int y, int[][] game){
        return x+2< game.length && game[x][y]==0 && game[x+1][y]==0 && game[x+2][y]==0 && (y+1==game[0].length || game[x][y+1]!=0 && game[x+1][y+1]!=0 && game[x+2][y+1]!=0);
    }

    private static boolean s5(int x, int y, int[][] game){
        return x+2< game.length && y+1<game[0].length && game[x][y]==0 && game[x+1][y]==0 && game[x+2][y+1]==0 && game[x+2][y]==0 && (y+2==game[0].length || game[x+2][y+2]!=0) && game[x][y+1]!=0 && game[x+1][y+1]!=0;
    }

    private static boolean s6(int x, int y, int[][] game){
        return x+1< game.length && y-2>=0 && game[x][y]==0 && game[x][y-1]==0 && game[x][y-2]==0 && game[x+1][y-2]==0 && (y+1==game[0].length || game[x][y+1]!=0) && game[x+1][y]!=0 && game[x+1][y-1]!=0;
    }

    private static boolean s7(int x, int y, int[][] game){
        return x+2< game.length && y-1>=0 && game[x][y]==0 && game[x+1][y]==0 && game[x+1][y-1]==0 && game[x+2][y-1]==0 && (y+1==game[0].length ||game[x][y+1]!=0 && game[x+1][y+1]!=0) && game[x+2][y]!=0 ;
    }

    private static boolean s8(int x, int y, int[][] game){
        return x+1< game.length && y+1<game[0].length && game[x][y]==0 && game[x+1][y]==0 && game[x+1][y+1]==0 && (y+2==game[0].length || game[x+1][y+2]!=0) && game[x][y+1]!=0;
    }

    private static boolean s9(int x, int y, int[][] game){
        return x+2< game.length && y+1<game[0].length && game[x][y]==0 && game[x+1][y]==0 && game[x+1][y+1]==0 && game[x+2][y+1]==0 && (y+2==game[0].length || game[x+1][y+2]!=0 && game[x+2][y+2]!=0) && game[x][y+1]!=0;
    }

    private static boolean s10(int x, int y, int[][] game){
        return x+1< game.length && y-1>=0 && game[x][y]==0 && game[x][y-1]==0 && game[x+1][y-1]==0 && (y+1==game[0].length || game[x][y+1]!=0) && game[x+1][y]!=0;
    }

    private static boolean s11(int x, int y, int[][] game){
        return x+2< game.length && y+1<game[0].length && game[x][y]==0 && game[x+1][y]==0 && game[x+1][y+1]==0 && game[x+2][y]==0 && (y+2==game[0].length || game[x+1][y+2]!=0) && game[x+2][y+1]!=0 && game[x][y+1]!=0;
    }

    private static boolean s12(int x, int y, int[][] game){
        return x+3< game.length && game[x][y]==0 && game[x+1][y]==0&& game[x+2][y]==0 && game[x+3][y]==0 && (y+1==game[0].length || game[x][y+1]!=0 && game[x+1][y+1]!=0 && game[x+2][y+1]!=0 && game[x+3][y+1]!=0);
    }

    private static boolean s13(int x, int y, int[][] game){
        return game[x][y]==0 && (y+1==game[0].length || game[x][y+1]!=0);
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
	
	
	private static int hauteurColonne(int [][]game, int colonne){ //hauteurmaximum : 0
		int ligneDebut=0;
		for (int i=0; i<game[0].length;i++){
                        if (game[colonne][i]>=1){
                                ligneDebut=i; 
                                break;
						}
					}
				return game[0].length-ligneDebut;
	
	}
	
	private static int hauteurMoyenne(int[][] game){
		int moyenne=0;
		for (int i=0;i<game.length;i++){
			moyenne+=hauteurColonne(game,i);
		}
		return (moyenne/game.length);
	}
	
	private static int hauteurMax(int[][] game){
		int max=0;
		for (int i=0;i<game.length;i++){
			if (hauteurColonne(game,i) > max)
				max=hauteurColonne(game,i);
		}
		return max;
	}
	
	/**
 * Compte le nombre de lignes finies dans un tableau a 2 dimensions
 * @param m, un tableau a 2 dimensions
 * @return un entier
 */
	private static int compte_lignes_finies(int[][] m){
			int cpt=0;
			int cmpteur;
			int i,j;
			for (j=0;j<m[0].length;j++){
				cmpteur=0;
				for (i=0; i<m.length;i++){
					if (m[i][j]>=1)
					cmpteur++;
				}
				if (cmpteur==m.length)
					cpt++;
			}
	return cpt;
	}

/**
 * Compte le nombre de trous dans une colonne
 * @param mat, un tableau a 2 dimensions
 * @param colonne, une colonne
 * @return un entier
 */
    private static int nbtrou(int[][] game,int colonne){
                int cpt=0; 
                int i,j;
                for (j=game[0].length-hauteurColonne(game,colonne); j<game[0].length; j++){
                        if (game[colonne][j]==0)
                                cpt++;
                }
                return cpt;
        }
        
/**
 * Compte le nombre de trous dans un tableau a 2 dimensions
 * @param mat, un tableau a 2 dimensions
 * @param pieceEnCours, une Piece
 * @param colonne, une colonne
 * @param rotation, une rotation
 * @return un entier
 */
        private static int compter_trou(int[][] m){
        int nbretrou=0;
                for (int i=0; i<m.length;i++){ //pour chaque colonne
                        nbretrou=nbtrou(m,i)+nbretrou;
                }
        return nbretrou;
        }
       
	
	private static int calculerCout(int [][]game, int hauteurAvant){
		int hauteurMax=hauteurMax(game); //hauteur Max du jeu
		int hauteurMoy=hauteurMoyenne(game); //hauteur Moyenne du jeu
		int lignesRemplies=compte_lignes_finies(game); //Nombre de lignes remplies
		int nombreTrous=compter_trou(game); //Nombre de trous
		int finalvalue=0;
		if (lignesRemplies==4)
			return 10000000;
			if (hauteurAvant<hauteurMax && hauteurMax>10){
				return -999999999;
			}
		finalvalue= 40*lignesRemplies; 
		return finalvalue;
	}
	
	
	private static void parDefaut(int[]retour, Piece piece, int[][] game){
		int maxRotate=piece.getrotation();
		int troumin=game.length*game[0].length+1;
		int hauteurmax=hauteurMax(game);
		for (int i=0;i<game.length;i++){
			for (int j=0; j<maxRotate; j++){
				int positiony=plusbasDansColonne(i,game);
				if(piece.peuxArriverOuIlVeut(i,positiony,j,game)){
					if(piece.placerPieceAUnEndroitDonneDansLeJeuAvecUneRotationPrecise(i,positiony,j,game,1)){
						int comptertrou=compter_trou(game);
						if (troumin>comptertrou){
							retour[0]=i;
							retour[1]=j;
							hauteurmax=hauteurMax(game);
						}
						else if (troumin==comptertrou){
							if (hauteurMax(game)<hauteurmax){
								retour[0]=i;
								retour[1]=j;
								hauteurmax=hauteurMax(game);
							}
						}
						piece.placerPieceAUnEndroitDonneDansLeJeuAvecUneRotationPrecise(i,positiony,j,game,0);
					}
				}
			}
		}
	}
	
	
	public static void getTheMaxiMenuBestOfPlusPlus(int[] retour,int nb, Piece piece, int[] tabdepattern, int[][] game){
		int scoremax=-999999999;
		boolean existpattern=false;
		int i=0;
		int colonnemax=0;
		int scoreintermed=0;
		while(i<tabdepattern.length){
			if(tabdepattern[i]>0){
				existpattern=true;
				int rotationpp=rotationPourPattern(nb, tabdepattern[i]);
				int hauteurAvant=hauteurMax(game);
				int positiony=plusbasDansColonne(i,game);
				if (piece.peuxArriverOuIlVeut(i,positiony,rotationpp,game)){
					if(piece.placerPieceAUnEndroitDonneDansLeJeuAvecUneRotationPrecise(i,positiony, rotationpp, game, 1)){
						System.out.println("Il peut arriver");
						scoreintermed=calculerCout(game,hauteurAvant);
						piece.placerPieceAUnEndroitDonneDansLeJeuAvecUneRotationPrecise(i,positiony, rotationpp, game, 0);
						//IA.display_matrice(game);
						if(scoremax<scoreintermed){
							scoremax=scoreintermed;
							retour[0]=i;
							retour[1]=rotationpp;
						}
					}
				}
			}
		i++;
		}
		if(!existpattern){ //paspattern
			parDefaut(retour, piece, game);
			System.out.println("Par defaut");
		}
	}
}
