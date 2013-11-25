// Robot
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
// Client
import java.rmi.* ; 
import java.net.MalformedURLException ; 
import java.util.*; 

public class IA {
    
    static Robot robot;
    static Matrice matrice;
    static int rotationXfois; //combien de fois le robot va devoir rotationner
    static int colonneOuPlacerLeO; //a quelle colonne faut-il placer le 0?
	static Piece PieceEnCours;
    static void my_sleep(int ms)
    {
	try {
	    Thread.sleep(ms);
	} catch(InterruptedException ex) {
	    Thread.currentThread().interrupt();
	}
    }
    
    static public void run(String exec)
    {
	try {
	    Runtime.getRuntime().exec(exec);
	    System.out.println("IA : Wait running "+exec);
	    my_sleep(1000);
	} catch (IOException ex) {
	    Logger.getLogger(IA.class.getName()).log(Level.SEVERE, null, ex);
	}
    }
    
    public static void send_key(int key) 
    { int k=0;
	switch (key) {
	case 0:k = KeyEvent.VK_RIGHT;	break; 	// 0:Droite
	case 1:k = KeyEvent.VK_LEFT; 	break;	// 1:Gauche
	case 2:k = KeyEvent.VK_UP;	break;	// 2:Rotation
	case 3:k = KeyEvent.VK_DOWN; 	break;	// 3:Tomber
	case 4:k = KeyEvent.VK_SPACE; 	break; //4:Action_fall
	};
	robot.keyPress(k);
	robot.keyRelease(k); 	        
    }

    public static void display_matrice(int t[][])
    {   int x,y;
	System.out.println("Matrice vue par la IA : ");
	for (y=0;y<20;y++) {
	    for (x=0;x<10;x++) {
		if (t[x][y]!=0) {
		    System.out.print("[]");
		} else {
		    System.out.print("--");
		}		
	    }
	    System.out.println("");
	}
    }

    public static int[][] get_matrice()
    { int [][] result=null;
	try {
	    do {
		result = matrice.get_matrice();
		if (result == null) my_sleep(10);
	    } while (result == null);
	} catch (RemoteException re) { System.out.println(re) ; }
	return result;
    }
    
   
    
    
    /////////////////////////////////////////////////////////
   int[][] copier_matrice(Matrice m){
		int i,j;
		int[][] matrice = new int[m.sizeX][m.sizeY];
		for (i=0;i<10;i++){
			for (j=0; j<20 ; j++){
				matrice[i][j]=m.get(i,j);
			}
		}
		return matrice;
	}
	
	Piece depistage_Piece(int [][] m){
		int SizeX=m.length/2;
		int SizeY=m[0].length;
		Piece piece;
		int i,j;
		if (m[SizeX][1]>=1 && m[SizeX-1][1] >=1 && m[SizeX][0]>=1 && m[SizeX+1][0]>=1)
			piece=new Piece4(matrice);
		else if (m[SizeX][1]>=1 && m[SizeX+1][1]>=1 && m[SizeX][0]>=1 && m[SizeX-1][0]>=1)
			piece=new Piece4Inv(matrice);
		else if (m[SizeX][0]>=1 && m[SizeX-1][0]>=1 && m[SizeX-1][1]>=1 && m[SizeX][1]>=1)
			piece=new PieceCarre(matrice);
		else if (m[SizeX][0]>=1 && m[SizeX-1][0]>=1 && m[SizeX+1][0]>=1 && m[SizeX+1][1]>=1)
			piece=new PieceF(matrice);
		else if (m[SizeX][0]>=1 && m[SizeX-1][0]>=1 && m[SizeX+1][0]>=1 && m[SizeX+2][0]>=1)
			piece=new PieceI(matrice);
		else if (m[SizeX][0]>=1 && m[SizeX+1][0]>=1 && m[SizeX-1][0]>=1 && m[SizeX-1][1]>=1)
			piece=new PieceL(matrice);
		else if (m[SizeX][0]>=1 && m[SizeX][1]>=1 && m[SizeX+1][0]>=1 && m[SizeX-1][0]>=1)
			piece=new PieceT(matrice);
		else piece = new Piece4(matrice);
			
		return piece;
	}
	
	int [][] save_tableau(int [][] tab){
		int[][] mAux=new int[tab.length][tab[0].length];
		int i,j;
		for (i=0;i<tab.length;i++){
			for (j=0;j<tab[0].length;j++){
				mAux[i][j]=tab[i][j];
			}
		}
		return mAux;
	}
	
	/*void jeu_fini(Matrice m); //a faire...
	
	
	void jouer_piece(int[][] m, Piece p,int colonne, int rotate){// a faire
	}
	void dejouer_piece(int [][]m, Piece p){} //a faire
	int associeValeurauCoup(int [][] grille,int colonne, int rotate){//a faire
		int rval=0;
		return rval;
	}
	void recupererRotationEtColonne(Piece piece, int [][]grille){//a faire
	rotationXfois=0;
	colonneOuPlacerLeO=0;
	}
	*/
	
	int compte_lignes_finies(int[][] m){
		int cpt=0;
		int cmpteur;
		int i,j;
		for (j=0;j<m[0].length;j++){
			cmpteur=0;
			for (i=0; i<m.length;i++){
				if (m[i][j]>=1)
				cmpteur++;
			}
			if (cmpteur==10)
				cpt++;
		}
	return cpt;
	}
    int nbtrou(int[][] mat,int colonne){
		int ligneDebut=19; //tout dernier ligne
		int cpt=0; 
		int i,j;
		for (i=0; i<20;i++){
			if (mat[colonne][i]>=1)
				ligneDebut=i; 
		}
		for (j=i; j<20; j++){
			if (mat[colonne][j]==0)
				cpt++;
		}
		return cpt;
	}
	
	
	int compter_trou(int[][] m, Piece pieceEnCours,int colonne, int rotation){
	int nbretrou=0;
//	jouer_piece(m,pieceEnCours,colonne,rotation);
		for (int i=0; i<10;i++){ //pour chaque colonne
			nbretrou=nbtrou(m,i)+nbretrou;
		}
	return nbretrou;
	}
	
	 public static void main(String[] args) throws AWTException, IOException {	
	// Execution 
	run("java tetris");
	// Robot
	try {
	    robot = new Robot();
	    robot.setAutoDelay(100); // 100 ms
	    robot.setAutoWaitForIdle(false);
	} catch (AWTException ex) {
	    Logger.getLogger(IA.class.getName()).log(Level.SEVERE, null, ex);
	}
	// Client
	try {
	    matrice = (Matrice)Naming.lookup("//localhost/matrice");
	} catch (MalformedURLException e) { System.out.println(e) ; }
	catch (NotBoundException re) { System.out.println(re) ; }

/*	int[][] grille = new int[10][20];
	int i;
	Jeu j = new Jeu ();//a remplir
	boolean fini=false;
	while(!fini){
		grille=copier_matrice(matrice);
		recupererRotationEtColonne(pieceEnCours, grille); 
		//c'es la suite de la fonction "associéValeurauCoup", 
		//elle recupere combien de fois on doit appuyer sur la 
		//touche de rotation, et ou on doit l bouger, en fonction de la case "0"
		for (i=0; i<rotationXfois; i++) // X rotation
			send_key(2);
		if (colonneOuPlacerLeO>0){ // la colonne est a droite
			for (i=0; i<colonneOuPlacerLeO; i++)
				send_key(0);
		}
		else if (colonneOuPlacerLeO<0){ // la colonne est a gauche
			for (i=0; i>colonneOuPlacerLeO; i--)
				send_key(1);
		}

		send_key(4);
		if (jeu_fini(matrice))
			fini=true;
	
	}
*/	
   }

} 
