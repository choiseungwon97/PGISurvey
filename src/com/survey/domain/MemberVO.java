package com.survey.domain;

public class MemberVO {

	/**
	CREATE TABLE MIS.TB_MEMBER (
			  ID          VARCHAR2(250)     NOT NULL, 
			  PASSWORD    VARCHAR2(250)     NOT NULL, 
			  IDNUMBER    NUMBER                NULL, 
			  GENDER      CHAR(1)          DEFAULT 'M'           NOT NULL, 
			  AGE         NUMBER                NULL, 
			  ETHNICBG    NUMBER                NULL, 
			  MAJOR       VARCHAR2(250)         NULL, 
			  JOB         VARCHAR2(250)         NULL, 
			  FJOB        VARCHAR2(250)         NULL, 
			  MJOB        VARCHAR2(250)         NULL
			)
	**/
	
	
	private String id;
	private String password;
	private String firstName;
	private String lastName;
	private int idNumber;
	private char gender;
	private int age;
	private int ethnicBg;
	private String major;
	private String job;
	private String fJob;
	private String mJob;
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String name) {
		this.firstName = name;
	}
	public int getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getEthnicBg() {
		return ethnicBg;
	}
	public void setEthnicBg(int ethnicBg) {
		this.ethnicBg = ethnicBg;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getfJob() {
		return fJob;
	}
	public void setfJob(String fJob) {
		this.fJob = fJob;
	}
	public String getmJob() {
		return mJob;
	}
	public void setmJob(String mJob) {
		this.mJob = mJob;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", password=" + password + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", idNumber=" + idNumber + ", gender=" + gender + ", age=" + age + ", ethnicBg=" + ethnicBg
				+ ", major=" + major + ", job=" + job + ", fJob=" + fJob + ", mJob=" + mJob + "]";
	}
	
	
	
	

}
