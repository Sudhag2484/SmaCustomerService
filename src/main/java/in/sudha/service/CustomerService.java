package in.sudha.service;

import java.util.List;

import in.sudha.entity.Customer;

public interface CustomerService {
	
	Long saveCustomer(Customer cus);
	Customer getOneCustomer(Long id);
	Customer getCustomerByEmail(String email);
	Customer getCustomerByMobile(String mobile);
	Customer getCustomerByPanCard(String pancard);
	Customer getCustomerByAdharCard(String adharcard);
	List<Customer> getAllCustomer();
	
	

}
