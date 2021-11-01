package business.account_operations;
import database.user.*;
import database.user.admin.Admin;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import database.*;

public class AccountOperations {

    public static final int MIN_SIZE = 8;

    public static boolean checkPassword(String password){    	
    	Pattern p1 = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
    	Matcher m1 = p1.matcher(password);
    	boolean b1 = m1.find();
    	
    	Pattern p2 = Pattern.compile("[A-Z]", Pattern.UNICODE_CASE);
    	Matcher m2 = p2.matcher(password);
    	boolean b2 = m2.find();
    	
    	
        if(b1 && b2 && password.length() >= MIN_SIZE){
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
    	List<Admin> admins = Data.getAdmins();
    	for(Admin admin: admins) {
    		if (admin.getName().equalsIgnoreCase(name)) {
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
