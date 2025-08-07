package mylab.library.control;

import mylab.library.entity.Book;
import mylab.library.entity.Library;

import java.util.List;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library("신한대학교 중앙도서관");

        addSampleBooks(library);

        System.out.println("=== 도서관 전체 정보 ===");
        for (Book book : library.getAllBooks()) {
            System.out.println(book);
        }

        testFindBook(library);
        testCheckOut(library);
        testReturn(library);
        displayAvailableBooks(library);
    }

    private static void addSampleBooks(Library library) {
        library.addBook(new Book("자바 프로그래밍", "김자바", "978-89-01-12345-6", 2022));
        library.addBook(new Book("객체지향의 사실과 오해", "조영호", "978-89-01-67890-1", 2015));
        library.addBook(new Book("Clean Code", "Robert C. Martin", "978-0-13-235088-4", 2008));
        library.addBook(new Book("Effective Java", "Joshua Bloch", "978-0-13-468599-1", 2018));
        library.addBook(new Book("Head First Java", "Kathy Sierra", "978-0-596-00920-5", 2005));
        library.addBook(new Book("자바의 정석", "남궁성", "978-89-01-14077-4", 2019));
    }

    private static void testFindBook(Library library) {
        System.out.println("\n[도서 검색 테스트]");
        Book book = library.findBookByTitle("Clean Code");
        if (book != null) {
            System.out.println("제목으로 검색됨: " + book);
        } else {
            System.out.println("제목으로 검색 실패");
        }

        List<Book> booksByAuthor = library.findBooksByAuthor("김자바");
        System.out.println("저자 '김자바'의 도서:");
        for (Book b : booksByAuthor) {
            System.out.println(b);
        }
    }

    private static void testCheckOut(Library library) {
        System.out.println("\n[도서 대출 테스트]");
        String isbn = "978-0-13-235088-4"; // Clean Code
        boolean success = library.checkOutBook(isbn);
        System.out.println(success ? "대출 성공" : "대출 실패");

        success = library.checkOutBook(isbn);
        System.out.println(success ? "대출 성공" : "이미 대출된 도서");
    }

    private static void testReturn(Library library) {
        System.out.println("\n[도서 반납 테스트]");
        String isbn = "978-0-13-235088-4";
        library.returnBook(isbn);
        System.out.println("도서 반납 완료");
    }

    private static void displayAvailableBooks(Library library) {
        System.out.println("\n[대출 가능한 도서 목록]");
        List<Book> availableBooks = library.getAvailableBooks();
        for (Book book : availableBooks) {
            System.out.println(book);
        }

        System.out.println("\n총 도서 수: " + library.getTotalBooks());
        System.out.println("대출 가능 도서 수: " + library.getAvailableBooksCount());
        System.out.println("대출 중인 도서 수: " + library.getBorrowedBooksCount());
    }
}
