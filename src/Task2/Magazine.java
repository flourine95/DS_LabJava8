package Task2;

public class Magazine extends Publication {
    private String name;

    public Magazine(String title, int pages, int yearPublish, String author, double price, String name) {
        super(title, pages, yearPublish, author, price);
        this.name = name;
    }


    @Override
    public TypePublication getType() {
        return TypePublication.MAGAZINE;
    }

    @Override
    public boolean isMagazineAndMoreYearPublish(int yearPublish) {
        return this.yearPublish >= yearPublish;
    }

    @Override
    public boolean hasMoreChapter(Publication o) {
        return false;
    }

    public boolean isSameName(String name) {
        return this.name.equals(name);
    }
}
