package kodlamaio.hrms.entities.dtos;

import java.sql.Date;

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
	private Date startDate;
	private Date endDate;
	

}
