package kodlamaio.hrms.entities.dtos;


import java.time.LocalDateTime;

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
	private LocalDateTime createdDate;
	private LocalDateTime applicationDeadline;
	private Double minSalary;
	private Double maxSalary;
	private boolean isActive;
	private int cityId;
	private int jobPositionId;
	private int employerId;
}
