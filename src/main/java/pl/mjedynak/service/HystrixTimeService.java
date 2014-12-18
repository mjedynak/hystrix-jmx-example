package pl.mjedynak.service;

import pl.mjedynak.hystrix.HystrixGetCurrentTimeCommand;

import java.time.LocalDateTime;

public class HystrixTimeService implements TimeService {

    private final TimeService timeService;

    public HystrixTimeService(TimeService timeService) {
        this.timeService = timeService;
    }

    @Override
    public LocalDateTime getCurrentTime() {
        return new HystrixGetCurrentTimeCommand(timeService).execute();
    }
}
