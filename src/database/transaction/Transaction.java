package database.transaction;
import database.player.*;
import database.user.team.*;

public class Transaction {
    private Player player;
    private Team sourceTeam;
    private Team destinationTeam;
    private String type;
    private float price;

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
    public void setDestination(Team destinationTeam) {
        this.destinationTeam = destinationTeam;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
}
