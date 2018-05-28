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

  @Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + id;
	result = prime * result + ((title == null) ? 0 : title.hashCode());
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
	Base other = (Base) obj;
	if (id != other.id)
		return false;
	if (title == null) {
		if (other.title != null)
			return false;
	} else if (!title.equals(other.title))
		return false;
	return true;
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

