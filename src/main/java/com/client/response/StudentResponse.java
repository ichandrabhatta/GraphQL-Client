package com.client.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class StudentResponse {

	private Integer id;


	private String firstName;

	private String lastName;

	private String email;

	private String street;

	private String city;

	private List<SubjectResponse> learningSubjects;

	private String fullName;


}
