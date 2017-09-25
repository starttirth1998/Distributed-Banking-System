import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.io.*;
import java.util.ArrayList;
import java.util.Formatter;

public class Client_201501051 {
   private Client_201501051() {}
   public static void main(String[] args) {
      try {
         // Getting the registry
         Registry registry = LocateRegistry.getRegistry(null);

         // Looking up the registry for the remote object
         Interface_201501051 stub = (Interface_201501051) registry.lookup("Interface_201501051");

         // Calling the remote method using the obtained object
         //stub.populate_data();
         while(true)
         {
	         System.out.printf(">> ");
           java.io.BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
           String text_input;
           text_input = in.readLine();
           String[] words = text_input.split(" ");
           if(words[0].equals("exit"))
           {
             break;
           }
           else if(words[0].equals("print"))
           {
             stub.printMsg(Integer.parseInt(words[1]));
           }
           else if(words[0].equals("deposit"))
           {
             try
             {
               stub.deposit(Integer.parseInt(words[1]),Double.parseDouble(words[2]));
             }
             catch(Exception e)
             {
               System.out.println("Argument not provided");
               continue;
             }
             System.out.println("Deposited");
           }
           else if(words[0].equals("withdraw"))
           {
             try
             {
               stub.withdraw(Integer.parseInt(words[1]),Double.parseDouble(words[2]));
             }
             catch(Exception e)
             {
               System.out.println("Argument not provided");
               continue;
             }
             System.out.println("Withdraw done");
           }
           else if(words[0].equals("balance"))
           {
             try
             {
               System.out.println("Current Balance:" + stub.get_account_balance(Integer.parseInt(words[1])));
             }
             catch(Exception e)
             {
               System.out.println("Argument not provided");
               continue;
             }
           }
           else if(words[0].equals("history"))
           {
             ArrayList<ArrayList<String>> history;
             try
             {
               if(words[2].equals("all"))
               {
                 history = stub.transaction_details(Integer.parseInt(words[1]),"2016-10-10-00-00-00","2018-10-10-00-00-00");
               }
               else
               {
                 history = stub.transaction_details(Integer.parseInt(words[1]),words[2],words[3]);
               }
             }
             catch(Exception e)
             {
               System.out.println("Argument not provided: history yyyy-MM-dd-HH-mm-ss yyyy-MM-dd-HH-mm-ss");
               continue;
             }
             //System.out.println(history.size());
             ArrayList<String> trans = history.get(0);
             ArrayList<String> trans_amount = history.get(1);
             ArrayList<String> trans_balance = history.get(2);
             ArrayList<String> trans_time = history.get(3);

             System.out.println();
             System.out.format("%10s%15s%15s%28s\n","Transaction","Amount","Balance","Transaction Time");
             System.out.println();
             for(int i=0;i<trans.size();i++)
             {
               System.out.format("%10s%15s%15s%30s\n",trans.get(i),trans_amount.get(i),trans_balance.get(i),trans_time.get(i));
               //System.out.println(trans.get(i)+" "+trans_amount.get(i)+" "+trans_balance.get(i)+" "+trans_time.get(i));
             }
             System.out.println();
           }
      	   else
      	   {
      	      System.out.println("Wrong command entered");
      	   }
         }
      } catch (Exception e) {
         System.err.println("Client exception: " + e.toString());
         e.printStackTrace();
      }
   }
}
