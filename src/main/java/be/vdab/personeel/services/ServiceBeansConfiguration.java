package be.vdab.personeel.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
 class ServiceBeansConfiguration {
    @Bean
    DefaultJobtitelService findAllOrderByNaam() {
        return new DefaultJobtitelService();
    }
    @Bean
    DefaultWerknemerService findById() {
        return new DefaultWerknemerService();
    }
}
