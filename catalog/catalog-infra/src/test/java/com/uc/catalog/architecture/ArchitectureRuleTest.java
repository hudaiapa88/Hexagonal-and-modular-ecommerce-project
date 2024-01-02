package com.uc.catalog.architecture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.Architectures;
@AnalyzeClasses(packages = "com.uc.catalog")
public class ArchitectureRuleTest {
    @ArchTest
    public static final ArchRule module_dependencies_are_respected = Architectures.layeredArchitecture()
            .consideringOnlyDependenciesInLayers()
            .optionalLayer("domain").definedBy("..domain..")
            .optionalLayer("infra").definedBy("..infra..")
            .whereLayer("infra").mayNotBeAccessedByAnyLayer()
            .whereLayer("domain").mayOnlyBeAccessedByLayers("infra");

}
