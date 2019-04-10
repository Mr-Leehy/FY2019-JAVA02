package com.neudeu.Admin;

public class Student {
	public int id;
	public String name;
	public int age;
	public int sorce;	
	public  Student(int id, String name,int age,int sorce){this.id=id;this.name=name;this.age=age;this.sorce = sorce;}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getSorce() {
		return sorce;
	}
	public void setSorce(int sorce) {
		this.sorce = sorce;
	}
}
