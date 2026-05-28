package com.proyecto2026.web.product.application.scheduling;

import com.proyecto2026.web.product.domain.port.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class FixProductsPriceSchedule {

    private final ProductRepository productRepository;

//    @Scheduled(fixedRate = 30000)
//    public void fixProductPrice() {
//        log.info("Fixing products price");
//
//        productRepository.findAll().forEach(product -> {
//            product.setPrice(product.getPrice() * 1.1);
//            productRepository.save(product);
//        });
//        log.info("Finished fixing products price");
//
//    }
}
