package database.transaction;
import database.player.*;
import database.user.team.*;

public class Transaction {
    private Player player;
    private Team sourceTeam;
    private Team destinationTeam;
    private TransactionType type;
    private float price;
    
    public Transaction(Player player, Team sourceTeam, Team destinationTeam, TransactionType type, float price) {
		super();
		this.player = player;
		this.sourceTeam = sourceTeam;
		this.destinationTeam = destinationTeam;
		this.type = type;
		this.price = price;
	}

    public Player getPlayer() {
        return player;
    }
	public void setPlayer(Player player) {
        this.player = player;
    }
    public Team getSourceTeam() {
        return sourceTeam;
    }
    public void setSourceTeam(Team sourceTeam) {
        this.sourceTeam = sourceTeam;
    }
    public Team getDestinationTeam() {
        return destinationTeam;
    }
    public void setDestinationTeam(Team destinationTeam) {
        this.destinationTeam = destinationTeam;
    }
    public TransactionType getType() {
        return type;
    }
    public void setType(TransactionType type) {
        this.type = type;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
}
