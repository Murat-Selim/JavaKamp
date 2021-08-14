package kodlamaio.hrms.entities.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertFilterDto {

	private List<Integer> cityId;
	
	private List<Integer> jobPositionId;
	
	private List<Integer> workTimeId;
	
	private List<Integer> workPlaceId;
	
}