package mylab.library.entity;

public class Book {
	private String title;
	private String author;
	private String isbn;
	private int publishYear;
	private boolean isAvailable;
	
	public Book() {
		this.isAvailable = isAvailable;
	}

	public Book(String title, String author, String isbn, int publishYear) {
	    this();  // 기본 생성자 호출 → isAvailable = true 포함됨
	    this.title = title;
	    this.author = author;
	    this.isbn = isbn;
	    this.publishYear = publishYear;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	public boolean checkOut() {
		if(isAvailable) {
			isAvailable = false;
			return true;
		}
		return false;
	}
	
	public void returnBook() {
		isAvailable = true;
	}
	
	@Override
	public String toString() {
        return "제목: " + title + 
             ", 저자: " + author + 
             ", ISBN: " + isbn + 
             ", 출판년도: " + publishYear + 
             ", 대출 가능 여부: " + (isAvailable ? "가능" : "불가능");
    }
	
}
