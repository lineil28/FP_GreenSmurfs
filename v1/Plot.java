public class Plot{
  boolean flag;
  boolean bomb;
  boolean explored;
  int surrBomb;
  boolean available;
  public Plot(){
    flag = false;
    bomb = false;
    explored = false;
    surrBomb = 0;
    available = true;
  }
  public boolean hasBomb(){
    return bomb;
  }
  public boolean getExplored(){
    return explored;
  }
  public boolean hasFlag(){
    return flag;
  }
  public int bombCount(){
    return surrBomb;
  }

  public boolean isAvailable(){
    return available;
  }

  public void setBomb(){
    bomb = true;
  }

  public void setExplored(){
    explored = true;
  }

  public void setFlag(){
    flag = true;
  }

  public void addBomb(){
    surrBomb += 1;
  }
  public void setUnavailable(){
    available = false;
  }
}
