package kodlamaio.hrms.entities.dtos;

import java.time.LocalDateTime;

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
	private LocalDateTime startDate;
	private LocalDateTime exitDate;
}
