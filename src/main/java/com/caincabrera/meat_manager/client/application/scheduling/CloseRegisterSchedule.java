package com.caincabrera.meat_manager.client.application.scheduling;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class CloseRegisterSchedule {

    @Scheduled(cron = "0 0 8 * * *")
    public void closeRegister() {
        log.info("closing the cash register");
    }


}
