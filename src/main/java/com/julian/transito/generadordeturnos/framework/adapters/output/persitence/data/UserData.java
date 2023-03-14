package com.julian.transito.generadordeturnos.framework.adapters.output.persitence.data;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class UserData {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(nullable = false)
  private String documentType;

  @Column(nullable = false)
  private String documentNumber;

  @OneToMany(mappedBy = "user")
  private List<TurnData> turnDataList;
}
