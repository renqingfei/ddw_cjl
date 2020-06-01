package com.example.ddw_cjl.entity;

import java.util.Date;
import java.util.Objects;

public class Item {//???????
	private String id;
	private int book_id;
	private String order_id;
	private int count;
	private Date create_date;
	private String name;
	private String cover;
	private double price;
	private double dprice;

	@Override
	public String toString() {
		return "Item{" +
				"id='" + id + '\'' +
				", book_id=" + book_id +
				", order_id='" + order_id + '\'' +
				", count=" + count +
				", create_date=" + create_date +
				", name='" + name + '\'' +
				", cover='" + cover + '\'' +
				", price=" + price +
				", dprice=" + dprice +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Item item = (Item) o;
		return book_id == item.book_id &&
				count == item.count &&
				Double.compare(item.price, price) == 0 &&
				Double.compare(item.dprice, dprice) == 0 &&
				Objects.equals(id, item.id) &&
				Objects.equals(order_id, item.order_id) &&
				Objects.equals(create_date, item.create_date) &&
				Objects.equals(name, item.name) &&
				Objects.equals(cover, item.cover);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, book_id, order_id, count, create_date, name, cover, price, dprice);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDprice() {
		return dprice;
	}

	public void setDprice(double dprice) {
		this.dprice = dprice;
	}
}
