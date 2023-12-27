package com.uc.catalog.architecture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.Architectures;

@AnalyzeClasses(packages = "com.uc.catalog")
public class ArchitectureRulesTest {
    private static final String mainModule = "catalog";
    private static final String categorySubModule = "category";
    private static final String productSubModule = "product";
    private static final String basePackage = String.format("com.uc.%s", mainModule);

    @ArchTest
    public static final ArchRule hexagonalArch = Architectures.layeredArchitecture()
            .consideringOnlyDependenciesInLayers()
            .optionalLayer("adapters").definedBy("..adapters..")
           // .optionalLayer("config").definedBy("..config..")
            .optionalLayer("domain").definedBy("..domain..")
           // .optionalLayer("common").definedBy("..common..")
            .optionalLayer("port").definedBy("..port..")
            .optionalLayer("infra").definedBy("..infra..")
            .whereLayer("infra").mayNotBeAccessedByAnyLayer()
            .whereLayer("domain").mayOnlyBeAccessedByLayers("infra");



}
