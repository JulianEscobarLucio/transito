package com.julian.transito.generadordeturnos.domain.entity;

import com.julian.transito.generadordeturnos.domain.vo.ProcessType;
import com.julian.transito.generadordeturnos.domain.vo.TurnStatus;
import com.julian.transito.generadordeturnos.domain.vo.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Builder
@Setter
@Getter
public class Turn {

   private String id;
   private ProcessType processType;
   private LocalDateTime date;
   private User user;
   private String code;
   private TurnStatus status;
}
