package com.CustomerRelationshipManagement.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.CustomerRelationshipManagement.entity.Customer;

import jakarta.persistence.EntityManager;

@Repository
public class CustomerDao {

	// database ka code
//	@Autowired
	SessionFactory sf;

	public CustomerDao(SessionFactory sf) {
		super();
		this.sf = sf;
	}

	public String insertCustomer(Customer customer) {

		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		// insert , update , delete -> you need to use Transaction
		// save nam ki method -> session
		session.save(customer);// to insert data
		tr.commit();
		session.close();

		return "Customer insert Successfully";

	}

	public List<Customer> getCustomersList() {

		Session session = sf.openSession();
		return session.createQuery("from Customer").list();

	}

	public Customer getcustomerById(int id) {
		// get -> it will return null if object not found in db
		// load-> it will return objectNotfoundException if object not found in db
		Session session = sf.openSession();
		Customer customer = session.get(Customer.class, id);

		return customer;
	}

	public String updateCustomer(Customer customer) {

		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		session.update(customer);
		tr.commit();
		session.close();

		return "customer updated successfully";

	}

	public String deleteCustomerById(int id) {

		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Customer customer = session.get(Customer.class, id);
		session.delete(customer);
		tr.commit();
		session.close();

		return "customer delete successfully";

	}

	public String insertMutipleCustomers(List<Customer> customers) {

		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		for (Customer customer : customers) {

			session.save(customer);

		}
		tr.commit();
		session.close();

		return "Customers are inserted successfully";

	}

	public List<Customer> getCustomersByFirstName(String firstName) {

		Session session = sf.openSession();

		Query<Customer> customers = session.createQuery("from Customer c  where c.firstName=:firstName",
				Customer.class);
		customers.setParameter("firstName", firstName);
		List<Customer> list = customers.list();

		return list;

	}

	public List<Customer> getCustomersByLessThanAge(int age) {

		Session session = sf.openSession();
		Query<Customer> customers = session.createQuery("from Customer c where c.age>:age", Customer.class);
		customers.setParameter("age", age);
		List<Customer> list = customers.list();

		return list;

	}

	public List<Customer> getCustoemrsByAge(int age) {
		String hql = "from Customer c where c.age=:age ";
		Session session = sf.openSession();
		Query<Customer> customers = session.createQuery(hql, Customer.class);
		customers.setParameter("age", age);
		List<Customer> list = customers.list();

		return list;
	}

	public List<Customer> getCustomerByLastName(String lastName) {

		Session session = sf.openSession();
		Query<Customer> customers = session.createQuery("from Customer c where c.lastName=:lastName", Customer.class);

		customers.setParameter("lastName", lastName);
		List<Customer> list = customers.list();

		return list;
	}
	
	public List<Customer> getCustomerByEmail(String email) {

		Session session = sf.openSession();
		Query<Customer> customers = session.createQuery("from Customer c where c.email=:email", Customer.class);

		customers.setParameter("email", email);
		List<Customer> list = customers.list();

		return list;
	}
	
	public List<Customer> getCustomerByMobileNumber(String mobileNumber) {

		Session session = sf.openSession();
		Query<Customer> customers = session.createQuery("from Customer c where c.mobileNumber=:mobileNumber", Customer.class);

		customers.setParameter("mobileNumber", mobileNumber);
		List<Customer> list = customers.list();

		return list;
	}
	
	public String updateFirstName(int id ,String firstName) {
		
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Customer customer=session.get(Customer.class, id);
		customer.setFirstName(firstName);
		tr.commit();
		session.close();
		
		return "updated successfully";
		
	}
	
	public String updateLastName(int id,String lastName) {
		
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Customer customer=session.get(Customer.class, id);
		customer.setLastName(lastName);
		tr.commit();
		session.close();
		return "updated successfully";
	}
	public String updateEmailId(int id,String emailId) {
		
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Customer customer=session.get(Customer.class, id);
		customer.setEmail(emailId);
		tr.commit();
		session.close();
		
	return "Email has been updated";
			
	}
	public String updateMobileNumber(int id,String mobileNumber) {
		
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Customer customer=session.get(Customer.class, id);
		customer.setMobileNumber(mobileNumber);
		tr.commit();
		session.close();
		return "Mobile Number has been updated";
	}

	public String updateAge(int id,int age) {
		
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Customer customer=session.get(Customer.class, id);
		customer.setAge(age);
		tr.commit();
		session.close();
		
		return "Age has been Update";
	}
	
	public List<String> getCustomersFirstNames()
	{
		
		Session session=sf.openSession();
		return session.createQuery("select c.email from Customer c").list();
	}
	

	
	
	
}
