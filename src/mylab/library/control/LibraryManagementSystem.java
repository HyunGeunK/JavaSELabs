package mylab.library.control;

import mylab.library.entity.Book;
import mylab.library.entity.Library;
import java.util.List;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library("중앙 도서관");

        addSampleBooks(library);
        printLibraryStatus(library);

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

    private static void printLibraryStatus(Library library) {
        System.out.println("===== " + library.getName() + " =====");
        System.out.println("전체 도서 수: " + library.getTotalBooks());
        System.out.println("대출 가능 도서 수: " + library.getAvailableBooksCount());
        System.out.println("대출 중인 도서 수: " + library.getBorrowedBooksCount());
        System.out.println();
    }

    private static void testFindBook(Library library) {
        System.out.println("===== 도서 검색 테스트 =====");

        Book foundByTitle = library.findBookByTitle("자바의 정석");
        System.out.println("제목으로 검색 결과:");
        System.out.println(foundByTitle);
        System.out.println();

        List<Book> booksByAuthor = library.findBooksByAuthor("Robert C. Martin");
        System.out.println("저자로 검색 결과:");
        for (Book book : booksByAuthor) {
            System.out.println(book);
        }
        System.out.println();
    }

    private static void testCheckOut(Library library) {
        System.out.println("===== 도서 대출 테스트 =====");
        String isbn = "978-89-01-14077-4"; // 자바의 정석

        boolean success = library.checkOutBook(isbn);
        System.out.println(success ? "도서 대출 성공!" : "도서 대출 실패!");

        Book book = library.findBookByISBN(isbn);
        System.out.println("대출된 도서 정보:");
        System.out.println(book);

        printLibraryStatus(library);
    }

    private static void testReturn(Library library) {
        System.out.println("===== 도서 반납 테스트 =====");
        String isbn = "978-89-01-14077-4";

        boolean success = library.returnBook(isbn);
        System.out.println(success ? "도서 반납 성공!" : "도서 반납 실패!");

        Book book = library.findBookByISBN(isbn);
        System.out.println("반납된 도서 정보:");
        System.out.println(book);

        printLibraryStatus(library);
    }

    private static void displayAvailableBooks(Library library) {
        System.out.println("===== 대출 가능한 도서 목록 =====");
        List<Book> books = library.getAvailableBooks();
        for (Book book : books) {
            System.out.println(book);
            System.out.println("------------------------");
        }
    }
}
