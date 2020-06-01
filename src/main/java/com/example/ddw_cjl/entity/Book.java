package com.example.ddw_cjl.entity;

import java.util.Date;
import java.util.Objects;

public class Book {
	private int id;
	private String name;//名称
	private String author;//作者
	private String cover;//封面
	private String press;//出版社
	private Date press_date;//出版时间
	private String edition;//版次
	private Date print_date;//印刷时间
	private String impression;//印刷次数
	private String isbn;//isbn
	private int word_num;//字数
	private int page_num;//页数
	private String sizes;//开本
	private String paper;//纸张
	private String pack;//包装
	private double price;//价格
	private double dprice;//当当价
	private Date create_date;//添加时间
	private String editor_recommend;//编辑推荐
	private String content_abstract;//内容简介
	private String author_abstract;//作者简介
	private String director;//目录
	private String media_commentary;//媒体评论
	private String category_id;//分类id(外键)
	private int sale;//销量
	private int stock;//库存

	@Override
	public String toString() {
		return "Book{" +
				"id=" + id +
				", name='" + name + '\'' +
				", author='" + author + '\'' +
				", cover='" + cover + '\'' +
				", press='" + press + '\'' +
				", press_date=" + press_date +
				", edition='" + edition + '\'' +
				", print_date=" + print_date +
				", impression='" + impression + '\'' +
				", isbn='" + isbn + '\'' +
				", word_num=" + word_num +
				", page_num=" + page_num +
				", sizes='" + sizes + '\'' +
				", paper='" + paper + '\'' +
				", pack='" + pack + '\'' +
				", price=" + price +
				", dprice=" + dprice +
				", create_date=" + create_date +
				", editor_recommend='" + editor_recommend + '\'' +
				", content_abstract='" + content_abstract + '\'' +
				", author_abstract='" + author_abstract + '\'' +
				", director='" + director + '\'' +
				", media_commentary='" + media_commentary + '\'' +
				", category_id='" + category_id + '\'' +
				", sale=" + sale +
				", stock=" + stock +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Book book = (Book) o;
		return id == book.id &&
				word_num == book.word_num &&
				page_num == book.page_num &&
				Double.compare(book.price, price) == 0 &&
				Double.compare(book.dprice, dprice) == 0 &&
				sale == book.sale &&
				stock == book.stock &&
				Objects.equals(name, book.name) &&
				Objects.equals(author, book.author) &&
				Objects.equals(cover, book.cover) &&
				Objects.equals(press, book.press) &&
				Objects.equals(press_date, book.press_date) &&
				Objects.equals(edition, book.edition) &&
				Objects.equals(print_date, book.print_date) &&
				Objects.equals(impression, book.impression) &&
				Objects.equals(isbn, book.isbn) &&
				Objects.equals(sizes, book.sizes) &&
				Objects.equals(paper, book.paper) &&
				Objects.equals(pack, book.pack) &&
				Objects.equals(create_date, book.create_date) &&
				Objects.equals(editor_recommend, book.editor_recommend) &&
				Objects.equals(content_abstract, book.content_abstract) &&
				Objects.equals(author_abstract, book.author_abstract) &&
				Objects.equals(director, book.director) &&
				Objects.equals(media_commentary, book.media_commentary) &&
				Objects.equals(category_id, book.category_id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, author, cover, press, press_date, edition, print_date, impression, isbn, word_num, page_num, sizes, paper, pack, price, dprice, create_date, editor_recommend, content_abstract, author_abstract, director, media_commentary, category_id, sale, stock);
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getPress() {
		return press;
	}

	public void setPress(String press) {
		this.press = press;
	}

	public Date getPress_date() {
		return press_date;
	}

	public void setPress_date(Date press_date) {
		this.press_date = press_date;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public Date getPrint_date() {
		return print_date;
	}

	public void setPrint_date(Date print_date) {
		this.print_date = print_date;
	}

	public String getImpression() {
		return impression;
	}

	public void setImpression(String impression) {
		this.impression = impression;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getWord_num() {
		return word_num;
	}

	public void setWord_num(int word_num) {
		this.word_num = word_num;
	}

	public int getPage_num() {
		return page_num;
	}

	public void setPage_num(int page_num) {
		this.page_num = page_num;
	}

	public String getSizes() {
		return sizes;
	}

	public void setSizes(String sizes) {
		this.sizes = sizes;
	}

	public String getPaper() {
		return paper;
	}

	public void setPaper(String paper) {
		this.paper = paper;
	}

	public String getPack() {
		return pack;
	}

	public void setPack(String pack) {
		this.pack = pack;
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

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public String getEditor_recommend() {
		return editor_recommend;
	}

	public void setEditor_recommend(String editor_recommend) {
		this.editor_recommend = editor_recommend;
	}

	public String getContent_abstract() {
		return content_abstract;
	}

	public void setContent_abstract(String content_abstract) {
		this.content_abstract = content_abstract;
	}

	public String getAuthor_abstract() {
		return author_abstract;
	}

	public void setAuthor_abstract(String author_abstract) {
		this.author_abstract = author_abstract;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getMedia_commentary() {
		return media_commentary;
	}

	public void setMedia_commentary(String media_commentary) {
		this.media_commentary = media_commentary;
	}

	public String getCategory_id() {
		return category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}

	public int getSale() {
		return sale;
	}

	public void setSale(int sale) {
		this.sale = sale;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
}
	

