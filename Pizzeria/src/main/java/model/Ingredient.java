package model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "ingredient")
public class Ingredient implements DBInterface {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingID")
    private int ingID;
    
    @Column(name = "ingName")
    private String ingName;

//    @ManyToMany(mappedBy="ingredients")
//    private List<Pizza> belongs = new ArrayList<Pizza>();
    
    
	public Ingredient() {}
		

	public Ingredient(String ingName) {
		this.ingName = ingName;
	}

	public int getIngID() {
		return ingID;
	}


	public void setIngID(int ingID) {
		this.ingID = ingID;
	}


	public String getIngName() {
		return ingName;
	}


	public void setIngName(String ingName) {
		this.ingName = ingName;
	}


//	public List<Pizza> getBelongs() {
//		return belongs;
//	}
//
//
//	public void setBelongs(List<Pizza> belongs) {
//		this.belongs = belongs;
//	}


	@Override
	public String toString() {
		return "Ingredient [ingID=" + ingID + ", ingName=" + ingName + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(ingID, ingName);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ingredient other = (Ingredient) obj;
		return ingID == other.ingID && Objects.equals(ingName, other.ingName);
	}
	
}
