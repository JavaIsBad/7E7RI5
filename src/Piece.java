public abstract class Piece{
	
	 // c'est pas tres tres orienté objet tout ce que j'ai fait, mais comme j'ai fait ça assez rapido, j'ai dis fuck
	 // et je l'ai fait :p
	public piece(){
	}
	abstract public modifierPiece(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4){ // modifier une piece
	}
	abstract public void dessinerPiece(Matrice m){ // dessine la piece sur m
	}
	abstract public void effacerPiece(Matrice m){ // efface la piece
	}
	abstract public void tomberPiece(Matrice m){ //on fait descendre tous les y
	}
	abstract public void rotationner(Matrice m){ //que des rotations vers la gauche
	}
	


}
