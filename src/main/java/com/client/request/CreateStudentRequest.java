package com.client.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class CreateStudentRequest {

    @JsonProperty("firstName")
    private String firstName;

    private String lastName;

    private String email;

    private String street;

    private String city;

    private List<CreateSubjectRequest> subjectsLearning;

}
