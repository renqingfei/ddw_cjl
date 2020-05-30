package com.example.ddw_cjl.entity;

import java.sql.Date;
import java.util.Objects;

public class User {
	private int id;//�û�id
	private String email;//�û�����
	private String	password;//����
	private String nickname;//�ǳ�
	private String	status;//״̬
	private String	code;//������
	private Date create_date;//����ʱ��

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				", nickname='" + nickname + '\'' +
				", status='" + status + '\'' +
				", code='" + code + '\'' +
				", create_date=" + create_date +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return id == user.id &&
				Objects.equals(email, user.email) &&
				Objects.equals(password, user.password) &&
				Objects.equals(nickname, user.nickname) &&
				Objects.equals(status, user.status) &&
				Objects.equals(code, user.code) &&
				Objects.equals(create_date, user.create_date);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, email, password,  nickname, status, code, create_date);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
}
