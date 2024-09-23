//Implement Diagram Generation Module

package com.gravity.CodeToDiagram.service;

import com.gravity.CodeToDiagram.model.ApiMetadata;
import net.sourceforge.plantuml.SourceStringReader;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class DiagramService {

    public File generateDiagram(ApiMetadata metadata) throws IOException {
        //Sequence diagram to show interactions between a user and an API, where various HTTP methods (GET, POST, DELETE, etc.) are represented as messages being sent from User to API
       /*
        String plantUmlScript = "@startuml\n";
        for (String endpoint : metadata.getEndpoints()) {
            plantUmlScript += "User -> API : " + endpoint + "\n";
        }
        plantUmlScript += "@enduml";

        System.out.println(plantUmlScript);
        SourceStringReader reader = new SourceStringReader(plantUmlScript);
        */
        /*
        String plantUmlScript_SeqDiag = "@startuml\n"+
                "User -> API : GET /users\n"+
                "User -> API : POST /users\n"+
                "User -> API : DELETE /users/{id}\n"+
                "User -> API : PUT /users/{id}\n"+
                "User -> API : GET /external\n"+
                "@enduml;
        System.out.println(plantUmlScript_SeqDiag);
        SourceStringReader reader = new SourceStringReader(plantUmlScript_SeqDiag);
        */

/*
        //Class Diagram Input:
        String plantUmlScript_ClsDiagram = "@startuml\n" +
                "class User {\n" +
                "  + String name\n" +
                "  + int age\n" +
                "  + void getUserInfo()\n" +
                "}\n" +
                "class API {\n" +
                "  + String endpoint\n" +
                "  + void getData()\n" +
                "}\n" +
                "User -- API : uses\n"+
                "@enduml\n";
        System.out.println(plantUmlScript_ClsDiagram);
        SourceStringReader reader = new SourceStringReader(plantUmlScript_ClsDiagram);

*/

        //Sequence Diagram with Alternative Conditions
        String plantUmlScript_SeqDiagAltCond = "@startuml\n" +
                "participant User\n" +
                "participant API\n" +
                "alt User is authenticated\n" +
                "  User -> API : GET /users\n" +
                "else User is not authenticated\n" +
                "  User -> API : POST /login\n" +
                "end\n" +
                "@enduml\n";
        System.out.println(plantUmlScript_SeqDiagAltCond);
        SourceStringReader reader = new SourceStringReader(plantUmlScript_SeqDiagAltCond);


/*
        //Test ground
        String plantUmlScript_SeqDiagAltCond = "@startuml\n" +
                "start\n" +
                ":User sends GET request;\n" +
                "if (User authenticated?) then (yes)\n" +
                "  :API processes request;\n" +
                "  :Return user data;\n" +
                "else (no)\n" +
                "  :Redirect to login;\n" +
                "endif\n" +
                "stop\n" +
                "@enduml\n"                ;
        System.out.println(plantUmlScript_SeqDiagAltCond);
        SourceStringReader reader = new SourceStringReader(plantUmlScript_SeqDiagAltCond);
*/

        File file = new File("diagram.png");
        try (FileOutputStream outputStream = new FileOutputStream(file)) {
            reader.outputImage(outputStream);

        }
        System.out.println(file);
        return file;
    }
}