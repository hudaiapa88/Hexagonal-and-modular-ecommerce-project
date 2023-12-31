package com.uc.architecture;

import com.tngtech.archunit.core.importer.Location;

public class ExcludeApiImportOption implements com.tngtech.archunit.core.importer.ImportOption{
    @Override
    public boolean includes(Location location) {
         return !location.contains("com.uc.common..");
    }
}
