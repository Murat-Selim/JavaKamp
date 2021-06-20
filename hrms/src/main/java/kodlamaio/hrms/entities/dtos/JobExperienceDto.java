package kodlamaio.hrms.entities.dtos;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobExperienceDto {

	private int cvId;
	private int jobPositionId;
	private String companyName;
	private Date startDate;
	private Date exitDate;
}
