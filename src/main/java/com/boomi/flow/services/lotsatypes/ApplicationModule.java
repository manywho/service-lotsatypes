package com.boomi.flow.services.lotsatypes;

import com.google.inject.AbstractModule;
import com.manywho.sdk.services.types.TypeProvider;
import com.boomi.flow.services.lotsatypes.types.LotastypesTypeProvider;

public class ApplicationModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(TypeProvider.class).to(LotastypesTypeProvider.class);
    }
}
