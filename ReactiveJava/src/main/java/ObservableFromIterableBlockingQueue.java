import io.reactivex.*;
import common.Order;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ObservableFromIterableBlockingQueue {
    public static void main(String[] args) {
        BlockingQueue<Order> orderQueue = new ArrayBlockingQueue<>(100);
        orderQueue.add(new Order("ORD-1"));
        orderQueue.add(new Order("ORD-2"));
        orderQueue.add(new Order("ORD-3"));

        Observable<Order> source = Observable.fromIterable(orderQueue);
        source.subscribe(order -> System.out.println(order.getId()));
    }
}


