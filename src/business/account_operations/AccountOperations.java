package business.account_operations;
import database.user.*;
import database.user.admin.Admin;
import database.*;

public class AccountOperations {

    public static final int MIN_DIGIT_SIZE = 8;

    public static boolean checkPassword(String password){
        int countDigits = 0;

        if(!password.matches("[A-Z]") || !password.matches("[^A-Za-z0-9 ]")){
            return false;
        }
        
        for (int i = 0; i < password.length(); i++){
            char c = password.charAt(i);        
            if(Character.isDigit(c)){
                countDigits++;
            }
        }

        if(countDigits >= MIN_DIGIT_SIZE){
            return true;
        }else{
            return false;
        }
    }

    public static int generateUserId() {
        return Data.getUsers().size() + 1;
    }

    public static void register(String name, String password) {
        int userId = generateUserId();
        User user = new User(name, userId, password);
        Data.getHashUsers().put(user.getIdUser(), user);
    }

    public static boolean checkIsAdmin(User user){

        if(user instanceof Admin){
            return true;
        }
        return false;
    }

    public static boolean checkExistsAccountByUserName(String userName){

        for(User user : Data.getUsers()){
            if(userName.equalsIgnoreCase(user.getName())){
                return true;
            }
        }
        return false;
    }

    public static boolean checkExistsAccountByUserNameAndPassword(String userName, String password){

        for(User user : Data.getUsers()){
            if(userName.equalsIgnoreCase(user.getName()) && password.equalsIgnoreCase(user.getPassword())){
                return true;
            }
        }
        return false;
    }

}
