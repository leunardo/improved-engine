package repository;

import model.Person;

public class PersonRepository extends AbstractDatabase<Person> {
	
	public PersonRepository() {
		super(Person.class);
		// TODO Auto-generated constructor stub
	}

	public Person getPerson(long id) {
		return this.getEntity(id);
	}
	
	public void savePerson(Person p){
		this.saveEntity(p);
	}
	
	public void deletePerson (Person p) {
		this.deleteEntity(p);
	}
}
