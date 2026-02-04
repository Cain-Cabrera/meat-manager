package com.caincabrera.meat_manager.client.application.scheduling;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class RegisterStockAvailable {

    @Scheduled(cron = "0 0 9 * * *")
    public void StockRegister() {
        log.info("register stock available");
    }
}
