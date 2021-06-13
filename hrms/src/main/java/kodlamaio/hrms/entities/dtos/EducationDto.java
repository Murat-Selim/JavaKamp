package kodlamaio.hrms.entities.dtos;

import java.time.LocalDateTime;

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
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	

}
