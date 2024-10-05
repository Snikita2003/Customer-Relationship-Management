package com.CustomerRelationshipManagement.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.CustomerRelationshipManagement.dao.CustomerDao;
import com.CustomerRelationshipManagement.entity.Customer;
import com.CustomerRelationshipManagement.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	CustomerDao customerDao;

	public CustomerServiceImpl(CustomerDao customerDao) {
		super();
		this.customerDao = customerDao;
	}

	@Override
	public String insertCustomer(Customer customer) {

		String msg = customerDao.insertCustomer(customer);

		return msg;
	}

	@Override
	public List<Customer> getCustomersList() {

		List<Customer> list= customerDao.getCustomersList();
		
		return list;
	}

	@Override
	public Customer getCustomerById(int id) {

		
		Customer customer= customerDao.getcustomerById(id);
		
		return customer;
	}

	@Override
	public String customerUpdate(Customer customer) {

		
		return customerDao.updateCustomer(customer);
	}

	@Override
	public String customerdeleteById(int id) {

		
		return customerDao.deleteCustomerById(id);
	}

	@Override
	public String insertMultipleCustomer(List<Customer> customers) {

		return customerDao.insertMutipleCustomers(customers);
	}

	@Override
	public List<Customer> getCustomerByFirstName(String firstName) {

		return customerDao.getCustomersByFirstName(firstName);
	}

	@Override
	public List<Customer> getCustomerByLessThanAge(int age) {

		return customerDao.getCustomersByLessThanAge(age);
	}

	@Override
	public List<Customer> getCustomerByAge(int age) {

		return customerDao.getCustoemrsByAge(age);
	}

	@Override
	public List<Customer> getCustomerByLastName(String name) {

		return customerDao.getCustomerByLastName(name);
	}

	@Override
	public List<Customer> getCustomerByEmail(String email) {
		// TODO Auto-generated method stub
		return customerDao.getCustomerByEmail(email);
	}

	@Override
	public List<Customer> getCustomerByMobileNumber(String aadi) {
		// TODO Auto-generated method stub
		return customerDao.getCustomerByMobileNumber(aadi);
	}

	@Override
	public String updateFirstName(int id, String firstName) {
		// TODO Auto-generated method stub
		return customerDao.updateFirstName(id, firstName);
	}

	@Override
	public String updateLastName(int id, String lastName) {
		// TODO Auto-generated method stub
		return customerDao.updateLastName(id, lastName);
	}

	@Override
	public String updateEmail(int id, String emailId) {
		// TODO Auto-generated method stub
		return customerDao.updateEmailId(id, emailId);
	}

	@Override
	public String updateMobileNumber(int id, String mobileNumber) {
		// TODO Auto-generated method stub
		return customerDao.updateMobileNumber(id, mobileNumber);
	}

	@Override
	public String updateAge(int id, int age) {
		// TODO Auto-generated method stub
		return customerDao.updateAge(id, age);
	}

	@Override
	public List<String> getCustomerFirstName() {
		// TODO Auto-generated method stub
		return customerDao.getCustomersFirstNames();
	}


}
