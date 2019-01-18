package forum.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import forum.entity.Category;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

	// This is hard coded right now ... add database later

	private List<Category> categories = new ArrayList<>();

	@Override
	public List<Category> getCategories() {

		categories.add(new Category(1, "Movies"));
		categories.add(new Category(2, "Music"));
		categories.add(new Category(3, "Video Games"));

		return categories;
	}

	@Override
	public void saveCategory(Category theCategory) {
		// TODO Auto-generated method stub

	}

	@Override
	public Category getCategory(int theId) {
		
		for(Category c : categories) {
			if(c.getId() == theId) {
				return c;
			}
		}
		
		return null;
	}

	@Override
	public void deleteCategory(int theId) {
		// TODO Auto-generated method stub

	}

}
