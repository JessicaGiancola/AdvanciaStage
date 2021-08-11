package util;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.DBInterface;
import model.Dough;
import model.Ingredient;
import model.Pizza;
import model.User;

public class CRUDOperations {
	
	private EntityManager manager = null;
	private EntityTransaction txn = null;
	private static boolean initialized = false;
	private static String packName = "model.";
	
	private EntityManager getManager() {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		txn = entityManager.getTransaction();
        return entityManager;
	}
	
	private void commitAndClose() {
		
		txn.commit();
		manager.close();
	}
	
    public void insertRecord(User user) {
        manager = getManager();
        txn.begin();
        manager.persist(user);
        commitAndClose();
    }
    
    public void insertRecord(Pizza pizza, String userID, String doughID, String[] ingIDs) {
    	
    	manager = getManager();
    	txn.begin();
    	
    	User creator = manager.find(User.class, Integer.parseInt(userID));
    	pizza.setUser(creator);
    	
    	Dough dough = manager.find(Dough.class, Integer.parseInt(doughID));
    	pizza.setDough(dough);
    	
    	for (String ingID : ingIDs) {
    		System.out.println("ing id "+ingID);
    		Ingredient ing = manager.find(Ingredient.class, Integer.parseInt(ingID));
    		pizza.addIngredient(ing);
    	}
    	
    	manager.persist(pizza);
    	
    	commitAndClose();
    }
    
    public void insertRecord(Ingredient ing) {
    	manager = getManager();
        txn.begin();
        manager.persist(ing);
        commitAndClose();
    }
    
    public void insertRecord(Dough dough) {
    	manager = getManager();
        txn.begin();
        manager.persist(dough);
        commitAndClose();
    }

    public int login(String username, String password) {
        manager = getManager();
        txn.begin();
        int id = 0;
        Query query = manager.createQuery("from User where username = ?1");
        //User logger = (User) manager.createQuery("from User where username='"+ username + "' and password='" + password +"'").getSingleResult();
        User logger = (User) query.setParameter(1, username).getSingleResult();
        
        if (logger.getPassword().equals(password)) {
        	id = logger.getUserID();
        }
        
        commitAndClose();
        return id;

    }
    
    public List<DBInterface> getAll(String table, String userID){
        manager = getManager();
        txn.begin(); 
        
        Query query = manager.createQuery("from " + table);
        
        if (userID != null) {
        	query = manager.createQuery("from " + table + " where user_userID = ?1");
        	query.setParameter(1, userID);
        }

//        String query = "from " + table;
//        
//        if (userID != null) {
//        	query += " where user_userID=" + userID;
//        }
//        
//    	List<DBInterface> result = manager.createQuery(query, DBInterface.class).getResultList();
    	
        List<DBInterface> result = query.getResultList();
         
        commitAndClose();
    	return result;
    }
    
    public List<DBInterface> getAll(String table) {
    	return this.getAll(table, null);
    }
    
    public DBInterface findObj(String table, String id) {
    	manager = getManager();
    	txn.begin();
    	DBInterface obj = null;
    	String tableName = packName + table;
    	
		try {
			obj = (DBInterface) manager.find(Class.forName(tableName), Integer.parseInt(id));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    	commitAndClose();
    	return obj;
    }
    
    public void UpdatePizza(String pizzaID, String name, String doughID, String[] ingIDs) {
    	manager = getManager();
    	txn.begin();
    	
    	Pizza pizza = null;
		Dough d = null;
		Ingredient i = null;
		List<Ingredient> ingr = new ArrayList<Ingredient>();
		
		try {
			pizza = (Pizza) manager.find(Class.forName(packName + "Pizza"), Integer.parseInt(pizzaID));
			d = (Dough) manager.find(Class.forName(packName + "Dough"), Integer.parseInt(doughID));
			for (String ing : ingIDs) {
				i = (Ingredient) manager.find(Class.forName(packName + "Ingredient"), Integer.parseInt(ing));
				ingr.add(i);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		pizza.setPizzaName(name);
		pizza.setDough(d);
		pizza.setIngredients(ingr);
		
    	commitAndClose();
    }
    
    public void removeObj(String table, String id) {
    	manager = getManager();
    	txn.begin();
    	
    	DBInterface obj = null;
    	try {
			obj = (DBInterface) manager.find(Class.forName(packName + table), Integer.parseInt(id));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	manager.remove(obj);
    	
    	commitAndClose();
    }
    
    public void inizialitazion() {	
	    if (!initialized) {  
	    	manager = getManager();
	        txn.begin();
	        
	        User principale = new User("Jessica","Jenny","1234");
	        manager.persist(principale);
	        
	        String[] ingredients = {"pomodoro", "mozzarella", "prosciutto crudo", "prosciutto cotto", "funghi"};
	        Ingredient ing = null;
	        for (String descIng : ingredients) {
	        	ing = new Ingredient(descIng);
	        	manager.persist(ing);
	        }
	        
	        String[] doughs = {"Impasto bianco","Impasto con farina di canapa","Impasto nero al carbone vegetale"};
	        Dough dough = null;
	        for (String type : doughs) {
	        	dough = new Dough(type);
	        	manager.persist(dough);
	        }
	        initialized = true;
	        commitAndClose();
	    }
    }

    
//    public void findEntity() {
//        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
//        entityManager.getTransaction().begin();
//        Student student = entityManager.find(Student.class, 1);
//        System.out.println("student id :: " + student.getId());
//        System.out.println("student firstname :: " + student.getFirstName());
//        System.out.println("student lastname :: " + student.getLastName());
//        System.out.println("student email :: " + student.getEmail());
//        entityManager.getTransaction().commit();
//        entityManager.close();
//    }
//
//    public void updateEntity() {
//        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
//        entityManager.getTransaction().begin();
//
//        Student student = entityManager.find(Student.class, 1);
//        System.out.println("student id :: " + student.getId());
//        System.out.println("student firstname :: " + student.getFirstName());
//        System.out.println("student lastname :: " + student.getLastName());
//        System.out.println("student email :: " + student.getEmail());
//
//        // The entity object is physically updated in the database when the transaction
//        // is committed
//        student.setFirstName("Ram");
//        student.setLastName("jadhav");
//        entityManager.getTransaction().commit();
//        entityManager.close();
//    }
//
//    public void removeEntity() {
//        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
//        entityManager.getTransaction().begin();
//
//        Student student = entityManager.find(Student.class, 1);
//        System.out.println("student id :: " + student.getId());
//        System.out.println("student firstname :: " + student.getFirstName());
//        System.out.println("student lastname :: " + student.getLastName());
//        System.out.println("student email :: " + student.getEmail());
//        entityManager.remove(student);
//        entityManager.getTransaction().commit();
//        entityManager.close();
//    }

}
