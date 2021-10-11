package database;

public class Offer {
  private String name;

  private int id;
  private int idTeam;
  private float currentValue;
  private boolean on_sale;
  private List<Offer> offers;
  private List<Team> off;

  public int getId(){
    return this.id;
  }

  public void setId(int id){
    this.id = id;
  }

  public int getIdTeam(){
    return this.idTeam;
  }

  public void setIdTeam(int idTeam){
    this.idTeam = idTeam;
  }

  public float getCurrentValue(){
    return this.currentValue;
  }

  public void setCurrentValue(float currentValue){
    this.currentValue = currentValue;
  }


}