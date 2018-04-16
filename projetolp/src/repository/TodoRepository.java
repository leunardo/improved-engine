package repository;

import model.Todo;

public class TodoRepository extends AbstractDatabase<Todo> {

	public TodoRepository() {
		super(Todo.class);
		// TODO Auto-generated constructor stub
	}
	
	public void saveTodo (Todo t) {
		this.saveEntity(t);
	}
	
	public Todo getTodo (long id) {
		return this.getEntity(id);
	}
	
	public void deleteTodo(Todo t) {
		this.deleteEntity(t);
	}
	

}
