package database.bid;
import database.user.team.*;

public class Bid {
    private Team biddingTeam;
	private float biddingValue;
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((biddingTeam == null) ? 0 : biddingTeam.hashCode());
		result = prime * result + Float.floatToIntBits(biddingValue);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bid other = (Bid) obj;
		if (biddingTeam == null) {
			if (other.biddingTeam != null)
				return false;
		} else if (!biddingTeam.equals(other.biddingTeam))
			return false;
		if (Float.floatToIntBits(biddingValue) != Float.floatToIntBits(other.biddingValue))
			return false;
		return true;
	}

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
