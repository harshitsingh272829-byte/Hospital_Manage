package com.hms;

public class Patient {
	    private int id;
	    private String name;
	    private int age;
	    private String disease;

	    public Patient(int id, String name, int age, String disease) {
	        this.id = id;
	        this.name = name;
	        this.age = age;
	        this.disease = disease;
	    }

	    public Patient(String name, int age, String disease) {
	        this.name = name;
	        this.age = age;
	        this.disease = disease;
	    }

	    // Getters
	    public int getId() { return id; }
	    public String getName() { return name; }
	    public int getAge() { return age; }
	    public String getDisease() { return disease; }

}
