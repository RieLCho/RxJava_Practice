import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.functions.Consumer;

public class ObservableCreateExample {
    public static void main(String[] args){
        // cold type Observable
        Observable<Integer> source = Observable.create(
                (ObservableEmitter<Integer> emitter) -> {
                    emitter.onNext(100);
                    emitter.onNext(200);
                    emitter.onNext(300);
                    emitter.onComplete();
                }
        );
        // 1. 메서드 레퍼런스
        //source.subscribe(System.out::println);
        /*
            System.out::println과 같은 형태를 자바 8에서 메서드 레퍼런스라고 한다.
            리액티브 프로그래밍에서는 앞서 설명한 람다 표현식과 메서드 레퍼런스를 사용할 때 다음 우선 순위를 고려하여 사용 여부를 판단
            1. 메서드 레퍼런스로 축약할 수 있는지 확인
            2. 람다 표현식을 사용할 수 있는지 확인
            3. 1번과 2번을 활용할 수 없으면 익명 개체나 멤버 변수로 표현
         */
        // 2. 람다 표현식
        // source.subscribe(data -> System.out.println("Result : " + data));
        // 3. 익명 객체 활용
        source.subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                System.out.println("Result : " + integer);
            }
        });
        /*
           Observable.create()을 사용할 때 주의할 점
           RxJava의 javadoc에 따르면 RxJava에 익숙한 사용자만 활용하도록 권고
           1. Observable이 구독 해지 (dispose) 되었을 때, 등록된 콜백을 모두 해제해야 함 - 안하면 leak
           2. 구독자가 구독하는 동안에만 onNext와 onComplete 이벤트를 호출해야 합니다 
           3. 에러가 발생할 때 오직 'onError' 이벤트로만 에러를 전달해야 합니다
           4. 배압 (back pressure)을 직접 처리해야 합니다
         */
    }
}
