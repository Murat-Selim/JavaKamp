package kodlamaio.hrms.entities.dtos;


import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvAddDto {
	
	private int candidateId;
	private String githubLink;
	private String linkedinLink;
	private String image;
	private String description;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;
	

}
