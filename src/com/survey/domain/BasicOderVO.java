package com.survey.domain;

public class BasicOderVO {
	
	
	private String name;
	private int value;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "BasicOder [name=" + name + ", value=" + value + "]";
	}
	
	

}
