package Task2;

import java.util.*;
import java.util.stream.Collectors;

public class PublicationManager {
    private List<Publication> publications;

    public PublicationManager(List<Publication> publications) {
        this.publications = publications;
    }

    public double totalPrice() {
        return publications.stream().mapToDouble(Publication::getPrice).sum();
    }

    public Publication maxChapter() {
        return publications
                .stream()
                .filter(p -> p.getType() == TypePublication.REFERENCE_BOOK)
                .max(Comparator.comparingInt(p -> ((ReferenceBook) p).maxPagesOfChapter()))
                .orElse(null);
    }

    public Publication findMagazineByName(String name) {
        return publications
                .stream()
                .filter(p -> p.getType() == TypePublication.MAGAZINE)
                .map(p -> (Magazine) p)
                .filter(m -> m.isSameName(name))
                .findFirst()
                .orElse(null);
    }

    public List<Publication> getMagazineByYear(int year) {
        return publications
                .stream()
                .filter(publication -> publication.getType() == TypePublication.MAGAZINE)
                .filter(publication -> publication.inYear(year))
                .collect(Collectors.toList());
    }

    public List<Publication> sortByTitleAndYearDesc() {
        return new ArrayList<>(publications)
                .stream()
                .sorted(
                        Comparator.comparing(Publication::getTitle)
                                .thenComparing(Publication::getYearPublish)
                                .reversed())
                .collect(Collectors.toList());
    }

    public Map<Integer, Integer> countPublicationsByYear() {
        /*
        Map<Integer, Integer> map = new HashMap<>();
        publications.forEach(publication -> map.put(publication.getYearPublish(), map.getOrDefault(publication.getYearPublish(), 0) + 1));
        return map;
        */
        return publications
                .stream()
                .collect(Collectors.toMap(Publication::getYearPublish, p -> 1, Integer::sum, HashMap::new));
    }

}
