package in.sudha.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sudha.entity.Customer;
import in.sudha.exception.CustomerNotFoundException;
import in.sudha.repo.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired	
	private CustomerRepository repo;
	
	@Override
	public Long saveCustomer(Customer cus) {
		return repo.save(cus).getId();
	}

	@Override
	public Customer getOneCustomer(Long id) {
		 Optional<Customer> opt = repo.findById(id);
		  return validateInput(opt, id.toString());
	}
	
	@Override
	public List<Customer> getAllCustomer() {
		return repo.findAll();
	}

	@Override
	public Customer getCustomerByEmail(String email) {
      Optional<Customer> opt = repo.findByEmail(email);
		return validateInput(opt,email);
	}


	@Override
	public Customer getCustomerByMobile(String mobile) {
		 Optional<Customer> opt =repo.findByMobile(mobile);
		return validateInput(opt, mobile);
	}

	@Override
	public Customer getCustomerByPanCard(String pancard) {
		 Optional<Customer> opt =repo.findByPanCard(pancard);
		return validateInput(opt, pancard);
	}

	@Override
	public Customer getCustomerByAdharCard(String adharcard) {
		 Optional<Customer> opt =repo.findByAdharCard(adharcard);
		return validateInput(opt, adharcard);
	}

	private Customer validateInput(Optional<Customer> opt, String input) {
		/*if (opt.isEmpty()) {
		throw new CustomerNotFoundException("Customer '" + input + "' not found");
	} else {
		 return opt.get();

		}*/
		return opt.orElseThrow(()->new CustomerNotFoundException(
				"Customer '"+input+"' not found exception"));
	}

}
