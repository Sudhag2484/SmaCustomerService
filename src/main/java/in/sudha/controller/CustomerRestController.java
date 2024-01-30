package in.sudha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.sudha.entity.Customer;
import in.sudha.exception.CustomerNotFoundException;
import in.sudha.service.CustomerService;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/customer")
public class CustomerRestController {
	
	@Autowired
	private CustomerService service;
	
	
	@PostMapping("/save")
	public ResponseEntity<String> saveCustomer(@RequestBody Customer cus){
		
	log.info("ENTERED INTO SAVE METHOD");
		 ResponseEntity<String>  resp=null;
		
		try{
			Long id = service.saveCustomer(cus);
			resp= ResponseEntity.ok("CREATED WITH ID "+id);
			log.info("CUSTOMER CREATED WITH ID ",id);
		}catch (CustomerNotFoundException e) {
			log.error(e.getMessage());
			throw e;
		}
		log.info("ABOUT TO LEAVE SAVE METHOD");
		return resp;

	}
	
	@GetMapping("/fetchId/{id}")
	public ResponseEntity<Customer> getOneCustomer(@PathVariable Long id){
		log.info("ENTERED INTO ONE FETCH METHOD");

		ResponseEntity<Customer> resp=null;
		try {
			Customer customer = service.getOneCustomer(id);
			resp=ResponseEntity.ok(customer);
			log.info("ONE FETCH METHOD IS SUCCESS");

		} catch (CustomerNotFoundException e) {
			log.error(e.getMessage());
	         throw e;		
  		}
		log.info("ABOUT TO LEAVE ONE FETCH METHOD");
		return resp;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Customer>> getAllCustomer(){
		log.info("ENTERED INTO FETCH METHOD");

		ResponseEntity<List<Customer>> resp=null;
		try {
			List<Customer> list = service.getAllCustomer();
			resp=ResponseEntity.ok(list);
			log.info("FETCH METHOD IS SUCCESS");

		} catch (CustomerNotFoundException e) {
			log.error(e.getMessage());
	         throw e;		
  		}
		log.info("ABOUT TO LEAVE FETCH METHOD");
		return resp;
	}
	
	@GetMapping("/fetchEmail/{email}")
	public ResponseEntity<Customer> getCustomerByEmail(@PathVariable String email){
		ResponseEntity<Customer> resp=null;
		try {
			Customer customer = service.getCustomerByEmail(email);
			resp=new ResponseEntity<Customer>(customer, HttpStatus.OK);
			
		} catch (CustomerNotFoundException e) {
          throw e;
		}
		return resp;
	}
	
	@GetMapping("/fetchMobile/{mobile}")
	public ResponseEntity<Customer> getCustomerByMobile(@PathVariable String mobile){
		ResponseEntity<Customer> resp=null;
		try {
			Customer customer = service.getCustomerByMobile(mobile);
			resp=new ResponseEntity<Customer>(customer, HttpStatus.OK);
			
		} catch (CustomerNotFoundException e) {
          throw e;
		}
		return resp;
	}
	
	@GetMapping("/fetch/{pancard}")
	public ResponseEntity<Customer> getCustomerByPancard(@PathVariable String pancard){
		ResponseEntity<Customer> resp=null;
		try {
			Customer customer = service.getCustomerByPanCard(pancard);
			resp=new ResponseEntity<Customer>(customer, HttpStatus.OK);
			
		} catch (CustomerNotFoundException e) {
          throw e;
		}
		return resp;
	}
	
	@GetMapping("/fetchAdhar/{adhar}")
	public ResponseEntity<Customer> getCustomerByAdhar(@PathVariable String adhar){
		ResponseEntity<Customer> resp=null;
		try {
			Customer customer = service.getCustomerByAdharCard(adhar);
			resp=new ResponseEntity<Customer>(customer, HttpStatus.OK);
			
		} catch (CustomerNotFoundException e) {
          throw e;
		}
		return resp;
	}
}
