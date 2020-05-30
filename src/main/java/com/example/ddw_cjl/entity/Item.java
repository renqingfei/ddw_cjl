package com.example.ddw_cjl.entity;

import java.util.Date;
import java.util.Objects;

public class Item {//???????
	private String id;
	private int book_id;
	private String order_id;
	private int count;
	private Date create_date;
	private Book book;
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
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, book_id, order_id, count, create_date, book);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Item item = (Item) o;
		return book_id == item.book_id &&
				count == item.count &&
				Objects.equals(id, item.id) &&
				Objects.equals(order_id, item.order_id) &&
				Objects.equals(create_date, item.create_date) &&
				Objects.equals(book, item.book);
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", book_id=" + book_id + ", order_id="
				+ order_id + ", count=" + count + ", create_date="
				+ create_date + ", book=" + book + "]";
	}
	public Item(String id, int book_id, String order_id, int count,
			Date create_date, Book book) {
		super();
		this.id = id;
		this.book_id = book_id;
		this.order_id = order_id;
		this.count = count;
		this.create_date = create_date;
		this.book = book;
	}
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
