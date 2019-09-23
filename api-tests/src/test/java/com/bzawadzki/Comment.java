package com.bzawadzki;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Comment {

  private Integer postId;
  private Integer id;
  private String name;
  private String email;
  private String body;
}
