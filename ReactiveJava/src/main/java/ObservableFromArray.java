import io.reactivex.Observable;

import java.util.stream.IntStream;

public class ObservableFromArray {
    /*public static void main(String[] args) {
        Integer[] arr = {100, 200, 300};
        Observable<Integer> source = Observable.fromArray(arr);
        source.subscribe(System.out::println);
    }*/
    /*public static void main(String[] args) {
        int[] arr = {100, 200, 300};
        Observable<int[]> source = Observable.fromArray(arr);
        source.subscribe(System.out::println);
    }*/
    public static void main(String[] args) {
        int[] arr = {400, 500, 600};
        Observable<Integer> src = Observable.fromArray(toIntegerArray(arr));
        src.subscribe(System.out::println);
    }
    private static Integer[] toIntegerArray(int[] intArray){
        return IntStream.of(intArray).boxed().toArray(Integer[]::new);
    }
}
