module com.uc.catalog {
    requires lombok;
    requires common;
    requires spring.boot;
    requires spring.core;
    requires com.zaxxer.hikari;
    requires spring.boot.autoconfigure;
    requires spring.data.commons;
    requires spring.jdbc;
    requires spring.beans;
    requires spring.context;
    requires spring.web;
    requires org.slf4j;
    requires org.mapstruct;
    requires spring.data.jpa;
    requires jakarta.persistence;
    requires java.sql;
    exports com.uc.catalog.api.category;
    exports com.uc.catalog.api.product;
}