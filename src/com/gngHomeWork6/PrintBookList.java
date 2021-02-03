package com.gngHomeWork6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class PrintBookList {

    private static void printBooks(List<Book> bookList) {
        for(Book book : bookList) {
        	System.out.println("ーーーーーーーーーーーーーーーーー");
        	System.out.println(book);
        }
    	System.out.println("ーーーーーーーーーーーーーーーーー");
        System.out.println("Books : " + bookList.size() + "冊");
    	System.out.println("ーーーーーーーーーーーーーーーーー");
    }
    
	public static void main(String[] args) {
//		books.csvからデータを読んでbookListに入れる。
//		Book(title, writer, publisher, publishingDate, serialNumber, price)
		Scanner sc = new Scanner(System.in);
		String input = "";
		List<Book> bookList = new ArrayList<Book>();
        BufferedReader br = null;
        try{
            br = Files.newBufferedReader(Paths.get(System.getProperty("user.dir") + "\\db\\books.csv"));
            String line = "";
            while((line = br.readLine()) != null){
            	String[] cols = line.split(",");
            	int price = 0;
            	LocalDate date = null;
//            	項目の数を確認、各項目が存在するかを確認
        		if(cols.length == 6 && !cols[0].equals("") && // タイトル
        				!cols[3].equals("") &&
        				!cols[5].equals("")) {
        			if(cols[0].length() <= 200 && // タイトル２００文字まで
        					cols[1].length() <= 100 && // 著者を１００文字まで
        					cols[2].length() <= 100) { // 出版社を１００文字まで
	        			if(cols[3].split("/").length == 3 && // yyyy/M/d 形式を確認
	        					cols[4].replace("-", "").length() == 13 || cols[4].length() == 0) { // ISBN-13が13字を確認
	        				boolean isNum = true;
	        				try { // 値段と出版日の形式を確認
	        					price = Integer.parseInt(cols[5]);
	        					date = LocalDate.parse(cols[3], DateTimeFormatter.ofPattern("yyyy/M/d"));
	        				} catch(NumberFormatException e) {
	        					isNum = false;
	        				} catch(DateTimeParseException e) {
	        					isNum = false;
	        				}
	        				if(price > 0 && price <= 100000000 && isNum) {
	                			bookList.add(new Book(
	        					cols[0], cols[1], cols[2],
	        					date, cols[4], price));
	        				}
	        				
	        			}
        			}
        		}
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(br != null){
                    br.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        } // books.csvを読んでbookListに代入完了
        
        //출력
        printBooks(bookList);
    	System.out.print("1 ~ 3 : ");
    	input = sc.nextLine();
    	if(input.equals("1")){
    		Collections.sort(bookList, new Comparator<Book>() {
				@Override
				public int compare(Book o1, Book o2) {
					int returnValue = o2.getPublishingDate().compareTo(o1.getPublishingDate());
					if(returnValue == 0)
						returnValue = o1.getTitle().compareTo(o2.getTitle());
					return returnValue;
				}
    		});
            printBooks(bookList);
    	} else if(input.equals("2")) {
    		Collections.sort(bookList, new Comparator<Book>() {
				@Override
				public int compare(Book o1, Book o2) {
					int returnValue = new Integer(o1.getPrice()).compareTo(o2.getPrice());
					if(returnValue == 0)
						returnValue = o1.getTitle().compareTo(o2.getTitle());
					return returnValue;
				}
    		});
            printBooks(bookList);
    	} else if(input.equals("3")) {
    		Collections.sort(bookList, new Comparator<Book>() {
				@Override
				public int compare(Book o1, Book o2) {
					int returnValue = o1.getTitle().compareTo(o2.getTitle());
					return returnValue;
				}
    		});
            printBooks(bookList);
    	} else {
    		System.out.println("1 ~ 3の数字を入力してください。");
    	}
	}
}
