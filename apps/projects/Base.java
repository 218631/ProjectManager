package apps.projects;

abstract class Base
{
  private String title;
  private static int nextId=1;
  private int id;
  
  public Base(String t)
  {
    setTitle(t);
    id = nextId++;
  }

  public String getTitle()
  {
    return title;
  }

  public int getId() {
	 return id;
  }
  
public void setTitle(String title) {
	this.title = title;
}
}

