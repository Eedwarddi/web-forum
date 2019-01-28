package forum.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
		
		CriteriaBuilder cb = currentSession.getCriteriaBuilder();
		
		CriteriaQuery<Category> cq = cb.createQuery(Category.class);
		
		Root<Category> rootEntry = cq.from(Category.class);
		
		CriteriaQuery<Category> all = cq.select(rootEntry);
		
		TypedQuery<Category> allQuery = currentSession.createQuery(all);

		return allQuery.getResultList();
	}


	@Override
	public Category getCategory(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Category category = currentSession.get(Category.class, theId);
		
		return category;
	}

}
