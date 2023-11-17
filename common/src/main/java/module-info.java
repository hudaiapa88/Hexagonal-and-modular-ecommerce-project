open module common {
    requires org.mapstruct;
    requires lombok;
    requires org.slf4j;
    requires spring.beans;
    requires spring.context;
    requires spring.web;
    requires spring.boot;
    requires spring.core;
    requires spring.boot.starter.web;
    requires io.swagger.v3.oas.annotations;
    requires io.swagger.v3.oas.models;
    exports com.uc.common.usecase;
    exports com.uc.common.rest.exception;
    exports com.uc.common.base;
    exports com.uc.common;
    exports com.uc.common.event;
    exports com.uc.common.mapper;
}