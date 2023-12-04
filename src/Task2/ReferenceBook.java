package Task2;

import java.util.Comparator;
import java.util.List;

public class ReferenceBook extends Publication {
    private TypeField type;
    private List<Chapter> chapters;

    public ReferenceBook(String title, int pages, int yearPublish, String author, double price, TypeField type, List<Chapter> chapters) {
        super(title, pages, yearPublish, author, price);
        this.type = type;
        this.chapters = chapters;
    }

    @Override
    public TypePublication getType() {
        return TypePublication.REFERENCE_BOOK;
    }

    @Override
    public boolean isMagazineAndMoreYearPublish(int yearPublish) {
        return false;
    }

    @Override
    public boolean hasMoreChapter(Publication o) {
        return maxPagesOfChapter() > ((ReferenceBook) o).maxPagesOfChapter();
    }


    public int maxPagesOfChapter() {
        return chapters.stream().mapToInt(Chapter::getPages).max().orElse(0);
    }
}
