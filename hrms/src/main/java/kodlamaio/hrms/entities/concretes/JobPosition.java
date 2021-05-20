package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="job_positions")
public class JobPosition {
   
   @Id
   @GeneratedValue
   @Column(name="id")
   private int id;
   
   @Column(name="job_title")
   private String job_title;
   
   public JobPosition() {
	   
   }

   public JobPosition(int id, String job_title) {
	super();
	this.id = id;
	this.job_title = job_title;
   }
}
