package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertAddDto {

	private String jobDescription;
	private LocalDateTime applicationDeadline;
    private int numberOfOpenPosition;
	private LocalDate createdDate;
	private Double minSalary;
	private Double maxSalary;
	private boolean isActive;
	private int employerId;
	private int cityId;
}
