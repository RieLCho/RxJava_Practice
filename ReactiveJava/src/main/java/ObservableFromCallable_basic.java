import io.reactivex.Observable;
import java.util.concurrent.Callable;

public class ObservableFromCallable_basic {
    public static void main(String[] args) {
        Callable<String> callable = () ->{
            Thread.sleep(1000);
            return "Hello Callable";
        };
        Observable<String> src = Observable.fromCallable(callable);
        src.subscribe(System.out::println);
    }
}
