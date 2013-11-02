/**
 *      [ 2 ][ 3 ]
 * [ 1 ][ 0 ]
 *
 * rotation autour du 0 :
 *     [ 1 ]
 *     [ 0 ][ 2 ]
 *          [ 3 ]
 *
 *          On fait les testes de rotation et descente dans tetris le jeu ici osef
 *          sa permet de faire des tests générique et non 1 pour chaque pièce
 *          en gros on fait la rotation et si sa rentre en colision on fait la rotation inverse
 *          et on ne fait rien dans la grille du jeu
 *          et pour la descente on test dans tetris si en descendant sa rentre pas en colision avec une autre pièce ou
 *          le sol et dans ce cas la on passerait a la pièce suivante (cas d'arret de la descente d'une pièce)
 */

public class Piece4 extends Piece{
    /// Les positions x et y des pièces en haut au milieu du jeu lors de leur apparition (permet de réinitialiser la position lorque la pièce à déjà fini sa course vers le bas)
    private int xMid[]=new int[4], yMid[]=new int[4];
    /// La position actuel dans le jeu
    private int x[]=new int[4], y[]=new int[4];
    /// Indique dans quel état de rotation la pièce se trouve (ici que 2 possible)
    private boolean rotation;

    public Piece4(Matrice m){
        initPosition(m);
        rotation=false;
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

    public void dessinerPiece(Matrice m){
        for(int i=0; i<x.length; i++)
            m.put(x[i],y[i],true);
    }

    public void effacerPiece(Matrice m){
        for(int i=0; i<x.length; i++)
            m.put(x[i],y[i],false);
    }

    public void tomberPiece(){
            for(int i=0; i<y.length; i++)
                y[i]+=1;
    }

	public void gauche(){
			for (int i=0; i<x.length; i++)
				x[i]-=1;
	}
	
	public void droite(){
		for (int i=0; i<x.length; i++)
				x[i]+=1;
	}
 
    public void rotationner(){
        if(rotation){ // déjà en position de rotation
            x[1]+=1;
            y[1]-=1;
            x[2]+=1;
            y[2]+=1;
            y[3]+=2;
        }
        else{
            x[1]-=1;
            y[1]+=1;
            x[2]-=1;
            y[2]-=1;
            y[3]-=2;
        }
        rotation=!rotation;
    }

    /**
     * Fait une rotation inverse
     */

    public void antirotation(){
        rotationner(); // ici il suffit de faire une rotation pour revenir aux positions de départ
    }

    /**
     * Remet la pièce dans sa position de départ de descente
     */

    public void reinit(){
        for(int i=0; i<x.length; i++){
            x[i]=xMid[i];
            y[i]=yMid[i];
        }
    }

    public int[] getX(){
        return x;
    }

    public int[] getY(){
        return y;
    }
}
