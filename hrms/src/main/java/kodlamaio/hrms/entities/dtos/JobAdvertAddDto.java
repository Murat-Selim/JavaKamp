package kodlamaio.hrms.entities.dtos;


import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertAddDto {

	private int id;
	private String jobDescription;
    private int numberOfOpenPosition;
	private Date createdDate;
	private Date applicationDeadline;
	private Double minSalary;
	private Double maxSalary;
	private boolean isActive;
	private int cityId;
	private int jobPositionId;
	private int employerId;
	private int workTimeId;
	private int workPlaceId;
}
