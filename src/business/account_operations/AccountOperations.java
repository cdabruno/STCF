package business.account_operations;
import database.user.*;
import database.user.admin.Admin;

import java.util.List;

import database.*;

public class AccountOperations {

    public static final int MIN_SIZE = 8;

    public static boolean checkPassword(String password){
        if(password.matches("[A-Z]") && password.matches("[^A-Za-z0-9 ]") && password.length() >= MIN_SIZE){
            return true;
        } else {
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

    public static boolean checkIsAdmin(String name){
    	List<User> users = Data.getUsers();
    	for(User user: users) {
    		if (user.getName().equalsIgnoreCase(name)) {
    			return true;
    		}
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
