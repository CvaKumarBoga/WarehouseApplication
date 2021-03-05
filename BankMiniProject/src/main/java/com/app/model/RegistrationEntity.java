package com.app.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class RegistrationEntity {
	@Id
	@GeneratedValue
	@Column(name = "regId")
	private Integer id;
	private String name;
	private String photoName;
	@Lob
	private byte[] photo;
	private String emailId;
	private Long phoneNo;
	private String dob;
	private String address;
	private String status;
	public RegistrationEntity() {
		super();
	}
	public RegistrationEntity(Integer id, String name, String photoName, byte[] photo, String emailId, Long phoneNo,
			String dob, String address, String status) {
		super();
		this.id = id;
		this.name = name;
		this.photoName = photoName;
		this.photo = photo;
		this.emailId = emailId;
		this.phoneNo = phoneNo;
		this.dob = dob;
		this.address = address;
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhotoName() {
		return photoName;
	}
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "RegistrationEntity [id=" + id + ", name=" + name + ", photoName=" + photoName + ", photo="
				+ Arrays.toString(photo) + ", emailId=" + emailId + ", phoneNo=" + phoneNo + ", dob=" + dob
				+ ", address=" + address + ", status=" + status + "]";
	}
	
}
