package forum.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="thread")
public class Thread {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="title")
	private String title;
	
	@Column(name="content")
	private String content;
	
	
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE,
							CascadeType.DETACH, CascadeType.REFRESH })
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
	
	/*
	 * Not sure yet if I should remove this
	 * 
	public void setTitle(String title) {
		this.title = title;
	}
	*/
	public String getContent() {
		return content;
	}
	
	
	/*
	 * Not sure yet if I should remove this
	 * 
	public void setContent(String content) {
		this.content = content;
	}
	*/
	
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
