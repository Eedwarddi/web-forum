package forum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import forum.dao.CategoryDAO;
import forum.entity.Category;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDAO categoryDAO;

	@Override
	@Transactional
	public List<Category> getCategories() {

		return categoryDAO.getCategories();
	}

	@Override
	@Transactional
	public Category getCategory(int theId) {

		return categoryDAO.getCategory(theId);
	}

}
