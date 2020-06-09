package com.tayadetech.model;

public class ProductionCompany {

	public Integer id;
	public Object logoPath;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Object getLogoPath() {
		return logoPath;
	}
	public void setLogoPath(Object logoPath) {
		this.logoPath = logoPath;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOriginCountry() {
		return originCountry;
	}
	public void setOriginCountry(String originCountry) {
		this.originCountry = originCountry;
	}
	public String name;
	public String originCountry;

}
