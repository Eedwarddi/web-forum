package forum.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import forum.entity.Category;

@Repository
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public List<Category> getCategories() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Category> theQuery =
				currentSession.createQuery("from Category", Category.class);
		
		List<Category> categories = theQuery.getResultList();

		return categories;
	}


	@Override
	public Category getCategory(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Category category = currentSession.get(Category.class, theId);
		
		return category;
	}

}
