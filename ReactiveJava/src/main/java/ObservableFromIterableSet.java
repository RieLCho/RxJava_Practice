import java.util.HashSet;
import io.reactivex.*;
import java.util.Set;

public class ObservableFromIterableSet {
    public static void main(String[] args) {
        Set<String> cities = new HashSet<>();
        cities.add("Seoul");
        cities.add("London");
        cities.add("Tokyo");
        Observable<String> src = Observable.fromIterable(cities);
        src.subscribe(System.out::println);
    }

}
