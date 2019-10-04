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

            List<TypeElementProperty> typeElementProperties = getTypeElementProperties(numberOfProperties);
            List<TypeElementBinding> typeElementBindings = getTypeElementBindings(i, numberOfProperties, configuration.getNumberOfBindings());

            typeElements.add(new TypeElement("Type " + i, typeElementProperties, typeElementBindings));
        }

        return typeElements;
    }

    private List<TypeElementProperty> getTypeElementProperties(int numberOfProperties) {
        List<TypeElementProperty> typeElementProperties = new ArrayList<>();

        for (int numberOfProperty = 0; numberOfProperty < numberOfProperties; numberOfProperty++) {
            typeElementProperties.add(new TypeElementProperty("Property " + numberOfProperty, ContentType.String));
        }

        return typeElementProperties;
    }

    private List<TypeElementBinding> getTypeElementBindings(int numberOfType, int numberOfProperties, int numberOfBindings) {
        List<TypeElementBinding> typeElementBindings = new ArrayList<>();
        for (int numberOfBinding = 0; numberOfBinding < numberOfBindings; numberOfBinding ++) {
            TypeElementBinding typeElementBinding = getTypeElementBinding(numberOfType, numberOfBinding, numberOfProperties);
            typeElementBindings.add(typeElementBinding);
        }

        return typeElementBindings;
    }

    private TypeElementBinding getTypeElementBinding(int numberOfType, int numberOfBinding, int numberOfProperties) {
        List<TypeElementPropertyBinding> typeElementPropertyBindings = new ArrayList<>();
        String typeDeveloperName = "Type " + numberOfType;

        if (numberOfBinding > 0) {
            typeDeveloperName = "Type " + numberOfType + " " + numberOfBinding;
        }

        for (int numberOfProperty = 0; numberOfProperty < numberOfProperties; numberOfProperty++) {
            typeElementPropertyBindings.add(new TypeElementPropertyBinding("Property " + numberOfProperty, "Property " + numberOfProperty));
        }

        return new TypeElementBinding(typeDeveloperName, typeDeveloperName, String.valueOf(numberOfType), typeElementPropertyBindings);
    }

}
