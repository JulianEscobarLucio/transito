package com.julian.transito.generadordeturnos.framework.adapters.input.soap.mapper;

import com.julian.transito.generadordeturnos.domain.entity.Turn;
import com.julian.transito.generadordeturnos.framework.adapters.input.soap.data.TurnData;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.GregorianCalendar;

public final class TurnResponseMapper {

  public static TurnData turnToTurnData(Turn turn)  {
    TurnData turnData = TurnData.builder().id(turn.getId()).code(turn.getCode()).build();
    try {
      turnData.setDate(turn.getDate() == null? null :  dateTimeToXMLGregorianCalendar(turn.getDate()));
    } catch (DatatypeConfigurationException ignored) {
    }
    return turnData;
  }

  private static XMLGregorianCalendar dateTimeToXMLGregorianCalendar(LocalDateTime date) throws DatatypeConfigurationException {
    ZoneId zoneId = ZoneId.systemDefault();
    GregorianCalendar gregorianCalendar = GregorianCalendar.from(date.atZone(zoneId));
    return DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
  }
}
