package com.portfolioproject.model;

public class Book {
    private String bookid;
    private String title;
    private String price;
    
    public Book(String bookId,String title,double price)
    {
    	this.bookid=bookid;
    	this.title=title;
    	this.price=price;
    	
    }
    
    public String getBookid() {                                                                                                                                                                                                                                                                                                                                                                                                                                                          
    	return bookid;
    }
    
    public void setBookid(String bookid) {
    	this.bookid = bookid;
    }
    
    public String getTitle() {
    	return title;
    }
    
    public void setTitle(String title) {
    	this.title = title;
    }
    
    public double getPrice() {
    	return price;
    }
    
    public void setPrice(double price) {
    	this.price = price;
    }
  
    
}
