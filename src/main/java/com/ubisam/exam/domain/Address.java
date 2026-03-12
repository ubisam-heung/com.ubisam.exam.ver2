package com.ubisam.exam.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "exam_address")
public class Address {

<<<<<<< HEAD
  @Id
  @GeneratedValue
  private Long id;

  private String name;
  private String phone;
  private String address;
=======
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String phone;
    private String address;
>>>>>>> 0c893d8988430cc347921237be980fb47eb20eb7

}
