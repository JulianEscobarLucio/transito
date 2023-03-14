package com.julian.transito.generadordeturnos.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class User {

  private String id;
  private DocumentType documentType;
  private String documentNumber;
}
