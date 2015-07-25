/**
 * Copyright 2014-2015 IIDOOO All rights reserved.
 * Author(e-mail)    wangyixian@iidooo.com
 * Creation date     2015-03-27
 */
package com.iidooo.passport.constant;

/**
 * The Passport Constant class is defined as the constant string class. All of the constant of this project should be defined in this class.
 * 
 * @author Ethan
 *
 */
public class PassportConstant {


    // The bean of SecurityResourceDao
    public static final String BEAN_RESOURCE_DAO = "resourceDao";
    
    // The login id of session and cookies key.
    public static final String LOGIN_ID = "LOGIN_ID";

    // The user id of session and cookies key.
    public static final String USER_ID = "USER_ID";

    // The user name of session and cookie key.
    public static final String USER_NAME = "USER_NAME";

    public static final String LOGIN_USER = "LOGIN_USER";
    public static final String LOGIN_ROLE_LIST = "LOGIN_ROLE_LIST";

    // The SSO URL of session key.
    // If the APP should login, should redirect to this SSO URL
    public static final String PASSPORT_URL = "PASSPORT_URL";

    // The access URL of login success should be redirected.
    public static final String ACCESS_URL = "ACCESS_URL";

    public static final String REST_API_USER = "user";

    public static final String RESOURCE_CODE = "RESOURCE_CODE";

    public static final String SECURITY_USER_ID = "userID";

    public static final String SECURITY_USER_NAME = "userName";

    // The current active resource
    public static final String CURRENT_RESOURCE = "CURRENT_RESOURCE";
    // The current selected item of security resource session key
    public static final String CURRENT_ROOT_RESOURCE = "CURRENT_ROOT_RESOURCE";
    
    // The list of security resource list session key
    public static final String RESOURCE_LIST = "RESOURCE_LIST";

    // Key: ResourceURL
    // Value: ResourceDto
    public static final String RESOURCE_URL_MAP = "RESOURCE_URL_MAP";

    // Key: ResourceID
    // Value: ResourceDto
    public static final String RESOURCE_ID_MAP = "RESOURCE_ID_MAP";

    // Key: ResourceURL
    // Value: ResourceDto
    public static final String ROOT_RESOURCE_URL_MAP = "ROOT_RESOURCE_URL_MAP";

}
