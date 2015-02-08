package com.iidooo.framework.constant;

public class SessionConstant {

    /**
     * The Session Key of the login user
     */
    public static final String SECURITY_USER = "SECURITY_USER";
    
    /**
     * If session expired, need to login.
     * Save the redirect url after login success.
     */
    public static final String REDIRECT_URL = "REDIRECT_URL";
    
    /**
     * The session key of all of the users.
     * Map Key: UserID
     * Map Name: UserName
     */
    public static final String SECURITY_USERS_MAP = "SECURITY_USERS_MAP";
}
