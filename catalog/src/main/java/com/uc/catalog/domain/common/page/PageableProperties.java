package com.uc.catalog.domain.common.page;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


public class PageableProperties {
    @Getter
    @Setter
    int size;
    @Getter
    @Setter
    int page;
    @Getter
    Sort sort;

    public void setSort(String[] sort) {
        this.sort = new Sort();
        for (String sortOrder : sort) {
            String[] splitSort = sortOrder.split("-");
            this.sort.getOrders().add(new Sort.Order(splitSort[1], splitSort[0], true));
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public class Sort {
        List<Order> orders = new ArrayList<>();


        @Getter
        @Setter
        @AllArgsConstructor
        public static class Order {
            private String direction;
            private String property;
            private boolean ignoreCase;

        }
    }
}
