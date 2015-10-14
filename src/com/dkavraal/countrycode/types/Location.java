package com.dkavraal.countrycode.types;

public class Location {
	private String shortName = "N/A";
	private String name = "N/A                 ";
	
	public Location(String shortName, String name) {
		this.shortName = shortName;
		this.name = name;
	}
	
	public Location(int shortCode, String name) {
		this.shortName = "" + shortCode;
		this.name = name;
	}
	
	public String getShortName() {
		return shortName;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	
	public void setShortName(int shortCode) {
		this.shortName = "" + shortCode;
	}
	
	public void set(String shortName, String name) {
		this.name = name;
		this.shortName = shortName;
	}
	
	public int getShortCode() {
		return Integer.parseInt(shortName);
	}
	
	public String toString() {
		return "[" + shortName + "] " + name;
	}
}
