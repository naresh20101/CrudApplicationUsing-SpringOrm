package com.spring.orm.SpringORM.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.SpringORM.Entity.Student;

public class StudentDao {
	private HibernateTemplate hibernateTemplate;
	@Transactional
	public int insert(Student student)
	{
		int r=(Integer)this.hibernateTemplate.save(student);
		return r;
	}
	public Student getStudent(int id)
	{
		Student student=this.hibernateTemplate.get(Student.class, id);
		return student;
		
	}
	public List<Student> getAll(){
		List<Student> students=this.hibernateTemplate.loadAll(Student.class);
		return students;
	}
	@Transactional
	public void  delete(int id)
	{
		Student student=this.hibernateTemplate.get(Student.class, id);
		this.hibernateTemplate.delete(student);
		s
	}
	@Transactional
	public void update(Student student)
	{
		this.hibernateTemplate.update(student);
	}
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
