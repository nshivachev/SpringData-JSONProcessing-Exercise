package com.softuni.cardealer;

import com.softuni.cardealer.services.SeedService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandRunner implements CommandLineRunner {
    private final SeedService seedService;

    @Autowired
    public CommandRunner(SeedService seedService) {
        this.seedService = seedService;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        seedService.seedAll();
    }
}
