package Task3;

import java.util.*;
import java.util.stream.Collectors;

public class Library {
    private String name;
    private List<Book> books;

    public Library(String name, List<Book> books) {
        this.name = name;
        this.books = books;
    }

    public Book getOldestBook() {
        return books
                .stream()
                .min(Comparator.comparing(Book::getPrice))
                .orElse(null);
    }

    public Map<Integer, List<Book>> getBooksByYears() {
        return books
                .stream()
                .collect(Collectors.groupingBy(Book::getYear));
    }

    public Set<Book> findBooks(String authorName, int year) {
        return books
                .stream()
                .filter(b -> b.getYear() == year)
                .filter(b -> b.getAuthors().stream().anyMatch(a -> a.getName().equals(authorName)))
                .sorted(Comparator.comparing(Book::getTitle))
                .collect(Collectors.toCollection(TreeSet::new));
    }
}
