package com.client.service;


import com.client.response.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Service
public class ClientService {

    private HttpGraphQlClient graphQlClient;

    @Autowired
    private Environment env;


    public ClientService() {
        WebClient client = WebClient.builder()
                .baseUrl("http://graphql-service:8080/graphql")
                .build();

        graphQlClient = HttpGraphQlClient.builder(client).build();
    }

    public StudentResponse getStudent(Integer id) {

        Map<String, Object> variables = new HashMap<>();
        variables.put("id", id);


           //language=Graphql

          String document =  "query student($id : Int) {\r\n"
                  + "  student(id : $id) {\r\n"
                  + "    id\r\n"
                  + "    firstName\r\n"
                  + "    lastName\r\n"
                  + "    email\r\n"
                  + "    street\r\n"
                  + "    city\r\n"
                  + "    learningSubjects (subjectNameFilter : All) {\r\n"
                  + "      id\r\n"
                  + "      subjectName\r\n"
                  + "      marksObtained\r\n"
                  + "    }\r\n"
                  + "    fullName\r\n"
                  + "  } \r\n"
                  + "}" ;

            Mono<StudentResponse> studentResponse =  graphQlClient.document(document)
                    .variables(variables)
                   .retrieve("student")
                   .toEntity(StudentResponse.class);

           return studentResponse.block();

    }
}
