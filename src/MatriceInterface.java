import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MatriceInterface extends Remote {
    public int[][] get_matrice() throws RemoteException;
}
