package com.dao;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Vedang Rane
 */
@Stateless
public class LoginDAO implements LoginDAOLocal {
	
	@PersistenceContext(unitName = "EJBDB")
    private EntityManager em;
 
 	public LoginDAO() { }
 	
    @Override
    public boolean checkUser(String userName, String password) {
       
    	System.out.println("username " + userName + " pass "+password);
//        List<Login> s = em.createQuery("select e from Login e where e.userName='"+userName+"' and e.password='"+password+"'").getResultList();
//        System.out.println("is list empty ?"+s.isEmpty()+" for the"+userName+" and "+password);
       
//	    if(!s.isEmpty())
	       return true;
//	    else
//	       return false;
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}