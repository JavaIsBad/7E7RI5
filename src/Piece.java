/**
 * Classe des pièces
 */

public abstract class Piece{

    /// La position actuel dans le jeu
    protected int x[], y[];
    /// Les positions x et y des pièces en haut au milieu du jeu lors de leur apparition (permet de réinitialiser la position lorque la pièce à déjà fini sa course vers le bas)
    protected int xMid[], yMid[];
    protected int rotation;


    /**
     * Dessine la pièce sur la matrice de jeu
     * @param m La matrice de jeu
     */
    public void dessinerPiece(Matrice m, int couleur){
        for(int i=0; i<x.length; i++)
            m.put(x[i],y[i],couleur);
    }

    /**
     * Efface la pièce de la matrice de jeu
     * @param m La matrice de jeu
     */
    public void effacerPiece(Matrice m){
        for(int i=0; i<x.length; i++)
            m.put(x[i],y[i],0);
    }

    /**
     * Fait descendre la pièce dans le jeu
     */
    public void tomberPiece(){
        for(int i=0; i<y.length; i++)
            y[i]+=1;
    }

    /**
     * Fait remonter une pièce dans le jeu
     */
    public void remonterPiece(){
        for(int i=0; i<y.length; i++)
            y[i]-=1;
    }

    /**
     * Bouge la pièce d'un cran vers la gauche
     */
    public void gauche(){
        for (int i=0; i<x.length; i++)
            x[i]-=1;
    }

    /**
     * Bouge la pièce d'un cran vers la droite
     */
    public void droite(){
        for (int i=0; i<x.length; i++)
            x[i]+=1;
    }

    /**
     * Effectue une rotation gauche de la pièce dans le jeu
     */
    public abstract void rotationner();

    /**
     * Renvoit les positions occupées par la pièce en x
     * @return Les positions de la pièce en x
     */
    public int[] getX(){
        return x;
    }

    /**
     * Renvoit les positions occupées par la pièce en y
     * @return Les positions de la pièce en y
     */
    public int[] getY(){
        return y;
    }

    /**
     * Initialise la position de la pièce dans le jeu
     */
    public void reinit(){
        for(int i=0; i<x.length; i++){
            x[i]=xMid[i];
            y[i]=yMid[i];
        }
    }

    /**
     * Effectue une rotation vers la droite de la pièce
     */
    public abstract void antirotation();

	/**
	 * renvoie le nombre maximum de rotation pour une piece
	 */	
	public abstract int getrotation();
	
	/** 
	 * Renvoit vrai si la pièce est en collision dans le jeu sans qu'elle soit elle même dans le jeu
	 * @param game La matrice de jeu
	 * @return true si elle est en collision, false sinon
	 */
	
	public boolean collision(int [][] game){
        boolean colli=false;
        for(int i=0; !colli && i< x.length; i++)
            colli= colli || x[i]>=game.length || x[i]<0 || y[i]>=game[0].length || y[i]<0 || game[x[i]][y[i]] != 0;
        return colli;
    }
    
    /**
     * Place la pièce dans le jeu sans se soucier du jeu
     * @param x2 La coordonnée de la position la plus a gauche (du carré le plus bas)
     * @param y2 La coordonnée de la position le plus en bas
     * @param rotate La rotation dans laquel la pièce doit être placé
     * @param game La matrice de jeu
     * @param value La valeur a placer dans la matrice
     * @return true si la piece a été positionné, false sinon
     */
    
	public boolean placerPieceAUnEndroitDonneDansLeJeuAvecUneRotationPrecise( int x2, int y2, int rotate, int[][] game, int value){ //value => 0=plus là, 1=là
		reinit();
		while(rotate!=rotation){
			antirotation();
		}
		int minx=x[0],maxy=y[0];
		for(int i=1; i<y.length; i++)
			if(maxy<y[i]){
				minx=x[i];
				maxy=y[i];
			}
			else
				if(maxy==y[i]){
					if(minx>x[i])
						minx=x[i];
				}
		if(minx>x2)
			for(;minx>x2;minx--)
				gauche();
		else
			if(minx<x2)
			for(;minx<x2;minx++)
				droite();
		int combienDescendre=y2-maxy;
		for(int i=0; i<y.length; i++){
			y[i]+=combienDescendre;
			if(x[i]<0 || x[i]>=game.length || y[i]<0 || y[i]>=game[0].length)
				return false;
		}
		for(int i=0; i<y.length; i++){
			game[x[i]][y[i]]=value;
		}
		return true;
	}
	
	/**
     * Test si la pièce peut arriver à sa position dans le jeu
     * @param x2 La coordonnée de la position la plus a gauche (du carré le plus bas)
     * @param y2 La coordonnée de la position le plus en bas
     * @param rotate La rotation dans laquel la pièce doit être placé
     * @param game La matrice de jeu
     * @return true si la piece peut y arriver, false sinon
     */
    
	public boolean peuxArriverOuIlVeut(int x2, int y2, int rotate, int[][] game){
		reinit();
		if (collision(game)){
			return false;
		}
		if(rotate!=rotation)
			tomberPiece();
		while(rotate!=rotation){
			antirotation();
			if (collision(game)){
				return false;
			}
		}
		int minx=x[0],maxy=y[0];
		for(int i=1; i<x.length; i++){
			if(maxy<y[i]){
				maxy=y[i];
				minx=x[i];
			}
			else{
				if(maxy==y[i]){
					if(minx>x[i])
						minx=x[i];
				}
			}
		}
		while(minx>x2){
			gauche();
			if(collision(game))
				return false;
			minx--;
		}
		while(minx<x2){
			droite();
			if(collision(game))
				return false;
			minx++;
		}
		int combienDescendre=y2-maxy;
		while(combienDescendre!=0){
			tomberPiece();
			if(collision(game))
				return false;
			combienDescendre--;
		}
		return true;
	}

}
