package apps.projects;


import apps.people.Member;

public class Task extends Base
{

  @Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((Task_End == null) ? 0 : Task_End.hashCode());
		result = prime * result + ((executor == null) ? 0 : executor.hashCode());
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
		Task other = (Task) obj;
		if (Task_End == null) {
			if (other.Task_End != null)
				return false;
		} else if (!Task_End.equals(other.Task_End))
			return false;
		if (executor == null) {
			if (other.executor != null)
				return false;
		} else if (!executor.equals(other.executor))
			return false;
		return true;
	}

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