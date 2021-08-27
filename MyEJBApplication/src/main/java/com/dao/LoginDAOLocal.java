package com.dao;

import javax.ejb.Local;

/**
 *
 * @author Vedang Rane
 */
@Local
public interface LoginDAOLocal {
    
      public boolean checkUser(String username, String password);
      
}
