package com.shubham.student.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="students")
@DynamicInsert
@DynamicUpdate
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="sId")
	private int sId;
	@Column(name="sName")
	private String sName;
	@Column(name="sBranch")
	private String sBranch;
	@Column(name="sEmail")
	private String sEmail;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsBranch() {
		return sBranch;
	}
	public void setsBranch(String sBranch) {
		this.sBranch = sBranch;
	}
	public String getsEmail() {
		return sEmail;
	}
	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}
	@Override
	public String toString() {
		return "Student [sId=" + sId + ", sName=" + sName + ", sBranch=" + sBranch + ", sEmail=" + sEmail + "]";
	}
	

}
