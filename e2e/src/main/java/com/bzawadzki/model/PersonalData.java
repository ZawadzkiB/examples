package com.bzawadzki.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class PersonalData {

  private String title;
  private String firstName;
  private String lastName;
  private String email;
  private String password;
  @JsonFormat(pattern = "dd-MM-yyyy")
  private LocalDate dateOfBirth;
  private Boolean signForNewsletter;
  private Boolean signForSpecialOffers;
}
