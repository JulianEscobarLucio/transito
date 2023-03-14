package com.julian.transito.generadordeturnos.framework.adapters.output.persitence.data;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="turns")
public class TurnData {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String code;

  @Column(nullable = false)
  private String processType;

  @Column(nullable = false)
  private LocalDateTime fecha;

  @Column(nullable = false)
  private String status;

  @ManyToOne
  private UserData user;
}
