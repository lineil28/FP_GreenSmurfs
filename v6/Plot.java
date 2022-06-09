public class Plot{
  boolean flag;
  boolean bomb;
  boolean explored;
  int surrBomb;
  boolean available;
  boolean buffer;
  boolean starter;
  int bufferVal;
  public Plot(){
    flag = false;
    bomb = false;
    explored = false;
    surrBomb = 0;
    available = true;
    buffer = false;
    starter = false;
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

  public boolean getStarter(){
    return starter;
  }

  public void setStarter(){
    starter = true;
  }

  public boolean isBuffer(){
    return buffer;
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

  public void unsetFlag(){
    flag = false;
  }

  public void addBomb(){
    surrBomb += 1;
  }
  public void setUnavailable(){
    available = false;
  }
  public void setBuffer(){
    buffer = true;
  }
  public void setBuffVal(int coord){
    bufferVal = coord;
  }
  public int getBuffVal(){
    return bufferVal;
  }
}
