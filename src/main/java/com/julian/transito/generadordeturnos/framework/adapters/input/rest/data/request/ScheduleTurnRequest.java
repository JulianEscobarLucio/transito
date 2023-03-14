package com.julian.transito.generadordeturnos.framework.adapters.input.rest.data.request;

import com.julian.transito.generadordeturnos.domain.vo.DocumentType;
import lombok.*;

import javax.validation.constraints.NotEmpty;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleTurnRequest {

  @NotEmpty(message = "documentType may not be empty")
  private DocumentType documentType;

  @NotEmpty(message = "documentNumber may not be empty")
  private String documentNumber;

  @NotEmpty(message = "turnId may not be empty")
  private String turnId;
}
