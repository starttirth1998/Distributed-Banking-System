import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

// Creating Remote interface for our application
public interface Interface_201501051 extends Remote {
   public void printMsg(int account_number) throws RemoteException;
   public Double get_account_balance(int account_number) throws RemoteException;
   public void populate_data() throws RemoteException;
   public void deposit(int account_number, Double amount) throws RemoteException;
   public void withdraw(int account_number,Double amount) throws RemoteException;
   public ArrayList<ArrayList<String>> transaction_details(int account_number,String start_date,String end_date) throws RemoteException;
}
