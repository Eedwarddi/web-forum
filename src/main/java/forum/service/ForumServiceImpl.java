package forum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import forum.dao.CategoryDAO;
import forum.entity.Category;

@Service
public class ForumServiceImpl implements ForumService {
	
	@Autowired
	private CategoryDAO categoryDAO;

	@Override
	public List<Category> getCategories() {
		
		return categoryDAO.getCategories();
	}

	@Override
	public void saveCategory(Category theCategory) {
		// TODO Auto-generated method stub

	}

	@Override
	public Category getCategory(int theId) {
		
		return categoryDAO.getCategory(theId);
	}

	@Override
	public void deleteCategory(int theId) {
		// TODO Auto-generated method stub

	}

}
