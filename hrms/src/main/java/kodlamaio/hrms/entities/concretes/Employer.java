package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import com.vladmihalcea.hibernate.type.json.JsonType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name="employers")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdverts"})

@TypeDefs({
    @TypeDef(name = "json", typeClass = JsonType.class)
})

public class Employer extends User{
	
	 @Column(name="company_name")
     private String companyName;
	 
	 @Column(name="web_address")
     private String webAddress;
	 
	 @Column(name="phone_number")
     private String phoneNumber;
	 
	 @Column(name="is_activated")
	 private boolean isActivated;
	 
	 @JsonIgnore
	 @OneToMany(mappedBy = "employer", cascade = CascadeType.ALL)
	 private List<JobAdvert> jobAdverts;
	 
	 @Type(type = "json")
	 @Column(columnDefinition = "json", name = "updated_data")
	 private Employer updatedData;
	
}
