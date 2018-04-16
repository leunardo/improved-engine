package application;

import model.Person;
import repository.PersonRepository;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method 
		Person p1 = new Person();
		
		p1.setName("FON TRAB");
		PersonRepository pr = new PersonRepository();
		pr.saveEntity(p1);
	}

}
