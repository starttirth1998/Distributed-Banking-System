
*Compile*
javac Server_201501051.java
javac Client_201501051.java
javac Interface_201501051.java
javac ImplExample.java

*Run*
java Server_201501051
java Client_201501051

*Functions*
-> All the required methods are implemented.
-> Client has a command prompt which invokes the method in server

deposit [acc_no] [ammount]: deposits amount in the acc_no
withdraw [acc_no] [ammount]: withdraws amount in the acc_no
balance [acc_no]: returns balance in acc_no
history [acc_no] all: return all transactions of acc_no
history [acc_no] [start_date] [end_date]: returns all transactions of account from start date to end date

-> Table is printed in tabular format
-> HashMap is used to store the information about acc_no for faster retrieval
-> Error handling is done properly

*Bonus*
-> Each client's mobile will start a RMI server on it's own and then bind with the server.
-> We will store the port/ip and contact info of the client.
-> We will have function notification in the Interface.
-> Now as transaction occurs server will call the function notification.
-> Now server will act as client for the RMI server of mobile for the account and call the notification function from interface with the details of transaction.
-> In this function notification the RMI server which is actually client's mobile can print the message notifying the user of transaction.
