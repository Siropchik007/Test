package pojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserPojoFull{
	@JsonProperty("id")
	private int id;
	@JsonProperty("fist_name")
	private String firstName;


}
