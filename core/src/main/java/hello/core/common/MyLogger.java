package hello.core.common;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.*;

import javax.annotation.*;
import java.util.*;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyLogger {

    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL){
        this.requestURL = requestURL;
    }

    public void log(String message){
        System.out.println("[" + uuid + "] ["+ requestURL + "] " + message);
    }

    @PostConstruct
    public  void init(){
        uuid = UUID.randomUUID().toString();
        System.out.println("[" + uuid + "] request scope bean create: " +this);
    }

    @PreDestroy
    public void close(){
        System.out.println("[" + uuid + "] request scope bean close: " +this);
    }

}
