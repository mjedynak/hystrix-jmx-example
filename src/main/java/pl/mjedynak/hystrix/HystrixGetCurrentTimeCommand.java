package pl.mjedynak.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import pl.mjedynak.service.TimeService;

import java.time.LocalDateTime;

public class HystrixGetCurrentTimeCommand extends HystrixCommand<LocalDateTime> {

    private final TimeService timeService;

    public HystrixGetCurrentTimeCommand(TimeService timeService) {
        super(HystrixCommandGroupKey.Factory.asKey("GetCurrentTimeGroup"));
        this.timeService = timeService;
    }

    @Override
    protected LocalDateTime run() throws Exception {
        return timeService.getCurrentTime();
    }
}
