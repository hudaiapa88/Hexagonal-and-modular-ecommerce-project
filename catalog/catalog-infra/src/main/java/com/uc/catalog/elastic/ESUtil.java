package com.uc.catalog.elastic;


import co.elastic.clients.elasticsearch._types.FieldSort;
import co.elastic.clients.elasticsearch._types.SortOptions;
import co.elastic.clients.elasticsearch._types.SortOptionsBuilders;
import co.elastic.clients.elasticsearch._types.SortOrder;
import co.elastic.clients.elasticsearch._types.query_dsl.*;
import co.elastic.clients.util.ObjectBuilder;
import lombok.experimental.UtilityClass;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.core.query.Query;

import java.util.List;
import java.util.function.Supplier;

@UtilityClass
public class ESUtil {
    public static Query createMatchAllQuery(Pageable pageable) {
        return NativeQuery.builder()
                .withQuery(q->q.matchAll(ma->ma))
                .withPageable(PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()))
                .withSort(SortOptions.of((so)->so.field(FieldSort.of((fs)->fs.field("title").order(SortOrder.Desc)))))
                .build();
    }

 /*   public static Supplier<Query> buildQueryForFieldAndValue(String fieldName, String searchValue) {


        return () -> Query.of(q -> q.match(buildMatchQueryForFieldAndValue(fieldName, searchValue)));
    }*/

    public static Query buildMatchQueryForFieldAndValue(String fieldName, String searchValue) {


        return NativeQuery.builder().withQuery(q -> q
                .match(m -> m
                        .field(fieldName)
                        .query(searchValue)
                )).build();

    }

  /*  public static Supplier<Query> createBoolQuery(SearchRequestDto dto) {
        return () -> Query.of(q -> q.bool(boolQuery(dto.getFieldName().get(0).toString(), dto.getSearchValue().get(0),
                dto.getFieldName().get(1).toString(), dto.getSearchValue().get(1))));
    }*/

    public static Query boolQuery(String key1, String value1, String key2, String value2) {
        return NativeQuery.builder().withQuery(q -> q
                .bool(b -> (ObjectBuilder<BoolQuery>) b
                        .filter(termQuery(key1.toString(), value1))
                        .must(termQuery(key2.toString(), value2)).build()
                )
        ).build();
    }

    public static Query rangeQuery(String field, String min,String max){
        return NativeQuery.builder()
                .withQuery(q->q.range(r->r.field(field).from(min).to(max)))
                .build();
    }
    public static Query rangeQuery(String field, String min,String max,Pageable pageable){
        return NativeQuery.builder()
                .withQuery(q->q.range(r->r.field(field).from(min).to(max)))
                .withPageable(pageable)
                .build();
    }

    public static co.elastic.clients.elasticsearch._types.query_dsl.Query termQuery(String field, String value) {
        return co.elastic.clients.elasticsearch._types.query_dsl.Query.of(q -> q.term(new TermQuery.Builder()
                .field(field)
                .value(value)
                .build()));
    }

    public static Query matchQuery(String field, String value) {

        return NativeQuery.builder()
                .withQuery(q -> q
                        .match(m -> m
                                .field(field)
                                .query(value)
                        )
                )
                .build();

    }

    public static Query buildAutoSuggestQuery(String name) {
     return   NativeQuery.builder()
               .withQuery(q->q.match((MatchQuery) createAutoSuggestMatchQuery(name)))
               .build();

    }

    public static Query createAutoSuggestMatchQuery(String name) {

     return   NativeQuery.builder().withQuery(q->q
               .match(m->m
                       .field("title")
                       .query(name)
                       .analyzer("custom_index")
               )
       ).build();

    }

}
