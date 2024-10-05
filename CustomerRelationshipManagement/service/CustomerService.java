package com.CustomerRelationshipManagement.service;

import java.util.List;

import com.CustomerRelationshipManagement.entity.Customer;

public interface CustomerService {

	String insertCustomer(Customer customer);

	List<Customer> getCustomersList();

	Customer getCustomerById(int id);

	String customerUpdate(Customer customer);

	String customerdeleteById(int id);

	String insertMultipleCustomer(List<Customer> customers);

	List<Customer> getCustomerByFirstName(String firstName);

	List<Customer> getCustomerByLessThanAge(int age);

	List<Customer> getCustomerByAge(int age);
	
	List<Customer> getCustomerByLastName(String name);
	
	List<Customer> getCustomerByEmail(String email);
	
	List<Customer>getCustomerByMobileNumber(String aadi);
	
	String updateFirstName(int id,String firstName);
	
	String updateLastName(int id,String lastName);
	
	String updateEmail(int id,String emailId);
	
	String updateMobileNumber(int id,String mobileNumber);
	
	String updateAge(int id, int age);
	
	List<String> getCustomerFirstName();
}
