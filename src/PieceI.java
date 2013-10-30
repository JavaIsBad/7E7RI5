/**
 * [ 2 ][ 1 ][ 3 ][ 4 ]
 */

public class PieceI extends Piece{
	static int x1,x2,x3,x4;
	static int y1,y2,y3,y4;
	static int rotate; 
	
	public PieceI(){ // la piece est en haut
		x1=5;
		y1=0;
		x2=4;
		y2=0;
		x3=6;
		y3=0;
		x4=7;
		y4=0;
		rotate=0; // Piece applati
		}
	
	public pieceI(int x, int y){ // la piece apparait couchée et le point de rotation, c'est le deuxieme en partant de la gauche
		x1=x;
		y1=y;
		x2=x-1;
		y2=y;
		x3=x+1;
		y3=y;
		x4=x+2;
		y4=y;
		rotate=0;
	}
	public void modifierPiece(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4){
		this.x1=x1;
		this.y1=y1;
		this.x2=x2;
		this.y2=y2;
		this.x3=x3;
		this.y3=y3;
		this.x4=x3;
		this.y4=y3;

	}
	public void dessinerPiece(Matrice m){
		if (x1 >= 0 && x1 <= 8 && x2 >= 0 && x2 <= 8 && x3 >= 0 && x3 <= 8 && x4 >= 0 && x4 <= 8 &&
		y1 >= 0 && y1 <= 20 && y2 >= 0 && y2 <= 20 && y3 >= 0 && y3 <= 20 && y4 >= 0 && y4 <= 20 &&){
		m.put(x1,y1,true);
		m.put(x2,y2,true);
		m.put(x3,y3,true);
		m.put(x4,y4,true);
		}
	}
	public void effacerPiece(Matrice m){
		m.put(x1,y1,false);
		m.put(x2,y2,false);
		m.put(x3,y3,false);
		m.put(x4,y4,false);
	}
	public void tomberPiece(Matrice m){
		if (y1 <= 19 && y2 <= 19 && y3 <= 19 && y4 <= 19){
		effacerPiece(m);
		modifierPiece(x1,y1+1,x2,y2+1,x3,y3+1,x4,y4+1);
		dessinerPiece(m);
	}
	}
	
	public void rotationner(Matrice m){
			switch(rotate)
		case 0 :
		if (y1>0 && y1<18){
			effacerPiece(m);
			modifierPiece(x1,y1,x1,y1-1,x1,y1+1,x1,y1+2);
			dessinerPiece(m);
			rotate=1;
		}
		
		case 1 :
		if (x1>0 && x1<7){
			effacerPiece(m);
			modifierPiece(x1,y1,x1-1,y1,x1+1,y1,x1+2,y1);
			dessinerPiece(m);
			rotate=1;
		}
		
		default :
		 System.exit(-1);
	}

}
