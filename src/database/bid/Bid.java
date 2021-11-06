package database.bid;
import database.user.team.*;

public class Bid {
    private Team biddingTeam;
    private float biddingValue;

    public Bid(Team biddingTeam, float biddingValue) {
        this.biddingTeam = biddingTeam;
        this.biddingValue = biddingValue;
    }
    public Team getBiddingTeam() {
        return biddingTeam;
    }
    public void setBiddingTeam(Team biddingTeam) {
        this.biddingTeam = biddingTeam;
    }
    public float getBiddingValue() {
        return biddingValue;
    }
    public void setBiddingValue(float biddingValue) {
        this.biddingValue = biddingValue;
    }

    
}
