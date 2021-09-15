package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userID", nullable = false)
    private int id;
    
    @Column(name = "username", nullable = false)
    private String username;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "password", nullable = false)
    private String password;
    
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="user_userID")
    private List<Pizza> myPizzas = new ArrayList<Pizza>();
    
    public User() {}
    
    public User(String name, String username, String password) {
    	this.name = name;
    	this.username = username;
    	this.password = password;
    }

    public User(String username, String password) {
    	this.username = username;
    	this.password = password;
    }
    
	public int getUserID() {
		return id;
	}

	public void setUserID(int ID) {
		this.id = ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Pizza> getMyPizzas() {
		return myPizzas;
	}

	public void setMyPizzas(List<Pizza> myPizzas) {
		this.myPizzas = myPizzas;
	}

	@Override
	public String toString() {
		return "User id: " + id + ", nome: " + name + ", username: " + username;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, myPizzas, name, password, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password) && Objects.equals(username, other.username);
	}
    
    
}
