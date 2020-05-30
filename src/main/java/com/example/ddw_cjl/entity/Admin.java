package com.example.ddw_cjl.entity;

import java.util.Objects;

public class Admin {
	private int id;
	private String username;//�û���
	private String password;//����

	@Override
	public String toString() {
		return "Admin{" +
				"id=" + id +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Admin admin = (Admin) o;
		return id == admin.id &&
				Objects.equals(username, admin.username) &&
				Objects.equals(password, admin.password);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, username, password);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
