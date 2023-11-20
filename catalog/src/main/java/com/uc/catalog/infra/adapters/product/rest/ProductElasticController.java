package com.uc.catalog.infra.adapters.product.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product-elastic/")
@RequiredArgsConstructor
@Transactional("catalogTransactionManager")
public class ProductElasticController {
}
