package com.bzawadzki.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class AddressData {

  private String firstName;
  private String lastName;
  private String company;
  private String addressFirstLine;
  private String addressSecondLine;
  private String city;
  private String state;
  private String zipCode;
  private String country;
  private String additionalInformation;
  private String homePhone;
  private String mobilePhone;
  private String addressAlias;
}
