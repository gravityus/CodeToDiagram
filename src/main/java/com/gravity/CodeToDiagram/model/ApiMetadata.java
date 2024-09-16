//Define API Metadata Model
package com.gravity.CodeToDiagram.model;

import java.util.List;

public class ApiMetadata {
    private List<String> endpoints;
            // need to implement these
                //private List<String> httpMethods;
                //private List<String> inputParameters;
                //private List<String> outputTypes;
                //private List<String> servicesUsed
                //private List<String> externalApiCalls
                //private List<String> securityConfigurations

    // Getters and Setters
    // I will use this to give an input to the diagram service
    public List<String> getEndpoints() {
        return endpoints;
    }

    //I will use this to read and store the end points
    public void setEndpoints(List<String> endpoints) {
        this.endpoints = endpoints;
        System.out.println("ApiMetadata: " + this.endpoints);
    }
}