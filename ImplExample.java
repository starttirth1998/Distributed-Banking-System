import java.util.*;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;

// Implementing the remote interface
public class ImplExample implements Interface_201501051 {

   // Implementing the interface method
   public HashMap<Integer,String> account_name = new HashMap<Integer,String>();
   public HashMap<Integer,String> account_type = new HashMap<Integer,String>();
   public HashMap<Integer,Double> account_balance = new HashMap<Integer,Double>();
   public HashMap<Integer,String> account_info = new HashMap<Integer,String>();
   public HashMap<Integer,ArrayList<String>> account_transaction = new HashMap<Integer,ArrayList<String>>();
   public HashMap<Integer,ArrayList<Double>> account_transaction_amount = new HashMap<Integer,ArrayList<Double>>();
   public HashMap<Integer,ArrayList<Double>> account_transaction_balance = new HashMap<Integer,ArrayList<Double>>();
   public HashMap<Integer,ArrayList<String>> account_transaction_time = new HashMap<Integer,ArrayList<String>>();

   public String get_name(int account_number)
   {
     return account_name.get(account_number);
   }
   public void set_name(int account_number,String name)
   {
     account_name.put(account_number,name);
   }
   public String get_account_type(int account_number)
   {
     return account_type.get(account_number);
   }
   public void set_account_type(int account_number,String type)
   {
     account_type.put(account_number,type);
   }
   public Double get_account_balance(int account_number)
   {
     return account_balance.get(account_number);
   }
   public void set_account_balance(int account_number,Double balance)
   {
     account_balance.put(account_number,balance);
   }
   public void del_account_balance(int account_number)
   {
     account_balance.remove(account_number);
   }
   public String get_account_info(int account_number)
   {
     return account_info.get(account_number);
   }
   public void set_account_info(int account_number,String info)
   {
     account_info.put(account_number,info);
   }
   public ArrayList<String> get_account_transaction(int account_number)
   {
     return account_transaction.get(account_number);
   }
   public ArrayList<Double> get_account_transaction_balance(int account_number)
   {
     return account_transaction_balance.get(account_number);
   }
   public ArrayList<Double> get_account_transaction_amount(int account_number)
   {
     return account_transaction_amount.get(account_number);
   }
   public ArrayList<String> get_account_transaction_time(int account_number)
   {
     return account_transaction_time.get(account_number);
   }
   public void set_account_transaction(int account_number,ArrayList<String> transa)
   {
     account_transaction.put(account_number,transa);
   }
   public void set_account_transaction_balance(int account_number,ArrayList<Double> transa_balance)
   {
     account_transaction_balance.put(account_number,transa_balance);
   }
   public void set_account_transaction_time(int account_number,ArrayList<String> transa_time)
   {
     account_transaction_time.put(account_number,transa_time);
   }
   public void set_account_transaction_amount(int account_number,ArrayList<Double> transa_amount)
   {
     account_transaction_amount.put(account_number,transa_amount);
   }
   public void del_account_transaction(int account_number)
   {
     account_transaction.remove(account_number);
   }
   public void del_account_transaction_balance(int account_number)
   {
     account_transaction_balance.remove(account_number);
   }
   public void del_account_transaction_time(int account_number)
   {
     account_transaction_time.remove(account_number);
   }
   public void del_account_transaction_amount(int account_number)
   {
     account_transaction_amount.remove(account_number);
   }
   public void populate_data()
   {
     String[] name_array = {"Tirth","Maniar"};
     String[] type_array = {"Premium","Basic"};
     int[] account_array = {10,11};
     String[] info_array = {"123456789","987654321"};
     for(int i=0;i<name_array.length;i++)
     {
       set_name(account_array[i],name_array[i]);
       set_account_type(account_array[i],type_array[i]);
       set_account_info(account_array[i],info_array[i]);
       set_account_balance(account_array[i],500.0);
       set_account_transaction(account_array[i],new ArrayList<String>());
       set_account_transaction_amount(account_array[i],new ArrayList<Double>());
       set_account_transaction_balance(account_array[i],new ArrayList<Double>());
       set_account_transaction_time(account_array[i],new ArrayList<String>());
     }
   }
   public void deposit(int account_number, Double amount)
   {
     Double balance = get_account_balance(account_number);
     balance = balance + amount;
     del_account_balance(account_number);
     set_account_balance(account_number,balance);

     ArrayList<String> trans =  get_account_transaction(account_number);
     ArrayList<Double> trans_balance = get_account_transaction_balance(account_number);
     ArrayList<Double> trans_amount = get_account_transaction_amount(account_number);
     ArrayList<String> trans_time= get_account_transaction_time(account_number);
     String time = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
     //System.out.println(trans.size());

     trans.add("deposit");
     trans_balance.add(balance);
     trans_amount.add(amount);
     trans_time.add(time);
     del_account_transaction(account_number);
     del_account_transaction_balance(account_number);
     del_account_transaction_amount(account_number);
     del_account_transaction_time(account_number);
     set_account_transaction(account_number,trans);
     set_account_transaction_balance(account_number,trans_balance);
     set_account_transaction_amount(account_number,trans_amount);
     set_account_transaction_time(account_number,trans_time);
   }
   public void withdraw(int account_number,Double amount)
   {
     Double balance = get_account_balance(account_number);
     balance = balance - amount;
     del_account_balance(account_number);
     set_account_balance(account_number,balance);

     ArrayList<String> trans = get_account_transaction(account_number);
     ArrayList<Double> trans_balance = get_account_transaction_balance(account_number);
     ArrayList<Double> trans_amount = get_account_transaction_amount(account_number);
     ArrayList<String> trans_time = get_account_transaction_time(account_number);
     String time = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());

     trans.add("withdraw");
     trans_balance.add(balance);
     trans_amount.add(-1*amount);
     trans_time.add(time);
     del_account_transaction(account_number);
     del_account_transaction_balance(account_number);
     del_account_transaction_amount(account_number);
     del_account_transaction_time(account_number);
     set_account_transaction(account_number,trans);
     set_account_transaction_balance(account_number,trans_balance);
     set_account_transaction_amount(account_number,trans_amount);
     set_account_transaction_time(account_number,trans_time);
   }
   public ArrayList<ArrayList<String>> transaction_details(int account_number,String start_date,String end_date)
   {
     SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
     Date st_date = new Date();
     Date en_date = new Date();
     Date time = new Date();
     try{
       st_date = formatter.parse(start_date);
       en_date = formatter.parse(end_date);
     }catch(ParseException e){}
     ArrayList<String> trans = get_account_transaction(account_number);
     ArrayList<Double> trans_balance = get_account_transaction_balance(account_number);
     ArrayList<Double> trans_amount = get_account_transaction_amount(account_number);
     ArrayList<String> trans_time = get_account_transaction_time(account_number);

     ArrayList<String> string_trans_balance = new ArrayList<String>();
     ArrayList<String> string_trans_amount = new ArrayList<String>();
     ArrayList<ArrayList<String>> history = new ArrayList<ArrayList<String>>();

     ArrayList<String> final_trans = new ArrayList<String>();
     ArrayList<String> final_trans_balance = new ArrayList<String>();
     ArrayList<String> final_trans_amount = new ArrayList<String>();
     ArrayList<String> final_trans_time = new ArrayList<String>();

     history.clear();
     for(int i=0;i<trans_amount.size();i++)
     {
       string_trans_amount.add(Double.toString(trans_amount.get(i)));
       string_trans_balance.add(Double.toString(trans_balance.get(i)));

       try{
         time = formatter.parse(trans_time.get(i));
       }catch(ParseException e){}

       if(time.after(st_date) && time.before(en_date))
       {
         final_trans.add(trans.get(i));
         final_trans_balance.add(string_trans_balance.get(i));
         final_trans_amount.add(string_trans_amount.get(i));
         final_trans_time.add(trans_time.get(i));
       }
     }
     history.add(final_trans);
     history.add(final_trans_amount);
     history.add(final_trans_balance);
     history.add(final_trans_time);
     //System.out.println(history.size());
     return history;
   }
   public void printMsg(int account_number)
   {
      System.out.println(get_name(account_number));
      System.out.println(get_account_type(account_number));
      System.out.println(get_account_info(account_number));
      System.out.println(get_account_balance(account_number));
   }
}
