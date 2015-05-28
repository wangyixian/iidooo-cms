package com.iidooo.core.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LDAPHelp extends Properties {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7662647727031797932L;

	private String url;
	private String user;
	private String password;

	private static LDAPHelp instance;

	public String getUrl() {
		return url;
	}

	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}

	public static LDAPHelp getInstance() throws IOException {
		if (instance == null) {
			instance = new LDAPHelp();
		}
		return instance;
	}

	private LDAPHelp() throws IOException {
		try {
			InputStream is = getClass().getResourceAsStream("/ldap.properties");
			load(is);
			url = this.getProperty("url");
			user = this.getProperty("user");
			password = this.getProperty("password");
		} catch (Exception e) {
		}
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		System.out.println(LDAPHelp.getInstance().getUrl());
		System.out.println(LDAPHelp.getInstance().getUser());
		System.out.println(LDAPHelp.getInstance().getPassword());
	}

}
