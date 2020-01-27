package fmi.informatics.extending;

import java.util.ArrayList;
import java.util.Calendar;


import fmi.informatics.composition.RichStudent;

public class TestPerson {
	
	  public static void main(String[] args) {
		  // Не можем да създаваме обекти от абстрактен клас
		  // Person p = new Person();
		  // p.walk();
		  // System.out.println("Person name: " + p.getName() + "\n");

		  Student s = new Student("Pesho", 838383, "PU", "Informatics", 12365);
		  s.run();
		  s.goBar();
		  // s.goBar("Rakia");
		  Calendar cal = Calendar.getInstance();
		  cal.set(2019, 1, 1, 8, 0, 0);
		  s.getUpEarly(cal);
		  System.out.println("Student name: " + s.getName());
		  System.out.println("Student EGN: " + s.getEgn());
		  System.out.println("Overrided toString method: " + s.toString());
		  System.out.println();
		  
		  Professor prof = new Professor();
		  prof.setTitle("Assistant");
		  prof.walk();
		  prof.goBar();
		  System.out.println(prof.toString());
		  System.out.println();
		  
		  printPerson();
		  
		  ArrayList<Person> people = new ArrayList<Person>();
		  for(int i=0; i<10; i++) {
			  people.add(Student.StudentGenerator.make());
		  }
		  
		  showStats(people);
		  
	  }
	  
	  public void iDontKnowWhatImDoing() {
		  
		  try {
			  
			  Class c = Class.forName("TestPerson");
			  System.out.println("Class = " + c.getName());
			  
		  }catch(ClassNotFoundException ex) {
			  
			  System.out.println(ex.toString());
			  
		  }
		  
		  
		  
/*		  try {
			  
			  Student s;
			  Class cl = s.getClass();
			  Object obj = cl.newInstance();
			  System.out.println(obj);
			  
		  }catch(InstantiationException e){
			  
			  System.out.println(e.toString());
			  
		  }catch(IllegalAccessException e) {
			  
			  System.out.println(e.toString());
			  
		  }
		  
	  }*/
	
	  public static void showStats(ArrayList<Person> people) {
		  int pb=0,sb=0,srb=0,all=0;
		  for(Person p : people) {
			  System.out.println(p);
			  if(p.getClass().isAssignableFrom(Professor.class)){
				  pb++;all++;
			  }else if((p.getClass().isAssignableFrom(Student.class))) {
				  p.study();
				  sb++;all++;
			  }else if((p.getClass().isAssignableFrom(RichStudent.class))) {
				  p.study();
				  sb++;all++;
				  srb++;
			  }
		  }
		  System.out.println("There are " + all + "people. " + pb + " professors, " + sb + " students and " + srb + " are rich!");
	  }
	  
	  
	  public static void printPerson() {	
		  ArrayList<Person> persons = new ArrayList<>();
		
		  for (int i = 0; i <= 10; i++) {
			if (i % 2 == 0) {
				persons.add(new Student());
			} else {
				persons.add(new Professor());
			}
		}

		
		System.out.println("Show all elements from the list:");
		for (Person p : persons) {
			System.out.println(p.toString());
		}
	}
}
