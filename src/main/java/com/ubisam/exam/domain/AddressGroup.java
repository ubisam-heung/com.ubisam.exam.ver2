package com.ubisam.exam.domain;

<<<<<<< HEAD

=======
import java.util.List;
>>>>>>> 0c893d8988430cc347921237be980fb47eb20eb7

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
<<<<<<< HEAD
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
=======
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
>>>>>>> 0c893d8988430cc347921237be980fb47eb20eb7
import lombok.Data;

@Entity
@Data
@Table(name = "exam_address_group")
public class AddressGroup {
<<<<<<< HEAD

  @Id
  @GeneratedValue
  private Long id;

  private String name;

  // @ManyToMany
  // private List<Address> addresses;

  @Transient
  private String keyword;
=======
    
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    // @ManyToMany
    // private List<Address> addresses;

>>>>>>> 0c893d8988430cc347921237be980fb47eb20eb7
}
