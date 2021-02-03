package com.gngHomeWork6;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Book {
	private String title;
	private String writer;
	private String publisher;
	private LocalDate publishingDate;
	private String serialNumber;
	private int price;
	
	public Book() {
		super();
	}

	public Book(String title, String writer, String publisher, LocalDate publishingDate, String serialNumber,
			int price) {
		super();
		this.title = title;
		this.writer = writer;
		this.publisher = publisher;
		this.publishingDate = publishingDate;
		this.serialNumber = serialNumber;
		this.price = price;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public LocalDate getPublishingDate() {
		return publishingDate;
	}
	public void setPublishingDate(LocalDate publishingDate) {
		this.publishingDate = publishingDate;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		String printString = String.format("%s\n著：%s\n出版：%s(%s)\nISBN-13：%s\n値段：%,d円",
				title, writer, publisher, publishingDate.format(DateTimeFormatter.ofPattern("yyyy年M月d日")), serialNumber.replace("-", ""), price);
		return printString;
	}
}
