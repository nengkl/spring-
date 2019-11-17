package top.neng.entity;

import java.io.Serializable;

public class Template implements Serializable{
	private int id;
	private String name;
	private int jdbc;
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
	public int getJdbc() {
		return jdbc;
	}
	public void setJdbc(int jdbc) {
		this.jdbc = jdbc;
	}
	@Override
	public String toString() {
		return "template [id=" + id + ", name=" + name + ", jdbc=" + jdbc + "]";
	}
	
}
