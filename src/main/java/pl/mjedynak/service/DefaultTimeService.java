package pl.mjedynak.service;

import java.time.LocalDateTime;

public class DefaultTimeService implements TimeService {

    @Override
    public LocalDateTime getCurrentTime() {
        return LocalDateTime.now();
    }
}
