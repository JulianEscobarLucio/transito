package com.julian.transito.generadordeturnos.framework.adapters.input.rest.data.response;

import com.julian.transito.generadordeturnos.domain.vo.ProcessType;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TurnResponse {

  private String id;
  private ProcessType processType;
  private LocalDateTime date;
  private String code;
}
