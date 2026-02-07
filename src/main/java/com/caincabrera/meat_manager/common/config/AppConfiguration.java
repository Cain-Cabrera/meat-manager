package com.caincabrera.meat_manager.common.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configurable
@EnableScheduling
@EnableCaching
public class AppConfiguration {
}
