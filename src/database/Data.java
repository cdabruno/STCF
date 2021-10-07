package database;




public class UI {
    public class main{}

    public class SearchUI {
        
    }
}

public class Business {
    public class SearchOperations{
        public List<Player> search(String searchString);
    }
}

public class Database {
    public List<Player> getPlayers();
    public List<User> getUsers();
    public List<Teams> getTeams();
    public List<Transaction> getTransactions();
    public List<Transaction> getBid();


    public class Player {
      public int getId();
      public String getName();
      public int getIdTeam();
      public boolean getOnSale();
      public List<Transaction> getOnSale();
    }

    public class User {
        public int getId();
        public String getName();
    }

    public class Team extends User{
    }

    public class Transfer{
        public int getId();// mesmo id do player
        public float getCurrentValue();
        public boolean get();
    }
}
