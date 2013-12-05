import java.util.Timer;
import java.util.TimerTask;
import java.awt.Color;
public class Jeu {

    private static final int[] points={0, 40, 100, 300, 1200};
    private Piece[] piecejeu;
    private int couleurEnCours;
    private Piece pieceEnCours;
    private Matrice matrice;
    private GameWindow gamewindow;
    private int Points=0,cptLigne;
    private Timer timer=null;
    private TimerTask task;
    private int vitesse=0;
    private boolean pause=false;
    
    public void basGauche(int[] coord){
		int[]x=pieceEnCours.getX();
		int[]y=pieceEnCours.getY();
		int maxy=y[0];
		int minx=x[0];
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
		coord[0]=minx;
		coord[1]=maxy;
	}

    public Jeu(Piece[] pj, Matrice m, GameWindow gw){
        if(pj!=null && m!=null && gw!=null){
            piecejeu=pj;
            matrice=m;
            gamewindow=gw;
        }
        else
            System.exit(1);
    }

    public synchronized void action_pause(){
        if(!pause){
            timer.cancel();
            pause=true;
        }
        else{
            timer=new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                public void run() {
                    action_fall();
                }
            }, 100, vitesse);
            pause=false;
        }
    }


    public synchronized void action_right()
    {
        if(!pause){
            pieceEnCours.effacerPiece(matrice);
            pieceEnCours.droite();
            if(collision(pieceEnCours))
                pieceEnCours.gauche();
            pieceEnCours.dessinerPiece(matrice, couleurEnCours);
            gamewindow.refresh();
        }
    }

    public synchronized void action_left()
    {
        if(!pause){
            pieceEnCours.effacerPiece(matrice);
            pieceEnCours.gauche();
            if(collision(pieceEnCours))
                pieceEnCours.droite();
            pieceEnCours.dessinerPiece(matrice, couleurEnCours);
            gamewindow.refresh();
        }
    }

    public synchronized void action_rotation()
    {
        if(!pause){
            pieceEnCours.effacerPiece(matrice);
            pieceEnCours.antirotation();
            if(collision(pieceEnCours))
                pieceEnCours.rotationner();
            pieceEnCours.dessinerPiece(matrice, couleurEnCours);
            gamewindow.refresh();
            gaucheGauche();
        }
    }

    public synchronized void action_fall()
    {
        if(!pause){
            pieceEnCours.effacerPiece(matrice);
            pieceEnCours.tomberPiece();
            if(collision(pieceEnCours)){
                pieceEnCours.remonterPiece();
                pieceEnCours.dessinerPiece(matrice, couleurEnCours);
                Points+=enleverLignesRemplies();
                itsShowTime();
            }
            else{
                pieceEnCours.dessinerPiece(matrice, couleurEnCours);
                gamewindow.refresh();
            }
        }
    }

    public synchronized void action_tomber(){
        if(!pause){
            pieceEnCours.effacerPiece(matrice);
            do{
                pieceEnCours.tomberPiece();
            } while(!collision(pieceEnCours));

            pieceEnCours.remonterPiece();
            pieceEnCours.dessinerPiece(matrice, couleurEnCours);
            Points+=enleverLignesRemplies();
            itsShowTime();
        }
    }


    /**
     * Sert a faire "tomber une ligne"
     * @param n, la ligne a faire tomber
     */
    private void descendreLigne(int n){
        for (int i=0; i<matrice.sizeX; i++){
            matrice.put(i,n+1,matrice.get(i,n));
            matrice.put(i,n,0);
        }
    }

    /**
     * Détruit une ligne, et fais descendre toutes celles du dessus
     * @param n, la ligne à détruire
     */
    private void detruireLigne(int n){
        for (int j=n-1; j>=0;j--){ //on fait descendre toutes les cases
            descendreLigne(j);
        }
    }
    /** Test si la ligne est remplie
     * @param n, la ligne a testé
     * @return true si oui, false sinon
     */
    private boolean ligneRemplie(int n){
        boolean bool = true;
        for (int i=0; bool && i<matrice.sizeX; i++)
            bool=bool && matrice.isSomething(i,n);
        return bool;
    }

    /**
     * Fonction servant a calculer le nombre de points gagnés par un coup
     * @param n, le nombre de ligne détruites
     * @return le nombre de points gagnés
     */
    private int compterPoints(int n){
        return points[n];
    }
    /**
     * Test le jeu, et regarde si des lignes ont été remplies par le coup précédent,
     * Si oui, les effaces, et attribue un score au coup
     * @return un entier, égal au nombre de point gagner par la personne
     */
    private int enleverLignesRemplies(){
        int cpt=0;
        for (int i=0; i<matrice.sizeY; i++){
            if (ligneRemplie(i)){
                detruireLigne(i);
                i--;
                cpt++;
            }
        }
        cptLigne+=cpt;
        return compterPoints(cpt);
    }

    public boolean collision(Piece P){
        boolean colli=true;
        int x[]=P.getX();
        int y[]=P.getY();
        for(int i=0; colli && i< x.length; i++)
            colli= colli && !(x[i]>= matrice.sizeX || x[i] < 0 || y[i] >= matrice.sizeY || y[i] < 0 || (matrice.isSomething(x[i],y[i])));
        return !colli;
    }

    private void finDuJeu(){
        System.out.println("Nombre de lignes détruites : "+cptLigne);
        System.out.println("Nombre de points : "+Points);
        System.exit(0);
    }

    public void itsShowTime(){ // fonction du jeu
        int postvitesse;
        int random=(int)(Math.random()*piecejeu.length);
        pieceEnCours=piecejeu[random];
        pieceEnCours.reinit();
        couleurEnCours=random+1;
        if(collision(pieceEnCours))
            finDuJeu();
        pieceEnCours.dessinerPiece(matrice, couleurEnCours);
        if(vitesse!=250 && vitesse!=(750-50*(cptLigne/10))){
            vitesse=750-50*(cptLigne/10);
            if(timer!=null)
                timer.cancel();
            timer=new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                public void run() {
                    action_fall();
                }
            }, 100, vitesse);

        }
        basGauche(matrice.positionPiece);
        gaucheGauche();
        matrice.refresh();
        gamewindow.refresh();
    }
    
    public void gaucheGauche(){
		int[]x=pieceEnCours.getX();
		int xmin=x[0];
		for(int i=0; i<x.length; i++)
			if(xmin>x[i])
				xmin=x[i];
		matrice.positionGauche=xmin;
	}
		
}
