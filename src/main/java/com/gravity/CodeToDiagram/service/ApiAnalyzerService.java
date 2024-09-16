//Implement Code Parsing Module
package com.gravity.CodeToDiagram.service;

import com.gravity.CodeToDiagram.model.ApiMetadata;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@Service
public class ApiAnalyzerService {

    public ApiMetadata analyzeApi(Class<?> apiClass) {
        ApiMetadata metadata = new ApiMetadata();
        List<String> endpoints = new ArrayList<>();

        for (Method method : apiClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(GetMapping.class)) {
                GetMapping getMapping = method.getAnnotation(GetMapping.class);
                endpoints.add("GET " + String.join(", ", getMapping.value()));
                System.out.println(("GET " + String.join(", ", getMapping.value())));
            }
            if (method.isAnnotationPresent(PostMapping.class)) {
                PostMapping postMapping = method.getAnnotation(PostMapping.class);
                endpoints.add("POST " + String.join(", ", postMapping.value()));
                System.out.println(("POST " + String.join(", ", postMapping.value())));
            }
            if (method.isAnnotationPresent(PutMapping.class)) {
                PutMapping putMapping = method.getAnnotation(PutMapping.class);
                endpoints.add("PUT " + String.join(", ", putMapping.value()));
                System.out.println(("PUT " + String.join(", ", putMapping.value())));
            }
            if (method.isAnnotationPresent(DeleteMapping.class)) {
                DeleteMapping delMapping = method.getAnnotation(DeleteMapping.class);
                endpoints.add("DELETE " + String.join(", ", delMapping.value()));
                System.out.println(("DELETE " + String.join(", ", delMapping.value())));
            }


//We can add more HTTP methods as needed like PUT, DELETE

         }
        System.out.println("Analyze API: " + endpoints);
        metadata.setEndpoints(endpoints);
        return metadata;
    }
}