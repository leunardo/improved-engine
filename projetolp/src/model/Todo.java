package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Todo {
	private Long todoId;
	private String text;
	private boolean completed;
	private Date created;
	private Person owner;
		
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