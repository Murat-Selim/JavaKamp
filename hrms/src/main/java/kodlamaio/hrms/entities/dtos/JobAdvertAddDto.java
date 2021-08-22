package kodlamaio.hrms.entities.dtos;


import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

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
    @JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate createdDate;
    @JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate applicationDeadline;
	private Double minSalary;
	private Double maxSalary;
	private boolean isActive;
	private int employerId;
	private int cityId;
	private int jobPositionId;
	private int workTimeId;
	private int workPlaceId;
}
