
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
@Table(name = "pizza")
public class Pizza implements DBInterface, Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pizzaID")
    private int pizzaID;
    
    @Column(name = "pizzaName")
    private String pizzaName;
    
    @ManyToOne
    private User user;
    
    @ManyToOne
    private Dough dough;
    
    @Fetch(FetchMode.JOIN)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="ing_pizza", joinColumns={@JoinColumn(referencedColumnName="pizzaID")}
                                        , inverseJoinColumns={@JoinColumn(referencedColumnName="ingID")})  
    private List<Ingredient> ingredients = new ArrayList<Ingredient>();

	public Pizza() {}

	public Pizza(String pizzaName) {
		super();
		this.pizzaName = pizzaName;
	}

	public Pizza(String pizzaName, User creator, Dough pizzaDough, List<Ingredient> ingredients) {
		super();
		this.pizzaName = pizzaName;
		this.user = creator;
		this.dough = pizzaDough;
		this.ingredients = ingredients;
	}

	public int getPizzaID() {
		return pizzaID;
	}

	public void setPizzaID(int pizzaID) {
		this.pizzaID = pizzaID;
	}

	public String getPizzaName() {
		return pizzaName;
	}

	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Dough getDough() {
		return dough;
	}

	public void setDough(Dough dough) {
		this.dough = dough;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
	public void addIngredient(Ingredient ing) {
		this.ingredients.add(ing);
	}

	@Override
	public String toString() {
		String descr = "Pizza [pizzaID=" + pizzaID + ", pizzaName=" + pizzaName + ", creator=" + user + ", pizzaDough="
				+ dough.getType() + ", ingredients=";
		
		for(Ingredient i : ingredients) {
			descr+= " " + i.getIngName() + ",";
		}
		
		
		return descr;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dough, pizzaID, pizzaName, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pizza other = (Pizza) obj;
		return Objects.equals(dough, other.dough) && pizzaID == other.pizzaID && Objects.equals(pizzaName, other.pizzaName)
				&& Objects.equals(user, other.user);
	}

	
}
