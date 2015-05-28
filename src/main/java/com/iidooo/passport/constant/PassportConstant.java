/**
 * Copyright 2014-2015 IIDOOO All rights reserved.
 * Author(e-mail)    wangyixian@iidooo.com
 * Creation date     2015-03-27
 */
package com.iidooo.passport.constant;

/**
 * The Passport Constant class is defined as the constant string class.
 * All of the constant of this project should be defined in this class.
 * 
 * @author Ethan
 *
 */
public class PassportConstant {    

    // The login id of session and cookies key.
    public static final String LOGIN_ID = "LOGIN_ID";

    // The user id of session and cookies key.
    public static final String USER_ID = "USER_ID";

    // The user name of session and cookie key.
    public static final String USER_NAME = "USER_NAME";

    // The SSO URL of session key.
    // If the APP should login, should redirect to this SSO URL
    public static final String PASSPORT_URL = "PASSPORT_URL";

    // The access URL of login success should be redirected.
    public static final String ACCESS_URL = "ACCESS_URL";
    
    public static final String REST_API_USER = "user";
    
    public static final String RESOURCE_CODE = "RESOURCE_CODE";
    
    // The SecurityUser of the login user, save it in the session using this key.
    public static final String SECURITY_USER = "SECURITY_USER";
    
    public static final String SECURITY_USER_ID = "userID";
    
    public static final String SECURITY_USER_NAME = "userName";
    
    public static final String CURRENT_MODULE = "CURRENT_MODULE";
    
    public static final String SECURITY_RESOURCE_LIST = "SECURITY_RESOURCE_LIST";
    
    public static final String SECURITY_RESOURCE_MAP = "SECURITY_RESOURCE_MAP";
    

    // The bean of SecurityResourceDao
    public static final String BEAN_SECURITY_RESOURCE_DAO = "securityResourceDao";
    
}
