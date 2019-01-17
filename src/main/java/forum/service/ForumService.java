package forum.service;

import java.util.List;

import forum.entity.Category;

public interface ForumService {
	
	public List<Category> getCategories();

	public void saveCategory(Category theCategory);

	public Category getCategory(int theId);

	public void deleteCategory(int theId);

}
