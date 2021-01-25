package com.gngHomeWork5;

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

	@Override
	public String toString() {
		String printString = String.format("%s\n著：%s\n出版：%s(%s)\nISBN-13：%s\n値段：%,d円",
				title, writer, publisher, publishingDate.format(DateTimeFormatter.ofPattern("yyyy年M月d日")), serialNumber.replace("-", ""), price);
		return printString;
	}
	
	
}
