package com.gngHomeWork5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class PrintBookList {

	public static void main(String[] args) {
//		books.csvからデータを読んでbookListに入れる。
//		Book(title, writer, publisher, publishingDate, serialNumber, price)
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
        		if(cols.length == 6 && !cols[0].equals("") &&
        				!cols[1].equals("") &&
        				!cols[2].equals("") &&
        				!cols[3].equals("") &&
        				!cols[4].equals("") &&
        				!cols[5].equals("")) {
        			if(cols[3].split("/").length == 3 && // yyyy/M/d 形式を確認
        					cols[4].replace("-", "").length() == 13) { // ISBN-13が13字を確認
        				boolean isNum = true;
        				try { // 値段と出版日の形式を確認
        					price = Integer.parseInt(cols[5]);
        					date = LocalDate.parse(cols[3], DateTimeFormatter.ofPattern("yyyy/M/d"));
        				} catch(NumberFormatException e) {
        					isNum = false;
        				} catch(DateTimeParseException e) {
        					isNum = false;
        				}
        				if(price > 0 && isNum) {
                			bookList.add(new Book(
        					cols[0], cols[1], cols[2],
        					date, cols[4], price));
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
        for(Book book : bookList) {
        	System.out.println("ーーーーーーーーーーーーーーーーー");
        	System.out.println(book);
        }
    	System.out.println("ーーーーーーーーーーーーーーーーー");
        System.out.println("Books : " + bookList.size() + "冊");
    	System.out.println("ーーーーーーーーーーーーーーーーー");
	}

}
