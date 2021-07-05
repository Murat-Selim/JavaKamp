package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
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
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate applicationDeadline;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate createdDate;
	private int numberOfOpenPosition;
}
