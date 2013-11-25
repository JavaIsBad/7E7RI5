import java.rmi.server.UnicastRemoteObject ;
import java.rmi.RemoteException ;

class Matrice extends UnicastRemoteObject implements MatriceInterface {

    int matrice_IA[][];
    int matrice[][];
    int sizeX, sizeY;
    private boolean is_busy;

    public Matrice() throws RemoteException
    {
        super();
        matrice = new int[10][20];
        matrice_IA = new int[10][20];
        sizeX=10;
        sizeY=20;
    };

    // Appel distant pour la IA
    public int[][] get_matrice() throws RemoteException {
        if (is_busy) return null;
        return matrice_IA;
    }
    // Fin de l'appel distant.

    public void refresh()
    {  int x,y;
        is_busy = true;
        for (y=0;y<20;y++) for (x=0;x<10;x++) matrice_IA[x][y] = matrice[x][y];
        is_busy = false;
    }

    public void put(int x,int y,int v)
    {
        matrice[x][y] = v;
    }

    public int get(int x,int y)
    {
        return matrice[x][y];
    }

    public boolean isSomething(int x, int y){
        boolean b=false;
        if(matrice[x][y]!=0)
            b=true;
        return b;
    }
}
