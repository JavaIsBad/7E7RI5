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
    static Matrice matriceIA;
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
    /**
     * Copie une matrice dans une autre
     * @param m, une matrice
     * @return une matrice
     */
   Matrice copier_matrice(Matrice m){
		int i,j;
		Matrice matrice = new Matrice();
		for (i=0;i<10;i++){
			for (j=0; j<20 ; j++){
				matrice.put(i,j,m.get(i,j));
			}
		}
		return matrice;
	}
	
	/**
	 * Depiste la piece qui est jouée
	 * @param m, une matrice
	 * @return la piece en cours
	 */
	Piece depistage_Piece(Matrice m){
		int SizeX=m.sizeX/2;
		int i,j;
		if (m.get(SizeX,1)>=1 && m.get(SizeX-1,1) >=1 && m.get(SizeX,0)>=1 && m.get(SizeX+1,0)>=1)
			PieceEnCours=new Piece4(matrice);
		else if (m.get(SizeX,1)>=1 && m.get(SizeX+1,1)>=1 && m.get(SizeX,0)>=1 && m.get(SizeX-1,0)>=1)
			PieceEnCours=new Piece4Inv(matrice);
		else if (m.get(SizeX,0)>=1 && m.get(SizeX-1,0)>=1 && m.get(SizeX-1,1)>=1 && m.get(SizeX,1)>=1)
			PieceEnCours=new PieceCarre(matrice);
		else if (m.get(SizeX,0)>=1 && m.get(SizeX-1,0)>=1 && m.get(SizeX+1,0)>=1 && m.get(SizeX+1,1)>=1)
			PieceEnCours=new PieceF(matrice);
		else if (m.get(SizeX,0)>=1 && m.get(SizeX-1,0)>=1 && m.get(SizeX+1,0)>=1 && m.get(SizeX+2,0)>=1)
			PieceEnCours=new PieceI(matrice);
		else if (m.get(SizeX,0)>=1 && m.get(SizeX+1,0)>=1 && m.get(SizeX-1,0)>=1 && m.get(SizeX-1,1)>=1)
			PieceEnCours=new PieceL(matrice);
		else if (m.get(SizeX,0)>=1 && m.get(SizeX,1)>=1 && m.get(SizeX+1,0)>=1 && m.get(SizeX-1,0)>=1)
			PieceEnCours=new PieceT(matrice);
		else PieceEnCours = null;
			
		return PieceEnCours;
	}
	
	public boolean collision(Piece P){
        boolean colli=true;
        int x[]=P.getX();
        int y[]=P.getY();
        for(int i=0; colli && i< x.length; i++)
            colli= colli && !(x[i]>= matrice.sizeX || x[i] < 0 || y[i] >= matrice.sizeY || y[i] < 0 || (matrice.isSomething(x[i],y[i])));
        return !colli;
    }
	/**
	 * Regarde si un jeu est fini
	 * @return true si le jeu est fini, false sinon
	 */
	public boolean jeu_fini(){
		return collision(PieceEnCours);
	}
	
	/**
	 * Renvoie la partie la plus a gauche d'une piece
	 * @param une Piece
	 * @return une colonne
	 */
	public int partie_gauche(Piece p){
		int i;
		int value=p.x[0];
		for (i=1;i<p.x.length;i++){
			if (p.x[i]<value)
				value=p.x[i];
			}
		return value;
	}
	
	/**
	 * Renvoie la partie la plus a droite d'une piece
	 * @param une Piece
	 * @return une colonne
	 */
	public int partie_droite(Piece p){
		int i;
		int value=p.x[0];
		for (i=1;i<p.x.length;i++){
			if (p.x[i]>value)
				value=p.x[i];
			}
		return value;
	}
	
	/**
	 * Renvoie le nombre maximum de rotation pour une piece
	 * @param p, une piece
	 * @return un int
	 */
	public int rotationMax(Piece p){
		return p.getrotation();
	}
	
	/**
	 * déplace la piece en cours pour que la case 0 corresponde a la colonne
	 * @param colonne, un entier
	 * @param p, une Piece
	 */
	public void deplacer_piece(int colonne, Piece p){
		int value = p.x[0]-colonne;
		if (value > 0){
			for (int i=0; i<value; i++)
				p.droite();
		}
		else if (value < 0){
			for (int i=0; i>value ;i--)
				p.gauche();
		} 
	}
	
	/**
	 * Compte le nombre de trou dans 1 colonne
	 * @param m, une matrice
	 * @param colonne, un entier
	 * @return le nombre de trous dans la colonne
	 */
	public int nbTrou(Matrice m, int colonne){
		int i,j=19;
		int cpt=0;
		for (i=0; i<m.sizeY;i++)
			if (m.get(i,colonne) >= 1){
				j=i;
				break;
			}
		for (i=j; i<m.sizeY;i++){
			if (m.get(i,colonne) == 0){
				cpt++;
			}
		}		
	return cpt;
}
	
	/**
	 * Compte le nombre de trou dans une Matrice
	 * @param m, une Matrice
	 * @return le nombre de trou dans la matrice
	 */
	 public int compter_trou(Matrice m){
		 int cpt=0;
		 for (int i=0; i<m.sizeX; i++){
			 cpt+=nbTrou(m,i);
		 }
	return cpt;
	}
	/*
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
