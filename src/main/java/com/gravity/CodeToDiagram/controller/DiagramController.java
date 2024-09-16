//Create REST Controller to Handle Requests
package com.gravity.CodeToDiagram.controller;

import com.gravity.CodeToDiagram.model.ApiMetadata;
    import com.gravity.CodeToDiagram.sample.SampleApiController;
import com.gravity.CodeToDiagram.service.ApiAnalyzerService;
import com.gravity.CodeToDiagram.service.DiagramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@RestController
// This will pick the sample API from the dummy package "sample"
public class DiagramController {

    @Autowired
    private ApiAnalyzerService apiAnalyzerService;

    @Autowired
    private DiagramService diagramService;

    @GetMapping("/analyze")     //-- http://localhost:8080/analyze
    public ResponseEntity<byte[]> analyzeAndGenerateDiagram() throws IOException {
        // analyze the sample API/ java code
        ApiMetadata metadata = apiAnalyzerService.analyzeApi(SampleApiController.class); // we can try to do it trough inputting a file.

        // generate the file with diagram in it
        File diagram = diagramService.generateDiagram(metadata);
        // read the file
        byte[] imageBytes = Files.readAllBytes(diagram.toPath());

        return ResponseEntity.ok()   // to encapsulates the entire HTTP response
                .contentType(MediaType.IMAGE_PNG)
                .body(imageBytes);
    }
}































/*
//For File as input param  -- http://localhost:8080/analyze?filePath=C:/code/SampleApi.java
public class DiagramController {

    @GetMapping("/analyze")
    public String analyzeApi(@RequestParam String filePath) {
        System.out.println("Analyzing API code at path: " + filePath);

        File file = new File(filePath);
        if (!file.exists()) {
            return "File not found: " + filePath;
        }

        // Call your method to analyze the file
        String analysisResult = analyzeApiCode(file);

        // Return the analysis result
        return analysisResult != null ? analysisResult : "No analysis result found.";
    }

    // Dummy method to simulate the analysis
    private String analyzeApiCode(File file) {
        // Add your logic here to read the file and analyze the API code
        return "Analysis result for file: " + file.getName();
    }
}

 */