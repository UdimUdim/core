package hello.core.web;

import hello.core.common.*;
import lombok.*;
import org.springframework.beans.factory.*;
import org.springframework.stereotype.*;

@Service
@RequiredArgsConstructor
public class LogDemoService {

    private final MyLogger myLogger;

    public void logic(String testId) {

        myLogger.log("service id = " + testId);
    }
}
