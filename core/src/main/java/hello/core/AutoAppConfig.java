package hello.core;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(
        basePackages = "hello.core.member",
        excludeFilters =  @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) //@Configuration이 붙은 class는 제외한다(이 프로젝트에선 AppConfig, TestConfig 해당)
)
public class AutoAppConfig {


}

