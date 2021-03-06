package apps.projects;

import apps.people.Member;
import java.util.*;

public class Project extends Base
{
  @Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((members == null) ? 0 : members.hashCode());
		result = prime * result + ((tasks == null) ? 0 : tasks.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		if (members == null) {
			if (other.members != null)
				return false;
		} else if (!members.equals(other.members))
			return false;
		if (tasks == null) {
			if (other.tasks != null)
				return false;
		} else if (!tasks.equals(other.tasks))
			return false;
		return true;
	}

private ArrayList<Task> tasks;
  private ArrayList<Member> members;


  public Project(String t)
  {
    super(t);
    tasks = new ArrayList<>();
    members = new ArrayList<>();
  }

  public void addTask(Task t)
  {
    tasks.add(t);
  }

  public void removeTask(int index) {
	  tasks.remove(index);
  }
  
  public void addMember(Member m)
  {
    members.add(m);
  }

  public void removeMember(int index)
  {
	  members.remove(index);
  }
  
  public String toString()
  {
    String out = "Project title: " + getTitle();
    return out;
  }


public void mod(int index, String t) {
	tasks.get(index).mod(t);
}
public void mod(int index, String t, Member m) {
	tasks.get(index).mod(t,m);
}

public void PrintM() {
	for(Member per : members)
	{
		per.Print();
	}	
}
public ArrayList<Member> getM(){
	return members;
}
public ArrayList<Task> getT(){
	return tasks;
}

public void Print() {
	System.out.println(this.toString());
}
}