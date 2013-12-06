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
    static MatriceInterface matrice;

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
	case 4:k = KeyEvent.VK_SPACE; break;  // 4: fall
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
	} catch (RemoteException re) {System.exit(0);}
	return result;
    }
    
    public static void main(String[] args) throws AWTException, IOException {
		Piece []pieceia=new Piece[7];
		Piece pieceJeu=null;	
		// Execution 
		run("java Tetris");
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
			matrice = (MatriceInterface)Naming.lookup("//localhost/matrice");
		} catch (MalformedURLException e) { System.out.println(e) ; }
		catch (NotBoundException re) { System.out.println(re) ; }
		int[] coord=new int[2];
		int[] piecerotation=new int[2];
		int[][] montab;
		while((montab=get_matrice())==null);
		pieceia[0]=new PieceCarre(montab.length);
		pieceia[1]=new PieceL(montab.length);
		pieceia[2]=new PieceF(montab.length);
		pieceia[3]=new Piece4(montab.length);
		pieceia[4]=new Piece4Inv(montab.length);
		pieceia[5]=new PieceT(montab.length);
		pieceia[6]=new PieceI(montab.length);
		int []tabdepattern=new int[montab.length];
		while(true){
			montab=get_matrice();
			if(montab==null)
				continue;
			int[] posistop=null;
			try{
				posistop=matrice.get_coord();
			}
			catch(Exception e){
				System.exit(0);
			}
			SurfaceIa.piece(posistop[0], posistop[1], montab, piecerotation);
			SurfaceIa.rempliePattern(piecerotation[0], tabdepattern, montab);
			pieceJeu=pieceia[piecerotation[0]-1];
			pieceJeu.placerPieceAUnEndroitDonneDansLeJeuAvecUneRotationPrecise(posistop[0], posistop[1], piecerotation[1], montab, 0);
/*
			for(int t=0; t<tabdepattern.length; t++){
					System.out.println(tabdepattern[t]);
				}
*/
			int[] retour={0,0};
			SurfaceIa.getTheMaxiMenuBestOfPlusPlus(retour, piecerotation[0], pieceJeu, tabdepattern, montab);
			int nbrotationafaire=SurfaceIa.nombreDeRotationsAFairePourPasserDuneRotationALaBonneRotationPourUnePieceDonnee(piecerotation[0], piecerotation[1], retour[1]);
			send_key(3);
			for(int i=0;i<nbrotationafaire;i++){
				send_key(2);
/*
				my_sleep(1);
*/
			}
			int gauche=0;
			try{
				gauche=matrice.getGauche();
			}catch(Exception e){}
			System.out.println(gauche);
			if(gauche>retour[0])
				for(;gauche>retour[0];gauche--)
					send_key(1);
			else
				for(;gauche<retour[0 ];gauche++)
					send_key(0);
			send_key(4);
		}
		// For Example
		/*
		String txt="0000030303333313131111122222222233333333333333333330000000202022222121211";
		for (int j=0; j<txt.length(); j++) {	   
			send_key((int)(txt.charAt(j)-'0'));
			my_sleep(100);
			display_matrice(get_matrice());
		}
		*/
    }
} 
