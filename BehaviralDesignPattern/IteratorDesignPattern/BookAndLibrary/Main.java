package IteratorDesignPattern.BookAndLibrary;

import java.util.*;

interface Iterator {
  boolean hasNext();

  Object next();

  Object first();
}

class Book {
  String bookName;
  Double price;

  Book(String bookName, Double price) {
    this.bookName = bookName;
    this.price = price;
  }

  public String getBookName() {
    return bookName;
  }

  public Double getPrice() {
    return price;
  }
}

class BookIterator implements Iterator {
  private List<Book> bookList = new ArrayList<>();
  int index;

  BookIterator(List<Book> list) {
    this.bookList = list;
    this.index = 0;
  }

  public Object first() {
    if (bookList.isEmpty()) {
      return null;
    }
    index = 0;
    return bookList.get(index);
  }

  public boolean hasNext() {
    return index < bookList.size();
  }

  public Object next() {

    if (hasNext()) {
      return bookList.get(index++);
    }

    return null;
  }

}

interface Aggregate {
  Iterator createIterator();
}

class Library implements Aggregate {

  private List<Book> list = new ArrayList<>();

  Library(List<Book> list) {
    this.list = list;
  }

  public Iterator createIterator() {
    return new BookIterator(list);
  }
}

public class Main {
  public static void main(String[] args) {

    List<Book> list = new ArrayList<>();
    list.add(new Book("C in depth", 345.9));
    list.add(new Book("Hets in Java ", 890.99));
    list.add(new Book("Principle Of Electornics", 500.11));

    Library library = new Library(list);
    Iterator itr = library.createIterator();

    while (itr.hasNext()) {
      Book book = (Book) itr.next();
      System.out.println("Book name : " + book.getBookName() + "and Book price : " + book.getPrice());
    }
  }
}