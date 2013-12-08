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
 
 /**
  * Classe de test Ia et Surface
  */
 
public class SurfaceIa{

/**
	 * Renvoit vrai si le pattern est le bon
	 * @param x La coordonné du plus a gauche du plus en bas des cubes
	 * @param y La coordonné la plus basse
	 * @param game La grille de jeu
	 * @return vrai si possible false sinon
	 */ 
    private static boolean s1(int x, int y, int[][] game){
        return x+1< game.length && game[x][y]==0 && game[x+1][y]==0 && (y+1==game[0].length || game[x][y+1]!=0 && game[x+1][y+1]!=0);
    }
/**
	 * Renvoit vrai si le pattern est le bon
	 * @param x La coordonné du plus a gauche du plus en bas des cubes
	 * @param y La coordonné la plus basse
	 * @param game La grille de jeu
	 * @return vrai si possible false sinon
	 */ 

    private static boolean s2(int x, int y, int[][] game){
        return x+2< game.length && y-1>=0 && game[x][y]==0 && game[x+1][y-1]==0 && game[x+2][y-1]==0 && game[x][y-1]==0 && (y+1==game[0].length || game[x][y+1]!=0) && game[x+1][y]!=0 && game[x+2][y]!=0;
    }
/**
	 * Renvoit vrai si le pattern est le bon
	 * @param x La coordonné du plus a gauche du plus en bas des cubes
	 * @param y La coordonné la plus basse
	 * @param game La grille de jeu
	 * @return vrai si possible false sinon
	 */ 

    private static boolean s3(int x, int y, int[][] game){
        return x+1< game.length && y+2<game[0].length && game[x][y]==0 && game[x+1][y+1]==0 && game[x+1][y+2]==0 && game[x+1][y]==0 && (y+3==game[0].length || game[x+1][y+3]!=0) && game[x][y+1]!=0 && game[x][y+2]!=0;
    }
	/**
	 * Renvoit vrai si le pattern est le bon
	 * @param x La coordonné du plus a gauche du plus en bas des cubes
	 * @param y La coordonné la plus basse
	 * @param game La grille de jeu
	 * @return vrai si possible false sinon
	 */ 

    private static boolean s4(int x, int y, int[][] game){
        return x+2< game.length && game[x][y]==0 && game[x+1][y]==0 && game[x+2][y]==0 && (y+1==game[0].length || game[x][y+1]!=0 && game[x+1][y+1]!=0 && game[x+2][y+1]!=0);
    }
	/**
	 * Renvoit vrai si le pattern est le bon
	 * @param x La coordonné du plus a gauche du plus en bas des cubes
	 * @param y La coordonné la plus basse
	 * @param game La grille de jeu
	 * @return vrai si possible false sinon
	 */ 

    private static boolean s5(int x, int y, int[][] game){
        return x+2< game.length && y+1<game[0].length && game[x][y]==0 && game[x+1][y]==0 && game[x+2][y+1]==0 && game[x+2][y]==0 && (y+2==game[0].length || game[x+2][y+2]!=0) && game[x][y+1]!=0 && game[x+1][y+1]!=0;
    }
	/**
	 * Renvoit vrai si le pattern est le bon
	 * @param x La coordonné du plus a gauche du plus en bas des cubes
	 * @param y La coordonné la plus basse
	 * @param game La grille de jeu
	 * @return vrai si possible false sinon
	 */ 

    private static boolean s6(int x, int y, int[][] game){
        return x+1< game.length && y-2>=0 && game[x][y]==0 && game[x][y-1]==0 && game[x][y-2]==0 && game[x+1][y-2]==0 && (y+1==game[0].length || game[x][y+1]!=0) && game[x+1][y]!=0 && game[x+1][y-1]!=0;
    }
/**
	 * Renvoit vrai si le pattern est le bon
	 * @param x La coordonné du plus a gauche du plus en bas des cubes
	 * @param y La coordonné la plus basse
	 * @param game La grille de jeu
	 * @return vrai si possible false sinon
	 */ 

    private static boolean s7(int x, int y, int[][] game){
        return x+2< game.length && y-1>=0 && game[x][y]==0 && game[x+1][y]==0 && game[x+1][y-1]==0 && game[x+2][y-1]==0 && (y+1==game[0].length ||game[x][y+1]!=0 && game[x+1][y+1]!=0) && game[x+2][y]!=0 ;
    }
	/**
	 * Renvoit vrai si le pattern est le bon
	 * @param x La coordonné du plus a gauche du plus en bas des cubes
	 * @param y La coordonné la plus basse
	 * @param game La grille de jeu
	 * @return vrai si possible false sinon
	 */ 

    private static boolean s8(int x, int y, int[][] game){
        return x+1< game.length && y+1<game[0].length && game[x][y]==0 && game[x+1][y]==0 && game[x+1][y+1]==0 && (y+2==game[0].length || game[x+1][y+2]!=0) && game[x][y+1]!=0;
    }
/**
	 * Renvoit vrai si le pattern est le bon
	 * @param x La coordonné du plus a gauche du plus en bas des cubes
	 * @param y La coordonné la plus basse
	 * @param game La grille de jeu
	 * @return vrai si possible false sinon
	 */ 

    private static boolean s9(int x, int y, int[][] game){
        return x+2< game.length && y+1<game[0].length && game[x][y]==0 && game[x+1][y]==0 && game[x+1][y+1]==0 && game[x+2][y+1]==0 && (y+2==game[0].length || game[x+1][y+2]!=0 && game[x+2][y+2]!=0) && game[x][y+1]!=0;
    }
/**
	 * Renvoit vrai si le pattern est le bon
	 * @param x La coordonné du plus a gauche du plus en bas des cubes
	 * @param y La coordonné la plus basse
	 * @param game La grille de jeu
	 * @return vrai si possible false sinon
	 */ 
    private static boolean s10(int x, int y, int[][] game){
        return x+1< game.length && y-1>=0 && game[x][y]==0 && game[x][y-1]==0 && game[x+1][y-1]==0 && (y+1==game[0].length || game[x][y+1]!=0) && game[x+1][y]!=0;
    }
	/**
	 * Renvoit vrai si le pattern est le bon
	 * @param x La coordonné du plus a gauche du plus en bas des cubes
	 * @param y La coordonné la plus basse
	 * @param game La grille de jeu
	 * @return vrai si possible false sinon
	 */ 

    private static boolean s11(int x, int y, int[][] game){
        return x+2< game.length && y+1<game[0].length && game[x][y]==0 && game[x+1][y]==0 && game[x+1][y+1]==0 && game[x+2][y]==0 && (y+2==game[0].length || game[x+1][y+2]!=0) && game[x+2][y+1]!=0 && game[x][y+1]!=0;
    }
	/**
	 * Renvoit vrai si le pattern est le bon
	 * @param x La coordonné du plus a gauche du plus en bas des cubes
	 * @param y La coordonné la plus basse
	 * @param game La grille de jeu
	 * @return vrai si possible false sinon
	*/
    private static boolean s12(int x, int y, int[][] game){
        return x+3< game.length && game[x][y]==0 && game[x+1][y]==0&& game[x+2][y]==0 && game[x+3][y]==0 && (y+1==game[0].length || game[x][y+1]!=0 && game[x+1][y+1]!=0 && game[x+2][y+1]!=0 && game[x+3][y+1]!=0);
    }
	/**
	 * Renvoit vrai si le pattern est le bon
	 * @param x La coordonné du plus a gauche du plus en bas des cubes
	 * @param y La coordonné la plus basse
	 * @param game La grille de jeu
	 * @return vrai si possible false sinon
	 */ 

    private static boolean s13(int x, int y, int[][] game){
        return game[x][y]==0 && (y+1==game[0].length || game[x][y+1]!=0);
    }
	/**
	 * Remplit le tableau de pattern passé en parametre
	 * @param piece Le numero de la pièce
	 * @param x La coordonné du plus a gauche du plus en bas des cubes
	 * @param y La coordonné la plus basse
	 * @param game La grille de jeu
	 * @param retour Le tableau de pattern rempli avec celui trouvé si possible sinon -1
	 */ 

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
	/**
	 * Renvoit le point le plus bas dans une colonne donnée
	 * @param x La colonne observée
	 * @param game La grille de jeu
	 * @return La valeur du point le plus bas
	 */ 

	public static int plusbasDansColonne(int x, int[][] game){
		int enbas=game[x].length-1;
		for(int i=enbas; i>0; i--)
			if(game[x][i]!=0)
				enbas=i-1;
		return enbas;
	}
	
	/**
	 * Remplit le tableau de pattern pour tout le jeu
	 * @param piece Le numero de la pièce
	 * @param patternitude Le tableau de pattern
	 * @param game La grille de jeu
	 */ 

	
	public static void rempliePattern (int piece, int [] patternitude, int[][] game){
		int y;
		int pattern[]= new int[2];
		for(int i=0; i<game.length; i++){
			y=plusbasDansColonne(i,game);
			isMatchingPattern(piece, i, y, game, pattern);
			patternitude[i]=pattern[0];   // a changer si possible
		}
	}
	
	/**
	 * Remplit le tableau pieceAndRotation avec en premier champ le numero de la pièce et en deuxieme la valeur de la rotation
	 * @param x le point le plus a gauche de la pièce
	 * @param y le point le plus bas de la piece
	 * @param game La grille de jeu
	 * @param pieceAndRotation Le tableau a remplir.
	 */ 
	
	public static void piece(int x, int y, int[][] game, int[] pieceAndRotation){
		PieceCarre.isMe(x, y, game, pieceAndRotation);
		if(pieceAndRotation[0]!=0){
			System.out.println("Je suis une pièce carre"); //debug
			return;
		}
		Piece4.isMe(x, y, game, pieceAndRotation);
		if(pieceAndRotation[0]!=0){
			System.out.println("Je suis une pièce 4"); //debug
			return;
		}
		Piece4Inv.isMe(x, y, game, pieceAndRotation);
		if(pieceAndRotation[0]!=0){
			System.out.println("Je suis une pièce 4inv"); //debug
			return;
		}
		PieceT.isMe(x, y, game, pieceAndRotation);
		if(pieceAndRotation[0]!=0){
			System.out.println("Je suis une pièce T"); //debug
			return;
		}
		PieceL.isMe(x, y, game, pieceAndRotation);
		if(pieceAndRotation[0]!=0){
			System.out.println("Je suis une pièce L"); //debug
			return;
		}
		PieceF.isMe(x, y, game, pieceAndRotation);
		if(pieceAndRotation[0]!=0){
			System.out.println("Je suis une pièce F"); //debug
			return;
		}
		PieceI.isMe(x, y, game, pieceAndRotation);
		if(pieceAndRotation[0]!=0){
			System.out.println("Je suis une pièce I"); //debug
			return;
		}
	}
	
	/**
	 * Retourne le nombre de rotation à faire pour passer d'un état à l'autre
	 * @param piece Le numero de la pièce
	 * @param rotationDepart Le statut actuel de la pièce
	 * @param rotationFin Le statut final de la pièce
	 * @return Le nombre de rotation à faire pour passer d'un état à l'autre
	 */ 
	
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
	/**
	 * Retourne le nombre de rotation à faire pour passer dans l'état du pattern 
	 * @param piece Le numero de la pièce
	 * @param pattern Le pattern a faire
	 * @return Le nombre de rotation à faire pour passer dans l'état du pattern 
	 */ 
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
	
	/**
	 * La hauteur de la colonne
	 * @param game La matrice de jeu
	 * @param colonne La colonne à observer
	 * @return La hauteur de la colonne
	 */ 
	
	private static int hauteurColonne(int [][]game, int colonne){
		int ligneDebut=-1;
		for (int i=0; i<game[0].length;i++){
			if (game[colonne][i]!=0){
					ligneDebut=i; 
					break;
			}
		}
		if(ligneDebut==-1)
			return 0;
		return game[0].length-ligneDebut;
	
	}
	/**
	 * La hauteur moyenne du jeu
	 * @param game La matrice de jeu
	 * @return La hauteur moyenne du jeu
	 */ 

	private static int hauteurMoyenne(int[][] game){
		int moyenne=0;
		for (int i=0;i<game.length;i++){
			moyenne+=hauteurColonne(game,i);
		}
		return (moyenne/game[0].length);
	}
	/**
	 * La hauteur max du jeu
	 * @param game La matrice de jeu
	 * @return La hauteur max du jeu
	 */ 
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
 * @param m un tableau a 2 dimensions
 * @return un entier
 */
	private static int compte_lignes_finies(int[][] m){
			int cpt=0;
			int cmpteur;
			int i,j;
			for (j=0; j<m[0].length; j++){
				cmpteur=0;
				for (i=0; i<m.length; i++){
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
 * @param mat un tableau a 2 dimensions
 * @param colonne une colonne
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
 * @param mat Un tableau a 2 dimensions
 * @param pieceEnCours Une Piece
 * @param colonne Une colonne
 * @param rotation Une rotation
 * @return un entier
 */
        private static int compter_trou(int[][] m){
        int nbretrou=0;
                for (int i=0; i<m.length;i++){ //pour chaque colonne
                        nbretrou=nbtrou(m,i)+nbretrou;
                }
        return nbretrou;
        }
       
	/**
	 * Calcul par defaut de la position a placer
	 * @param retour Premier champ contenant le numero de la colonne et le deuxième celui de la rotation
	 * @param piece La piece a placer
	 * @param game La matrice de jeu
	 */
	private static void parDefautbis(int[]retour, Piece piece, int[][] game){
		int minpos=game[0].length;
		int ligne=0;
		int posligne=0;
		int rotateligne=0;
		int maxRotate=piece.getrotation();
		for (int i=0;i<game.length;i++){
			   for (int j=0; j<maxRotate; j++){
				   int positionPlusBas=plusbasDansColonne(i,game);
				   while(positionPlusBas>=0 && !piece.placerPieceAUnEndroitDonneDansLeJeuAvecUneRotationPrecise(i,positionPlusBas,j,game,1)){
						positionPlusBas--;
					}
					int lignedone=compte_lignes_finies(game); 
					if(lignedone>ligne){
						ligne=lignedone;
						posligne=i;
						rotateligne=j;
					}
					else{
						if(positionPlusBas<minpos){
							minpos=positionPlusBas;
							retour[0]=i;
							retour[1]=j;
						}
					}
					piece.placerPieceAUnEndroitDonneDansLeJeuAvecUneRotationPrecise(i,positionPlusBas,j,game,0);
				}
		}
		if(ligne>0){
			retour[0]=posligne;
			retour[1]=rotateligne;
		}
	}
	/**
	 * Calcul par defaut de la position a placer
	 * @param retour Premier champ contenant le numero de la colonne et le deuxième celui de la rotation
	 * @param piece La piece a placer
	 * @param game La matrice de jeu
	 */
	
	private static void parDefaut(int[]retour, Piece piece, int[][] game){
	   int maxRotate=piece.getrotation();
	   int troumin=game.length*game[0].length+1; // init au max des trous
	   int hauteurmax=hauteurMax(game);
	   int test=0;
	   int subi=-1;
	   int subj=-1;
	   for (int i=0;i<game.length;i++){
		   for (int j=0; j<maxRotate; j++){
			   int positionPlusBas=plusbasDansColonne(i,game);
			   while(positionPlusBas>=0 && !piece.placerPieceAUnEndroitDonneDansLeJeuAvecUneRotationPrecise(i,positionPlusBas,j,game,1)){
					positionPlusBas--;
				}
			   if(piece.peuxArriverOuIlVeut(i, positionPlusBas, j, game)){
				   int comptertrou=compter_trou(game);
				   int ligne=compte_lignes_finies(game);
				   if (ligne>test){ //Si tu peux faire des lignes, tu les fais et tu prends le plus grand nbre de ligne
						   test=ligne;
						   subi=i;
						   subj=j;
				   }
				   else if (troumin>comptertrou){
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
			}
			piece.placerPieceAUnEndroitDonneDansLeJeuAvecUneRotationPrecise(i,positionPlusBas,j,game,0);
			   
		   }
	   }
	   if (subi!=-1){
			   retour[0]=subi;
			   retour[1]=subj;
	   }
   }
	/**
	 * Calcul le cout optimal pour placer un pattern
	 * @param tabdepattern Le tableau de pattern valide
	 * @param piecenbr Le numero de la pièce
	 * @param piece La piece a placer
	 * @param game La matrice de jeu
	 * @return l'emplacement le plus optimal
	 */

	private static int calculerCoutPourPattern(int[] tabdepattern, int piecenbr, Piece piece, int [][]game){
		int casseleplus=-1;
		int aToutCasse=0;
		int i=0;
		while(i<tabdepattern.length){
			if(tabdepattern[i]>0){
				int plusBas=plusbasDansColonne(i, game);
				if(piece.placerPieceAUnEndroitDonneDansLeJeuAvecUneRotationPrecise(i, plusBas, rotationPourPattern(piecenbr, tabdepattern[i]), game, 1)){
					int casse=compte_lignes_finies(game);
					if(casse>aToutCasse){
						casseleplus=i;
						aToutCasse=casse;
					}
					piece.placerPieceAUnEndroitDonneDansLeJeuAvecUneRotationPrecise(i, plusBas, rotationPourPattern(piecenbr, tabdepattern[i]), game, 0);
				}
			}
			i++;
		}
		return -1;
	}
	
	/**
	 * Calcul le placement optimal de placement de la piece dans le jeu
	 * @param retour Dans le premier champ la position optimal et le deuxieme la rotation
	 * @param tabdepattern Le tableau de pattern valide
	 * @param pieceNumber Le numero de la pièce
	 * @param piece La piece a placer
	 * @param game La matrice de jeu
	 * @return l'emplacement le plus optimal
	 */

	public static void getTheMaxiMenuBestOfPlusPlus(int[] retour, int pieceNumber, Piece piece, int[] tabdepattern, int[][] game){
		retour[0]=0;
		retour[1]=0;
		boolean usePattern=false;
		int i=0;
		int moyenneDuJeu=hauteurMoyenne(game)+5; // +3 pour compenser si tout le jeu est a la même hauteur np <===== ++--***##IMPORTANT##***--++ remettre hauteurMoyenne(game)+3 quand fini test
		while(i<tabdepattern.length){ // on vire les patterns qui font trop monter le jeu
			if(tabdepattern[i]>0 // si pattern valide
			//&& hauteurColonne(game,i)>=moyenneDuJeu // et pas trop haut
			&& !piece.peuxArriverOuIlVeut(i, plusbasDansColonne(i,game) , rotationPourPattern(pieceNumber, tabdepattern[i]), game) // et qu'on peut placer la pièce 
			){
				tabdepattern[i]=-1;
			}
			else{
				if(tabdepattern[i]>0){
					usePattern=true;
				}
			}
			i++;
		}
		if(usePattern){ // s'il reste des patterns
			System.out.println("Utilisation de pattern");
			i=0;
			int best=calculerCoutPourPattern(tabdepattern, pieceNumber, piece, game);
			if(best==-1){ //aucun n'est special on place le plus bas possible
				int minpattern=-1;
				int hauteurMinPattern=0;
				while(i<tabdepattern.length){ //parcour des patterns
					if(tabdepattern[i]>0){ // si le pattern est cool
						if(minpattern==-1){ //si pas de min pour le moment
							hauteurMinPattern=hauteurColonne(game,i);
							minpattern=i;
						}
						else{
							int hauteurAutrePattern=hauteurColonne(game,i);
							if(hauteurAutrePattern<hauteurMinPattern){
								hauteurMinPattern=hauteurAutrePattern;
								minpattern=i;
							}
						}
					}
					i++;
				}
				retour[0]=minpattern;
				retour[1]=rotationPourPattern(pieceNumber, tabdepattern[minpattern]);
			}
			else{
				retour[0]=best;
				retour[1]=rotationPourPattern(pieceNumber, tabdepattern[best]);
			}
		}
		else{ //paspattern
			System.out.println("Par defaut");
			parDefaut(retour, piece, game);
		}
	}
}
