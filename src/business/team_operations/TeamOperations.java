package business.team_operations;
import database.player.*;
import database.user.team.*;
import database.Data;
import database.bid.Bid;

import java.util.*;
import database.transaction.*;

public class TeamOperations {

    public static void main(String[] args) {

        System.out.println(getBorrowedPlayers("Central"));
        System.out.println(getPlayersNotOnList("Central"));

    }


    // Retorna os jogadores de um time que pertencem a outro time
    public static ArrayList<Player> getBorrowedPlayers(String teamName){
        
        ArrayList<Player> borrowedPlayers = new ArrayList<Player>();
        Team team = Data.getTeamByName(teamName);
        for (Player player : team.getPlayers().values()){
            if (player.getIdOriginalTeam() != team.getIdUser()){
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
        Data.getTeamById(player.getIdOriginalTeam()).addPlayer(player);;
    }

    // Retorna os jogadores de um time que não estão na lista de transferencias
    public static ArrayList<Player> getPlayersNotOnList(String teamName){

        ArrayList<Player> playersNotOnList = new ArrayList<Player>();

        Team team = Data.getTeamByName(teamName);

        for (Player player : team.getPlayers().values()){
            if (!player.getOnSale() && player.getIdOriginalTeam() == team.getIdUser()){
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
        player.getBids().add(new Bid(null, value));
    }
    
    public static boolean playerBelongstoTeam(String teamName, String playerName) {
    	return Data.getTeamById(Data.getPlayerByName(playerName).getIdOriginalTeam()).getName().equals(teamName);
    }

    // Verifica se um jogador com um determinado nome já existe
    public static boolean playerExists(String teamName, String playerName){
    	return Data.getPlayerByName(playerName) != null;
    }

    // Adiciona um jogador em um time
    public static void addPlayer(String teamName, String playerName){
        Team team = Data.getTeamByName(teamName);
        Player player = new Player(playerName, Data.getPlayers().size() + 1, team.getIdUser(), 0, false);
        Data.getHashPlayers().put(Data.getPlayers().size() + 1, player);
        team.addPlayer(player);
    }

    // Verifica se um jogador aceita ser emprestado
    public static boolean playerAcceptsLoan(String playerName){
        return true;
    }


    // Cancela todos bids de um time em um jogador
    public static void cancelBids(String teamName, String playerName){
        Player player = Data.getPlayerByName(playerName);
        
        ArrayList<Bid> foundBids = new ArrayList<Bid>();
        for(Bid bid : player.getBids()){
            if(bid.getBiddingTeam() != null && bid.getBiddingTeam().getName().equals(teamName)){
                foundBids.add(bid); 
            }
        }
        player.getBids().removeAll(foundBids);
        player.setCurrentValue(player.getBids().get(player.getBids().size() - 1).getBiddingValue());
    }

    // Retorna o nome do time que deu o ultimo bid (bid mais alto) ao player.
    public static String getLastBidTeam(String playerName){
        Player player = Data.getPlayerByName(playerName);

        return player.getBids().get(player.getBids().size()-1).getBiddingTeam().getName();
    }
    
    // Novo bid  de um time em um jogador com um valor
    public static void newBid(String teamName, String playerName, float newValue){
        Player player = Data.getPlayerByName(playerName);
        Team team = Data.getTeamByName(teamName);

        Bid bid = new Bid(team, newValue);

        player.getBids().add(bid);
        player.setCurrentValue(newValue);
    }

    // Encerra o leilão do player, realizando a transferencia.
    public static void endAuction(String playerName){
        Player player = Data.getPlayerByName(playerName);

        String biddingTeamName = getLastBidTeam(player.getName());
        Team biddingTeam = Data.getTeamByName(biddingTeamName);
        Team oldTeam = Data.getTeamById(player.getIdOriginalTeam());
        Transaction transaction = new Transaction(player, oldTeam, biddingTeam, TransactionType.COMPRA, player.getCurrentValue());
        biddingTeam.addPlayer(player);
        oldTeam.removePlayer(player);
        Data.getHashTransactions().put(Data.getTransactions().size()+1, transaction);
        
        
        player.setIdOriginalTeam(biddingTeam.getIdUser());
        player.setIdTeam(biddingTeam.getIdUser());
        player.setCurrentValue(0);
        player.setOnSale(false);
        player.getBids().clear();

    }
    
    // Efetiva o emprestimo de um jogador para um time
    public static void loanPlayer(String teamName, String playerName){
        
        Player player = Data.getPlayerByName(playerName);
        Team sourceTeam = Data.getTeamById(player.getIdOriginalTeam());
        Team destinationTeam = Data.getTeamByName(teamName);
        Transaction transaction = new Transaction(player, sourceTeam, destinationTeam, TransactionType.EMPRESTIMO, 0);
        
        destinationTeam.addPlayer(player);
        sourceTeam.removePlayer(player);
        
        player.setIdOriginalTeam(sourceTeam.getIdUser());
        player.setIdTeam(destinationTeam.getIdUser());
        player.setCurrentValue(0);
        player.setOnSale(false);
        player.getBids().clear();
        
        Data.getHashTransactions().put(Data.getTransactions().size()+1, transaction);
    
    }


	public static boolean playerOnSale(String playerName) {
		return Data.getPlayerByName(playerName).getOnSale();
	}

}
