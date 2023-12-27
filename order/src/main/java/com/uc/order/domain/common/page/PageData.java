package com.uc.order.domain.common.page;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class PageData<T> {
    long totalElements;
    int totalPages;
    int currentPage;
    long currentPageElements;
    List<T> data= new ArrayList<>();


}
