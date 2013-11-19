/**
 * Classe des pièces
 */

public abstract class Piece{

    /// La position actuel dans le jeu
    protected int x[], y[];
    /// Les positions x et y des pièces en haut au milieu du jeu lors de leur apparition (permet de réinitialiser la position lorque la pièce à déjà fini sa course vers le bas)
    protected int xMid[], yMid[];

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


}
