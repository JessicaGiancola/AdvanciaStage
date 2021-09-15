
package model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dough")
public class Dough implements DBInterface, Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doughID")
    private int doughID;
    
    @Column(name = "type")
    private String type;
    
//    @OneToMany(cascade=CascadeType.ALL)
//    @JoinColumn(name="dough_doughID")
//    private List<Pizza> pizzas = new ArrayList<Pizza>();

	public Dough() {}

	public Dough(String type) {
		super();
		this.type = type;
	}

	public int getDoughID() {
		return doughID;
	}

	public void setDoughID(int doughID) {
		this.doughID = doughID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

//	public List<Pizza> getPizzas() {
//		return pizzas;
//	}
//
//	public void setPizzas(List<Pizza> pizzas) {
//		this.pizzas = pizzas;
//	}

	@Override
	public String toString() {
		return "Dough [doughID=" + doughID + ", type=" + type + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(doughID, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dough other = (Dough) obj;
		return doughID == other.doughID && Objects.equals(type, other.type);
	}
 
}
