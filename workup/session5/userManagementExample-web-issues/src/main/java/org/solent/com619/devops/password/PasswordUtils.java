/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solent.com619.devops.password;

import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author gallenc
 */
public class PasswordUtils {
    
    public static String hashPassword(String password){
        return BCrypt.hashpw(password, BCrypt.gensalt(11));
    }
    
    public static boolean checkPassword(String password, String hashed){
        return BCrypt.checkpw(password, hashed);
    }
    
}
