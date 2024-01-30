package in.sudha.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import in.sudha.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

	java.util.Optional<Customer> findByEmail(String email);
	java.util.Optional<Customer> findByMobile(String mobile);
	java.util.Optional<Customer> findByPanCard(String pancard);
	java.util.Optional<Customer> findByAdharCard(String adhar);
}
