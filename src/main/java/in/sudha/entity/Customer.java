package in.sudha.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="CUSTOMER_TBL")
public class Customer {
	@Id
	@Column(name="cus_id_col")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name="cus_name_col")
	private String name;
	@Column(name="cus_email_col")
	private String email;
	@Column(name="cus_gender_col")
	private String gender;
	@Column(name="cus_imagePath_col")
	private String imagePath;
	@Column(name="cus_mobile_col")
	private String mobile;
	@Column(name="cus_address_col")
	private String address;
	@Column(name="cus_panCard_col")
	private String panCard;
	@Column(name="cus_aadharCard_col")
	private String adharCard;

}
