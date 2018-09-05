package com.hx.bean;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class MyFile implements Serializable {
	private static final long serialVersionUID = 3606609947929823121L;
	private String description;
	private MultipartFile file;
	
	public MyFile() {
		super();
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
