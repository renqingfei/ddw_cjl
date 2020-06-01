package com.example.ddw_cjl.entity;

import java.util.Date;
import java.util.Objects;

public class Order {//??????
	private String id;
	private Long order_no;
	private double total;
	private String status;//??
	private Date create_date;
	private int address_id;
	private int user_id;
	private String name;
	private String local;

	@Override
	public String toString() {
		return "Order{" +
				"id='" + id + '\'' +
				", order_no=" + order_no +
				", total=" + total +
				", status='" + status + '\'' +
				", create_date=" + create_date +
				", address_id=" + address_id +
				", user_id=" + user_id +
				", name='" + name + '\'' +
				", local='" + local + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Order order = (Order) o;
		return Double.compare(order.total, total) == 0 &&
				address_id == order.address_id &&
				user_id == order.user_id &&
				Objects.equals(id, order.id) &&
				Objects.equals(order_no, order.order_no) &&
				Objects.equals(status, order.status) &&
				Objects.equals(create_date, order.create_date) &&
				Objects.equals(name, order.name) &&
				Objects.equals(local, order.local);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, order_no, total, status, create_date, address_id, user_id, name, local);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getOrder_no() {
		return order_no;
	}

	public void setOrder_no(Long order_no) {
		this.order_no = order_no;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
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
}
