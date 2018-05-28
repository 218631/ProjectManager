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
  @Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((email == null) ? 0 : email.hashCode());
	result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
	result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
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
	Member other = (Member) obj;
	if (email == null) {
		if (other.email != null)
			return false;
	} else if (!email.equals(other.email))
		return false;
	if (firstName == null) {
		if (other.firstName != null)
			return false;
	} else if (!firstName.equals(other.firstName))
		return false;
	if (lastName == null) {
		if (other.lastName != null)
			return false;
	} else if (!lastName.equals(other.lastName))
		return false;
	return true;
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
