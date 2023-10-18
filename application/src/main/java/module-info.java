module com.uc.application {
    requires lombok;
    requires common;
    requires spring.boot;
    requires spring.boot.starter.jdbc;
    requires spring.boot.starter.data.jpa;
    requires spring.core;
    requires org.hibernate.orm.core;
    requires spring.boot.autoconfigure;
    requires spring.data.commons;
    requires spring.beans;
    requires spring.context;
    requires spring.web;
    requires org.slf4j;
    requires org.mapstruct;
    requires spring.data.jpa;
    requires jakarta.persistence;
    opens com.uc.application;
}