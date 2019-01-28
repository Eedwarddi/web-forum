package forum.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="thread")
public class Thread {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotNull(message="Title is required!")
	@Column(name="title")
	private String title;
	
	@NotNull(message="Content is required!")
	@Column(name="content")
	private String content;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
	
	public Thread() {
		
	}

	public Thread(int id, String title, String content) {
		this.id = id;
		this.title = title;
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}
	
	public String getContent() {
		return content;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	

	@Override
	public String toString() {
		return "Thread [id=" + id + ", title=" + title + ", category=" + category + "]";
	}
	
}
