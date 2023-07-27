package com.example.excercise1.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class UserDto implements Validator {
    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String birthOfDay;
    private String email;

    public UserDto() {
    }

    public UserDto(int id, String firstName, String lastName, String phoneNumber, String birthOfDay, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.birthOfDay = birthOfDay;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBirthOfDay() {
        return birthOfDay;
    }

    public void setBirthOfDay(String birthOfDay) {
        this.birthOfDay = birthOfDay;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        if (userDto.getFirstName().equals("")) {
            errors.rejectValue("firstName", null, "Not Empty");
        } else if (userDto.getFirstName().length() <= 5 || userDto.getFirstName().length() >= 45) {
            errors.rejectValue("firstName", null, "Length is wrong");
        }
        if (userDto.getLastName().equals("")) {
            errors.rejectValue("lastName", null, "Not empty");
        } else if (userDto.getLastName().length() <= 5 || userDto.getLastName().length() >= 45) {
            errors.rejectValue("lastName", null, "Length is wrong");
        }

        try {
            if (userDto.getBirthOfDay().equals("")) {
                errors.rejectValue("birthOfDay", null, "Not empty");
            } else {
                LocalDate birthDay = LocalDate.parse(userDto.getBirthOfDay());
                if (ChronoUnit.YEARS.between(birthDay, LocalDate.now()) < 18) {
                    errors.rejectValue("birthOfDay", null, "Not enough 18");
                }
            }
        } catch (Exception e) {
            errors.rejectValue("birthOfDay", null, "Not Date");
        }
        if (userDto.getPhoneNumber().equals("")) {
            errors.rejectValue("phoneNumber", null, "Not empty");
        } else if (!userDto.getPhoneNumber().matches("^[0-9]{10}$")) {
            errors.rejectValue("phoneNumber", null, "Not Phone Number");
        }
        if (userDto.getEmail().equals("")) {
            errors.rejectValue("email", null, "Not empty");
        } else if (!userDto.getEmail().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            errors.rejectValue("email", null, "Not Email");
        }
    }
}
