package kodlamaio.hrms.entities.dtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationDto {
	
	private int cvId;
	private int graduateId;
	private String description;
	private String schoolName;
	private String Department;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	

}
