package com.boomi.flow.services.lotsatypes.types;

import com.boomi.flow.services.lotsatypes.ApplicationConfiguration;
import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.api.describe.DescribeServiceRequest;
import com.manywho.sdk.api.draw.elements.type.TypeElement;
import com.manywho.sdk.api.draw.elements.type.TypeElementBinding;
import com.manywho.sdk.api.draw.elements.type.TypeElementProperty;
import com.manywho.sdk.api.draw.elements.type.TypeElementPropertyBinding;
import com.manywho.sdk.services.types.TypeProvider;

import java.util.ArrayList;
import java.util.List;

public class LotastypesTypeProvider implements TypeProvider<ApplicationConfiguration> {
    @Override
    public boolean doesTypeExist(ApplicationConfiguration applicationConfiguration, String s) {
        return true;
    }

    @Override
    public List<TypeElement> describeTypes(ApplicationConfiguration configuration, DescribeServiceRequest describeServiceRequest) {
        List<TypeElement> typeElements = new ArrayList<>();

        for (int i = 0; i < configuration.getNumberOfTypes(); i++) {
            int numberOfProperties = configuration.getNumberOfProperties();

            List<TypeElementProperty> typeElementProperties = new ArrayList<>();

            for (int j = 0; j < numberOfProperties; j++) {
                typeElementProperties.add(new TypeElementProperty("Property " + j, ContentType.String));
            }

            List<TypeElementPropertyBinding> typeElementPropertyBindings = new ArrayList<>();

            for (int j = 0; j < numberOfProperties; j++) {
                typeElementPropertyBindings.add(new TypeElementPropertyBinding("Property " + j, "Property " + j));
            }

            List<TypeElementBinding> typeElementBindings = new ArrayList<>();

            typeElementBindings.add(new TypeElementBinding("Type " + i, "Type " + i, String.valueOf(i), typeElementPropertyBindings));

            typeElements.add(new TypeElement("Type " + i, typeElementProperties, typeElementBindings));
        }

        return typeElements;
    }
}
