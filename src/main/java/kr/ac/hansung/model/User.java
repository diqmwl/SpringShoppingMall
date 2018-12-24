package kr.ac.hansung.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class User {

	@NotEmpty
	@Size(min = 5, max = 20, message = "Year must be between 5 and 20 chars")
	private String username;

	@Size(min = 5, max = 20, message = "Year must be between 5 and 20 chars")
	private String password;

	private int enabled;

}
