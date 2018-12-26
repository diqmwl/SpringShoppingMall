package kr.ac.hansung.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Product {

	private int product_id;

	@NotEmpty
	@Size(min = 2, max = 20, message = "Year must be between 2 and 100 chars")
	private String product_name;

	private int product_price;

	@NotEmpty
	@Size(min = 1, max = 20, message = "Year must be between 2 and 100 chars")
	private String product_desc;

	@NotEmpty
	private String product_url;
}
