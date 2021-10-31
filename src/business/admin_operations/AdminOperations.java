package business.admin_operations;
import database.transaction.*;

import java.util.ArrayList;
import java.util.Map;
import database.Data;

public class AdminOperations{
    
    public static String getPlayerTransactionInformationCSV(Transaction transaction){
        
        return transaction.getPlayer().getName() + "," + 
                transaction.getSourceTeam().getName() + "," + 
                transaction.getDestinationTeam().getName() + "," + 
                transaction.getType().toString() + "," + 
                transaction.getPrice();

    }
    
    public static String getPlayerTransactionsInformationCSV(ArrayList<Transaction> transactions){
    	StringBuilder csv = new StringBuilder();
        for(Transaction transaction: transactions) {
        	csv.append(getPlayerTransactionInformationCSV(transaction));
        	csv.append('\n');
        }
        return csv.toString();
    }


    public static ArrayList<Transaction> getPlayerTransactionInformationList() {
        return Data.getTransactions();
    }
}
