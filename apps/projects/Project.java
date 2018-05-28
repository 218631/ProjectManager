package apps.projects;

import apps.people.Member;
import java.util.*;

public class Project extends Base
{
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