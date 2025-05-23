package adcash.webapp.demo.Controller;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

@RestController
public class TimeController {

    private final Counter colomboCounter;

    public TimeController(MeterRegistry registry) {
        this.colomboCounter = registry.counter("requests_total", "endpoint", "/colombo");
    }

    @GetMapping("/colombo")
    public String getColomboTime() {
        colomboCounter.increment();
        ZonedDateTime colomboTime = ZonedDateTime.now(ZoneId.of("Asia/Colombo"));
        String formatted = colomboTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z"));
        // return "Current time in Colombo City (Sri Lanka) is : " + formatted;
        return "<html><body>"
                + "<span style='color:green'><strong>Current time in Colombo City (Sri Lanka): </strong></span>"
                + "<span style='color:blue'><strong>" + formatted + "</strong></span>"
                + "</body></html>";
    }
}
