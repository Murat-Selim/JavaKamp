package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationDto {
	
	private int id;
	private int cvId;
	private int graduateId;
	private String schoolName;
	private String department;
	private LocalDate startDate;
	private LocalDate endDate;
	

}
