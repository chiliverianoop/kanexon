package com.kanexon.ngo.model;

public class NgoBaseModel {

	private String ngoUniqueId;
	private String ngoName;
	private String ngoContactName;
	private String ngoEmail;
	private boolean adult;
	private String ngoPhone;
	private String password;
	
	public String getNgoUniqueId() {
		return ngoUniqueId;
	}
	public void setNgoUniqueId(String ngoUniqueId) {
		this.ngoUniqueId = ngoUniqueId;
	}
	public String getNgoName() {
		return ngoName;
	}
	public void setNgoName(String ngoName) {
		this.ngoName = ngoName;
	}
	public String getNgoContactName() {
		return ngoContactName;
	}
	public void setNgoContactName(String ngoContactName) {
		this.ngoContactName = ngoContactName;
	}
	public String getNgoEmail() {
		return ngoEmail;
	}
	public void setNgoEmail(String ngoEmail) {
		this.ngoEmail = ngoEmail;
	}
	public boolean isAdult() {
		return adult;
	}
	public void setAdult(boolean adult) {
		this.adult = adult;
	}
	public String getNgoPhone() {
		return ngoPhone;
	}
	public void setNgoPhone(String ngoPhone) {
		this.ngoPhone = ngoPhone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
