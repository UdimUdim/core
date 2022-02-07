package hello.core.scope;

import hello.core.scope.SingletonTest.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.context.annotation.*;

import javax.annotation.*;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class PrototypeTest {

    @Test
    void prototypeBeanFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        System.out.println("find prototypeBean1");
        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
        System.out.println("find prototypeBean2");
        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);

        System.out.println("prototypeBean1= " + prototypeBean1);
        System.out.println("prototypeBean2= " + prototypeBean2);
        assertThat(prototypeBean1).isNotSameAs(prototypeBean2);
        ac.close(); // 스프링 컨테이너가 생성과 의존관계 주입 그리고 초기화까지만 관여하고, 더는 관리하지 않기 때문에 실행되지 않음. destroy를 직접 해줘야함.
    }

    @Scope("prototype")
    static class PrototypeBean{
        @PostConstruct
        public void init(){
            System.out.println("PrototypeBean.init");
        }

        @PreDestroy
        public void destroy(){
            System.out.println("PrototypeBean.destroy");
        }
    }
}
