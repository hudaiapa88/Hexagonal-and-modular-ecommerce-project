package com.uc.common.page;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
