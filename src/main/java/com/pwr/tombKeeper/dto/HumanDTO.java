package com.pwr.tombKeeper.dto;

import java.io.Serializable;

public class HumanDTO implements Serializable {

	private static final long serialVersionUID = 4897122838403407339L;

	private String login;

	private String password;

	public HumanDTO(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setLogin(String login) {
		this.login = login;
	}

}
