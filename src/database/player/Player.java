package database.player;
import database.bid.*;
import java.util.ArrayList;

public class Player {

  private String name;
  private int id;
  private int idTeam;
  private int idOriginalTeam;
  private float currentValue;
  private boolean onSale;
  private ArrayList<Bid> bids;

  public Player(String name, int id, int idTeam, float currentValue, boolean onSale) {
    this.name = name;
    this.id = id;
    this.idTeam = idTeam;
    this.idOriginalTeam = idTeam;
    this.currentValue = currentValue;
    this.onSale = onSale;
    this.bids = new ArrayList<Bid>();
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getIdTeam() {
    return this.idTeam;
  }

  public void setIdTeam(int idTeam) {
    this.idTeam = idTeam;
  }

  public float getCurrentValue() {
    return this.currentValue;
  }

  public void setCurrentValue(float currentValue) {
    this.currentValue = currentValue;
  }

  public boolean getOnSale() {
    return this.onSale;
  }

  public void setOnSale(boolean onSale) {
    this.onSale = onSale;
  }

  public ArrayList<Bid> getBids() {
    return this.bids;
  }

  public void setBids(ArrayList<Bid> bids) {
    this.bids = bids;
  }

  public int getIdOriginalTeam() {
	return idOriginalTeam;
  }
  
  public void setIdOriginalTeam(int idOriginalTeam) {
		this.idOriginalTeam = idOriginalTeam;
  }

}
