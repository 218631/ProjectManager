package apps.projects;


import apps.people.Member;

public class Task extends Base
{

  private Member executor;
  private String Task_End;
  
  public Task(String t)
  {
    super(t);
  }

  public Task(String t, Member e)
  {
    super(t);
    executor = e;
  }

  public void assigTo(Member to)
  {
    executor = to;
  }

  public Member getExecutor()
  {
    return executor;
  }


public void mod(String t,Member to) {
	setTitle(t);	
	this.assigTo(to);
}

public void mod(String t) {
	setTitle(t);	
}

public String toString()
{
  return getTitle() +", ID: "+ getId() + ", wykonawca: " + getExecutor();
}

public void Print() {
	System.out.println(this.toString());
}

}