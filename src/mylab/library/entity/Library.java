package mylab.library.entity;

import java.util.ArrayList;
import java.util.List;

public class Library {
	private String name;
	private List<Book> books;
	
	
	public Library(String name) {
		this.name = name;
        this.books = new ArrayList<>();
		
	}
	
	public void addBook(Book book) {
		books.add(book);
	}
	
	public Book findBookByTitle(String title) {
	    for (Book book : books) {
	        if (book.getTitle().equalsIgnoreCase(title)) {
	            return book;
	        }
	    }
	    return null;
	}

	public List<Book> findBooksByAuthor(String author) {
	    List<Book> result = new ArrayList<>();
	    for (Book book : books) {
	        if (book.getAuthor().equalsIgnoreCase(author)) {
	            result.add(book);
	        }
	    }
	    return result;
	}

	// ISBN으로 도서 찾기
	public Book findBookByISBN(String isbn) {
	    for (Book book : books) {
	        if (book.getIsbn().equals(isbn)) {
	            return book;
	        }
	    }
	    return null;
	}

	// ISBN으로 도서 대출
	public boolean checkOutBook(String isbn) {
	    Book book = findBookByISBN(isbn);
	    if (book != null) {
	        return book.checkOut();
	    } else {
	        return false;
	    }
	}

	
	public void returnBook(String isbn) {
        Book book = findBookByISBN(isbn);
        if (book != null) {
            book.returnBook();
        }
    }

    // 대출 가능한 도서 목록 반환
    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }

    // 전체 도서 목록 반환
    public List<Book> getAllBooks() {
        return books;
    }

    // 전체 도서 수
    public int getTotalBooks() {
        return books.size();
    }

    // 대출 가능한 도서 수
    public int getAvailableBooksCount() {
        int count = 0;
        for (Book book : books) {
            if (book.isAvailable()) {
                count++;
            }
        }
        return count;
    }

    // 대출 중인 도서 수
    public int getBorrowedBooksCount() {
        return getTotalBooks() - getAvailableBooksCount();
    }

    // 도서관 이름 반환
    public String getName() {
        return name;
    }
}
