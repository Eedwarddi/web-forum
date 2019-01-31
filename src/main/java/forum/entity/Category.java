package forum.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "title")
	private String title;

	@OneToMany(mappedBy = "category")
	private List<Thread> threads;

	public Category() {

	}

	public Category(int id, String title) {
		this.id = id;
		this.title = title;
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

	@Override
	public String toString() {
		return "Category [id=" + id + ", title=" + title + "]";
	}

	public void add(Thread tempThread) {

		if (threads == null) {
			threads = new ArrayList<>();
		}

		threads.add(tempThread);

		tempThread.setCategory(this);
	}

}
