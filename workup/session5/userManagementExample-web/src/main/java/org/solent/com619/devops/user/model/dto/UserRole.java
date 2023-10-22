package org.solent.com619.devops.user.model.dto;

public enum UserRole {

    ROLE_ANONYMOUS, ROLE_CUSTOMER, ROLE_ADMINISTRATOR;
    
    public String getTag() {
    	return name().replace("ROLE_", "");
    }
    
}
