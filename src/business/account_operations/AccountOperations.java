package business.account_operations;
import database.user.*;
import database.user.admin.Admin;
import database.user.team.Team;

import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import database.*;
import database.player.Player;

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
        Team user = new Team(name, userId, password, new HashMap<Integer, Player>());
        Data.getHashUsers().put(user.getIdUser(), user);
        Data.getHashTeams().put(user.getIdUser(), user);
    }

    public static boolean checkIsAdmin(String name){
    	List<Admin> admins = Data.getAdmins();
    	for(Admin admin: admins) {
    		if (admin.getName().equals(name)) {
    			return true;
    		}
    	}
        return false;
    }

    public static boolean checkExistsAccountByUserName(String userName){
        for(User user : Data.getUsers()){
            if(userName.equals(user.getName())){
                return true;
            }
        }
        return false;
    }

    public static boolean checkExistsAccountByUserNameAndPassword(String userName, String password){

        for(User user : Data.getUsers()){
            if(userName.equals(user.getName()) && password.equals(user.getPassword())){
                return true;
            }
        }
        return false;
    }

}
