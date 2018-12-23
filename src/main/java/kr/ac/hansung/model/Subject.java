package kr.ac.hansung.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Subject {

	private int year;

	private int semester;

	@Size(min = 1, max = 20, message = "Year must be between 2 and 100 chars")
	private String subjectcode;

	@Size(min = 1, max = 20, message = "Year must be between 2 and 100 chars")
	private String subjectname;

	@Size(min = 1, max = 20, message = "Year must be between 2 and 100 chars")
	private String division;

	private int grades;

	private String username;
}
