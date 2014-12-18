package pl.mjedynak;

import com.netflix.hystrix.contrib.servopublisher.HystrixServoMetricsPublisher;
import com.netflix.hystrix.strategy.HystrixPlugins;
import pl.mjedynak.service.DefaultTimeService;
import pl.mjedynak.service.HystrixTimeService;
import pl.mjedynak.service.TimeService;

import java.time.LocalDateTime;

public class App {

    public static void main(String[] args) {
        HystrixPlugins.getInstance().registerMetricsPublisher(HystrixServoMetricsPublisher.getInstance());

        TimeService timeService = new HystrixTimeService(new DefaultTimeService());
        LocalDateTime currentTime = timeService.getCurrentTime();

        System.out.println(currentTime);
    }
}
