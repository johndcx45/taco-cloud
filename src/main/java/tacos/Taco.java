package tacos;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class Taco {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@NotNull
	@Size(min=5, message="Name must be at least 5 characters long")
	private String name;

	private Date createdAt;

	@ManyToMany(targetEntity=Ingredient.class)
	@Size(min=1, message="You must choose at least 1 ingredient")
	private List<Ingredient> ingredients;

	@ManyToOne
	@JoinColumn(name = "orderId_fk", referencedColumnName = "orderId")
	private TacoOrder tacoOrder;

	@PrePersist
	void createdAt() {
		this.createdAt = new Date();
	}
}
