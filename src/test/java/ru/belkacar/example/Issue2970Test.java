package ru.belkacar.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import reactor.tools.agent.ReactorDebugAgent;

import java.time.Duration;

@SpringBootTest
public class Issue2970Test {

    @BeforeAll
    public static void setUp() {
        ReactorDebugAgent.init();
        ReactorDebugAgent.processExistingClasses();
    }

    @Test
    public void test() {
        Mono.delay(Duration.ofSeconds(1))
                .toProcessor()
                .block();
    }
}
