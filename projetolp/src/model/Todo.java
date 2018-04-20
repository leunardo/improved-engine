package model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Todo {
	private Long todoId;         // 8
	private String text; 		 // 9
	private boolean completed;   // 10
	private Date created;        // 11
	private Person owner;        // 12
	private List<Task> tasks;	 // 13
	
	@Id
	@GeneratedValue
	public Long getId() {
		return todoId;
	}

	public void setId(Long codigo) {
		this.todoId = codigo;
	}

	public String getText() {
		return text;
	}

	public void setText(String fabricante) {
		this.text = fabricante;
	}
	
	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	@Temporal(TemporalType.DATE)
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@OneToMany(mappedBy="todo")
	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((todoId == null) ? 0 : todoId.hashCode());
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
		final Todo other = (Todo) obj;
		if (todoId == null) {
			if (other.todoId != null)
				return false;
		} else if (!todoId.equals(other.todoId))
			return false;
		return true;
	}

	@ManyToOne
	@JoinColumn(name="personId")
	public Person getOwner() {
		return owner;
	}

	public void setOwner(Person owner) {
		this.owner = owner;
	}

}