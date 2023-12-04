package Task2;

public abstract class Publication {
    protected String title;
    protected int pages;
    protected int yearPublish;
    protected String author;
    protected double price;

    public Publication(String title, int pages, int yearPublish, String author, double price) {
        this.title = title;
        this.pages = pages;
        this.yearPublish = yearPublish;
        this.author = author;
        this.price = price;
    }

    public abstract TypePublication getType();

    public abstract boolean isMagazineAndMoreYearPublish(int yearPublish);

    public boolean isSameAuthor(Publication o) {
        return author.equals(o.author);
    }

    public abstract boolean hasMoreChapter(Publication o);

    public String getTitle() {
        return title;
    }

    public int getPages() {
        return pages;
    }

    public int getYearPublish() {
        return yearPublish;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public boolean inYear(int year) {
        return yearPublish == year;
    }
}
