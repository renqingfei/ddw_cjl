package com.example.ddw_cjl.entity;

import java.util.Objects;

public class Address {
	private int id;
	private String name;
	private String local;
	private String phone;
	private String zip_code;
	private String user_id;

	@Override
	public String toString() {
		return "Address{" +
				"id=" + id +
				", name='" + name + '\'' +
				", local='" + local + '\'' +
				", phone='" + phone + '\'' +
				", zip_code='" + zip_code + '\'' +
				", user_id='" + user_id + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Address address = (Address) o;
		return id == address.id &&
				Objects.equals(name, address.name) &&
				Objects.equals(local, address.local) &&
				Objects.equals(phone, address.phone) &&
				Objects.equals(zip_code, address.zip_code) &&
				Objects.equals(user_id, address.user_id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, local, phone, zip_code, user_id);
	}

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

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getZip_code() {
		return zip_code;
	}

	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
}
