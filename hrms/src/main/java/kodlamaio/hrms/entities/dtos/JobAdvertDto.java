package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertDto {

	@JsonProperty(access = Access.READ_ONLY)
	private int id;
	private String employerCompanyName;
	private String jobTitle;
	private LocalDate applicationDeadline;
	private LocalDate createdDate;
	private int numberOfOpenPosition;
	private String cityName;
	private String workTimeName;
}
