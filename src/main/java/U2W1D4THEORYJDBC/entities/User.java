package U2W1D4THEORYJDBC.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class User {
	private int id;
	private String name;
	private String surname;
	private String email;
}