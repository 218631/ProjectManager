import apps.projects.Task;
import apps.people.Member;
import apps.projects.Project;
import java.io.BufferedReader;
import java.util.*;




class ProjectManger
{
    public static void main(String[] args)
    {
      ArrayList<Project> prjcts = new ArrayList<>();
      ArrayList<Member> persons = new ArrayList<>();
      ArrayList<Task> Tasks= new ArrayList<>();
      
      prjcts.add(new Project("PL-Grid"));
      prjcts.add(new Project("SpinLab")); 
      
      try(Scanner ins = new Scanner(System.in)){
     
      String operation=null;
      String target=null;
      String temp1[]=null;	//wczytywana komenda
      
      while(true)
      {
    	  String temp = ins.nextLine();
    	  if(temp=="end")
    	  {
    		  operation = "end";
    	  }
    	  
    	  if(temp!="end" && !temp.isEmpty() ) {
    	  temp1=temp.split(" ");	//dzielimy komende na czesci
    	  operation = temp1[0];		//podstawowa operacja
    	  target = temp1[1];		//cel operacji osoba/zadanie/projekt
    	  }

    	  switch(operation){
    	  case "add":
    		  switch(target){
    		  case "person":    			  
    			  Member Memb=null;
    			  String temp2[] = null;
    			  if(temp1[2].contains(":"))
    			  {
    				  temp2=temp1[2].split(":");
    			  }
    			  
	    		 if(temp1.length==4) // tylko imie i nazwisko
	    		 	{
	  					Memb = new Member(temp1[2],temp1[3]);
	  					 persons.add(Memb);
	  				}
	    		 if( temp1.length==5 && temp2!=null)
					{
						Memb = new Member(temp1[3],temp1[4]); 
						 persons.add(Memb); 
						  if(temp.contains("project")) {
		    				  prjcts.get((Integer.parseInt(temp2[1]))).addMember(Memb);}
		    			  if(temp.contains("task")) {
		    				  Tasks.get(Integer.parseInt(temp2[1])).assigTo(Memb);}
					}
	  			  if(temp1.length==5 && temp2==null) //dodatkowo email
	  				{   					
	  					Memb = new Member(temp1[2],temp1[3],temp1[4]);
	  					 persons.add(Memb); 
	  				}
	  			 if(temp1.length==6 && temp2!=null) //dodatkowo email
					{   					
						Memb = new Member(temp1[3],temp1[4],temp1[5]);
						persons.add(Memb); 
						if(temp.contains("project")) {
		    				  prjcts.get((Integer.parseInt(temp2[1]))).addMember(Memb);}
		    			  if(temp.contains("task")) {
		    				  Tasks.get(Integer.parseInt(temp2[1])).assigTo(Memb);}
					}
	  			
	    		
    			
	    		
    			  break;
    		  case "task":
    			  if(temp1.length == 4)
    			  {
    				  String temp3[]=temp1[3].split(":"); // robimy tablice obiekt - index
    				  Task NewTask= new Task(temp1[2]);
    				  prjcts.get((Integer.parseInt(temp3[1]))).addTask(NewTask);
    				  Tasks.add(NewTask);
    			  }
    			  else {
    				  System.out.println("Zadanie musi nalezec do projektu");
    			  }
    			  break;
    		  case "project":
    			 prjcts.add(new Project(temp1[2]));
    			 break;
    		  }
    		  break;
    		  
 //modyfikowanie  		  
    	  case "modify":
    		  String temp2[]=temp1[1].split(":");
    		  target=temp2[0];
    		  switch(target){
//osoby    		  
    		  case "person":
    			 
    			  persons.get((Integer.parseInt(temp2[1]))).mod(temp1[2],temp1[3]);
    			  if(temp1.length>4)
    			  {
    				  persons.get((Integer.parseInt(temp2[1]))).mod(temp1[2],temp1[3],temp1[4]);
    			  }
    			  break;
    		  case "task":
    			 //zmiana nazwy
    			 prjcts.get((Integer.parseInt(temp2[1]))).mod((Integer.parseInt(temp2[1])),temp1[2]);
    			 //zmiana nazwy i wykonawcy
     			  if(temp1.length>4)
     			  {
     				  persons.get((Integer.parseInt(temp2[1]))).mod(temp1[2],temp1[3],temp1[4]);
     			  }
    			  break;
    		  case "project":
 //   			  
    			  break;
    		  }
    		  break;
//usuwanie    		  
    	  case "delete":
    		  String temp22[]=temp1[1].split(":");
    		  target=temp22[0];
    		  switch(target){
//osoby    		   
    		  case "person":
    			 
    			  persons.remove(Integer.parseInt(temp22[1]));
    			  
    			  break;
//zadania    	
    		  case "task":
    			  String temp3[]=temp1[1].split(":"); //projekt
    			  //z projektu
    			  prjcts.get((Integer.parseInt(temp3[1]))).removeTask(Integer.parseInt(temp22[1]));
    			  //z listy zadan
    			  if(temp1.length==2) {
    			  Tasks.remove(Integer.parseInt(temp22[1]));
    			  }
    			  break;
//projektu    			  
    		  case "project":
    			  prjcts.remove(Integer.parseInt(temp22[1]));
    			  break;
    		  }
    		  break;
// wypisywanie
    	  case "list":
    		  if(temp1[1].contains(":")) {
    			  String temp4[]=temp1[1].split(":");
    			target=temp4[0];  
    		  }
    		  switch(target){
//osoby    		  
    		  case "person":
    			  if(temp1.length>2) {
    				  if(temp1[2].contains(":")) {
    					  String temp3[]=temp1[2].split(":");
     					  if(Integer.parseInt(temp3[1])>prjcts.size()-1)
    					  {
    						  System.out.println("Nie ma projektu o tak duzym indeksie");
    					  }
    					  else {
    						  ArrayList<Member> per_in_pro = prjcts.get((Integer.parseInt(temp3[1]))).getM();
    						  for(Member person : per_in_pro )
    						  {
    							  person.Print();
    						  }
    					  }
    				  }
    			  }
    			  else {
    				  for(Member person : persons)
    	    			 {
    	    				 person.Print();
    	    			 }		 
    			}
    			  break;
//zadania    			  
    		  case "task":
    			  
    			  if(!temp1[2].contains(":")) {
    				  for(Task _task : Tasks)
    				  {
    					  _task.Print();
    				  }
    			  }
    			  else {
    				  String temp3[]=temp1[2].split(":");
    				  for(Task _task : prjcts.get((Integer.parseInt(temp3[1]))).getT())
    				  {
    					  _task.Print();
    				  }
    			  }
    			  break;
 //projekty   			  
    		  case "project":
    			  for(Project pro :prjcts)
    			  {
    				  pro.Print();
    			  }
    			  break;
    		  }
    		  break;
    	  case "export":
    		 // new BufferedReader(new FileReader("/import/path/pm.txt"));
    		  switch(target) {
    		  case "person":
    			  break;
    		  case "task":
    			  break;
    		  case "project":
    			  break;
    		  }
    	  case "import":
    		  
    		  switch(target) {
    		  case "person":
				/*try {
    				    FileWriter fileW = new FileWriter("/import/path/persons.txt");
    				    for(Member person : persons) {
    				    fileW.write(person);
    				    }
    				} finally {
    				    if (fileW != null) {
    				        fileW.close();
    				    }
    				    
    				}  */
    			  break;
    		  case "task":
    			  break;
    		  case "project":
    			  break;
    		  }
    	  case "end":
    		  break;
    		default:
    		  break;
    	  }	 
      }      
    }
  }
}
