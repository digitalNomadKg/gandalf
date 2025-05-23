package adcash.webapp.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

@RestController
public class GandalfController {

    private final Counter gandalfCounter;

    public GandalfController(MeterRegistry registry) {
        this.gandalfCounter = registry.counter("requests_total", "endpoint", "/gandalf");
    }

    @GetMapping("/gandalf")
    public String showGandalf() {
        gandalfCounter.increment();
        // return "<html><body><img src='/images/gandalf.webp' alt='Gandalf'/></body></html>";
        return "<html><body>"
                + "<div style='display: flex; justify-content: center; align-items: center; height: 100vh;'>"
                + "<img src='/images/gandalf.webp' alt='Gandalf' />"
                + "</div>"
                + "</body></html>";
    }
}
