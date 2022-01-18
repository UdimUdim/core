package hello.core.singleton;


import org.assertj.core.api.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.context.annotation.*;

import static org.assertj.core.api.Assertions.*;

public class StatefulServiceTest {

    @Test
     void statefulServiceSingleton(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //ThreadA: A사용자 10000원 주문문
        statefulService1.order("userA", 10000);
        //ThreadB: B사용자 10000원 주문문
        statefulService2.order("userB", 20000);

        //ThreadA: A사용자가 주문 금액 조회
        int price = statefulService1.getPrice();
        System.out.println("price: " + price); //20000이 출력
        
        assertThat(statefulService1.getPrice()).isEqualTo(20000);

    }
 
    static class TestConfig{

        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}
