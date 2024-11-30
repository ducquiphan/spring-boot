package com.ducpq.demo.myspringbootapp.dao.impl;

import com.ducpq.demo.myspringbootapp.dao.StudentDAO;
import com.ducpq.demo.myspringbootapp.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {
	
	// define field for entity manager
	private final EntityManager entityManager;
	
	// inject entity manager using constructor injection
	@Autowired
	public StudentDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	// implement save method
	@Override
	@Transactional
	public void save(Student student) {
		entityManager.persist(student);
	}
	
	@Override
	public Student findById(Integer id) {
		return entityManager.find(Student.class, id);
	}
	
	@Override
	public List<Student> findAll() {
		// create query
		TypedQuery<Student> query = entityManager.createQuery("from Student order by lastName desc", Student.class);
		return query.getResultList();
	}
	
	@Override
	public List<Student> findByFirstName(String firstName) {
		// create query
		TypedQuery<Student> query = entityManager.createQuery("from Student where lower(firstName) like concat('%',:searchFirstName,'%')",
				Student.class);
		query.setParameter("searchFirstName", firstName);
		return query.getResultList();
	}
	
	@Override
	public List<Student> findByLastName(String lastName) {
		// create query
		TypedQuery<Student> query = entityManager.createQuery("from Student where lower(lastName) like concat('%',:searchLastName,'%')", Student.class);
		query.setParameter("searchLastName", lastName);
		return query.getResultList();
	}
	
	@Override
	public List<Student> findByEmail(String email) {
		// create query
		TypedQuery<Student> query = entityManager.createQuery("from Student where lower(email) like concat('%',:searchEmail,'%')", Student.class);
		query.setParameter("searchEmail", email);
		return query.getResultList();
	}
	
	@Override
	public List<Student> findBySearchTerm(String searchTerm) {
		// create query
		TypedQuery<Student> query = entityManager.createQuery("from Student " +
				"where lower(email) like concat('%',:searchTerm,'%')" +
				"or lower(firstName) like concat('%',:searchTerm,'%')" +
				"or lower(lastName) like concat('%',:searchTerm,'%')", Student.class);
		query.setParameter("searchTerm", searchTerm);
		return query.getResultList();
	}
	
	@Override
	@Transactional
	public Student update(Student student) {
		return entityManager.merge(student);
	}
	
	@Override
	@Transactional
	public void delete(Integer id) {
		Student student = findById(id);
		entityManager.remove(student);
	}
	
	@Override
	@Transactional
	public int deleteAll() {
		return entityManager.createQuery("delete from Student").executeUpdate();
	}
}
