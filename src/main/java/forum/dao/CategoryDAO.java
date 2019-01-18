package forum.dao;

import java.util.List;

import forum.entity.Category;

public interface CategoryDAO {

	public List<Category> getCategories();

	public Category getCategory(int theId);

}
