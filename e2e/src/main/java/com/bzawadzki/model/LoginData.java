package com.bzawadzki.model;

import com.bzawadzki.annotations.TestData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@TestData(path = "src/test/resources/data/loginUserData.json")
public class LoginData {

  private String email;
  private String password;
  private String firstName;
  private String lastName;
}
