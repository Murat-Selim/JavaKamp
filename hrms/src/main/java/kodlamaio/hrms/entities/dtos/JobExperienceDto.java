package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobExperienceDto {
	
	private int id;
	private int cvId;
	private int jobPositionId;
	private String companyName;
	private LocalDate startDate;
	private LocalDate exitDate;
}
