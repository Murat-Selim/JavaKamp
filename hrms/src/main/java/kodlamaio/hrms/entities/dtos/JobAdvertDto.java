package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
	private String companyName;
	private String jobTitle;
	private LocalDateTime applicationDeadline;
	private LocalDate createdDate = LocalDate.now();
	private int numberOfOpenPosition;
}
