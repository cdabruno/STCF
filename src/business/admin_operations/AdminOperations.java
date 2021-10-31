package business.admin_operations;
import database.transaction.*;
import java.util.Map;
import database.Data;

public class AdminOperations{
    
    public static String getPlayerTransactionInformationCSV(Transaction transaction){
        
        return transaction.getPlayer().getName() + "," + 
                transaction.getSourceTeam().getName() + "," + 
                transaction.getDestinationTeam().getName() + "," + 
                transaction.getType() + "," + 
                transaction.getPrice();

    }

    public static Map<Integer, Transaction> getPlayerTransactionInformationList() {
        return Data.getTransactions();
    }
}
