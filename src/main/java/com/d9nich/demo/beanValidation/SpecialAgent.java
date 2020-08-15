package com.d9nich.demo.beanValidation;

import org.springframework.lang.NonNull;

import javax.validation.constraints.*;

public class SpecialAgent {

    @NotNull
    private String name;
    @NotEmpty
    private String surname;
    @Size(min = 1, max = 3)
    @Pattern(regexp = "\\d{1,3}")
    private String code;
    @NotBlank
    private String status;
    @Min(value = 18, message = "Age must be greater than or equal to 18")
    private int age;
    @NotNull
    @Email
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
