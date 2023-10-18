open module common {
    requires org.mapstruct;
    requires lombok;
    requires spring.beans;
    requires spring.context;
    requires spring.web;
    requires spring.boot;
    requires spring.core;
    requires spring.boot.starter.web;
    exports com.uc.common.usecase;
    exports com.uc.common.rest.exception;
    exports com.uc.common.base;
    exports com.uc.common;
}