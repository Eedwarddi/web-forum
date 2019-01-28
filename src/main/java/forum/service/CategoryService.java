package forum.service;

import java.util.List;

import forum.entity.Category;

public interface CategoryService {

	public List<Category> getCategories();

	public Category getCategory(int theId);

}
