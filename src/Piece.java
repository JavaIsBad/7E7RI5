public abstract class Piece{
    /**
     * Dessine la pièce sur la matrice de jeu
     * @param m La matrice de jeu
     */
    public abstract void dessinerPiece(Matrice m);

    /**
     * Efface la pièce de la matrice de jeu
     * @param m La matrice de jeu
     */
    public abstract void effacerPiece(Matrice m);

    /**
     * Fait descendre la pièce dans le jeu
     */
    public abstract void tomberPiece();
    /**
     * Bouge la pièce d'un cran vers la gauche
     */
    public abstract void gauche();

    /**
     * Bouge la pièce d'un cran vers la droite
     */
    public abstract void droite();

    /**
     * Effectue une rotation de la pièce dans le jeu
     */
    public abstract void rotationner();

    /**
     * Renvoit les positions occupées par la pièce en x
     * @return Les positions de la pièce en x
     */
    public abstract int[] getX();
    /**
     * Renvoit les positions occupées par la pièce en y
     * @return Les positions de la pièce en y
     */
    public abstract int[] getY();


}
