package business.team_operations;
import database.player.*;
import database.user.team.*;
import database.Data;
import java.util.*;
import database.transaction.*;

public class TeamOperations {

    public static void main(String[] args) {

        System.out.println(getBorrowedPlayers("Central"));

    }


    // Retorna os jogadores de um time que pertencem a outro time
    public static ArrayList<Player> getBorrowedPlayers(String teamName){
        
        ArrayList<Player> borrowedPlayers = new ArrayList<Player>();
        Team team = Data.getTeamByName(teamName);
        for (Player player : team.getPlayers().values()){
            if (player.getIdTeam() != team.getIdUser()){
                borrowedPlayers.add(player);
            }
        }
        return borrowedPlayers;
    }

    // Devolve um jogador emprestado para seu time de origem.
    // teamName é o TIME ATUAL DO JOGADOR
    public static void returnPlayer(String teamName, String playerName){
        
        Team team = Data.getTeamByName(teamName);
        Player player = Data.getPlayerByName(playerName);
        team.removePlayer(player);
        Data.getTeamById(player.getIdTeam()).addPlayer(player);;
    }

    // Retorna os jogadores de um time que não estão na lista de transferencias
    public static ArrayList<Player> getPlayersNotOnList(String teamName){

        ArrayList<Player> playersNotOnList = new ArrayList<Player>();

        Team team = Data.getTeamByName(teamName);

        for (Player player : team.getPlayers().values()){
            if (player.getOnSale()){
                playersNotOnList.add(player);
            }
        }
        return playersNotOnList;
    }

    // Adiciona um jogador de um time na lista de transferencias com um determinado valor
    public static void putOnList(String teamName, String playerName, float value){

        Player player = Data.getPlayerByName(playerName);
        player.setOnSale(true);
        player.setCurrentValue(value);

    }

    // Verifica se um jogador já existe no time com um determinado nome
    public static boolean playerExists(String teamName, String playerName){
        Team team = Data.getTeamByName(teamName);
        
        for (Player player : team.getPlayers().values()){
            if (player.getName().equals(playerName)){
                return true;
            }
        }
        return false;
    }

    // Adiciona um jogador em um time
    public static void addPlayer(String teamName, String playerName){
        Team team = Data.getTeamByName(teamName);
        Player player = Data.getPlayerByName(playerName);
        team.addPlayer(player);
    }

    // Verifica se um jogador aceita ser emprestado
    public static boolean playerAcceptsLoan(String playerName){
        return true; // ????????????????????????? insoluvel
    }

    // Efetiva o emprestimo de um jogador para um time
    public static void loanPlayer(String teamName, String playerName, float price){
        
        Player player = Data.getPlayerByName(playerName);
        Team sourceTeam = Data.getTeamById(player.getIdTeam());
        Team destinationTeam = Data.getTeamByName(teamName);
        Transaction transaction = new Transaction(player, sourceTeam, destinationTeam, TransactionType.EMPRESTIMO, price);
        
        destinationTeam.addPlayer(player);
        sourceTeam.removePlayer(player);
        
        Data.getTransactions().put(Data.getTransactions().size()+1, transaction);
    
    }

}
