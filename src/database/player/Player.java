package database.player;

public class Player {

  private String name;
  private int id;
  private int idTeam;
  private float currentValue;
  private boolean onSale;

  public Player(String name, int id, int idTeam, float currentValue, boolean onSale) {
    this.name = name;
    this.id = id;
    this.idTeam = idTeam;
    this.currentValue = currentValue;
    this.onSale = onSale;
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

}
