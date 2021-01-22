package com.EP_Practical.Bean;

public class StudentBean {
	
	private int regno;
	private String name;
	private String email;
	public StudentBean(int regno,String name,String email) {
		if(regno >= 0 && name !=null && email != null) {
			this.setRegno(regno);
			this.setName(name);
			this.setEmail(email);
		}
	}
	public int getRegno() {
		return regno;
	}
	public void setRegno(int regno) {
		this.regno = regno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
