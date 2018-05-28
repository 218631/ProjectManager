package apps.people;

public class Member
{
  private String firstName;
  private String lastName;
  private String email;

  public Member(String fn, String ln, String e)
  {
    firstName = fn;
    lastName = ln;
    email = e;
  }
  public Member(String fn, String ln)
  {
    firstName = fn;
    lastName = ln;
    email = null;
  }
  public void mod(String fn,String ln, String e)
  {
	   firstName = fn;
	   lastName = ln;
	   email = e;
  }

  public void mod(String fn,String ln)
  {
	   firstName = fn;
	   lastName = ln;
  }

  
public void Print() {
	System.out.println(this.toString());
	
}
  public String toString()
  {
    return firstName + " " + lastName + " (" + email + ")";
  }
}
