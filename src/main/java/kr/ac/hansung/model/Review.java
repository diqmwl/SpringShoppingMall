package kr.ac.hansung.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Review {

	
	@Size(min = 2, max = 20, message = "Year must be between 2 and 100 chars")
	private String username;

	@NotEmpty
	@Size(min = 2, max = 20, message = "Year must be between 2 and 100 chars")
	private String product_name;
	
	@NotEmpty
	@Size(min = 2, max = 20, message = "Year must be between 2 and 100 chars")
	private String review_desc;

	private int score;

	@Size(min = 1, max = 20, message = "Year must be between 2 and 100 chars")
	private String date;
}
