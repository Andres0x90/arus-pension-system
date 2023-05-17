package co.com.arus;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class TestRouter {
    @GetMapping("/")
    public Mono<String> hello(){
        return Mono.just("Hello world");
    }
}
