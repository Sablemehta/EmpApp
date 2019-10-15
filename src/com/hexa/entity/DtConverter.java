package com.hexa.entity;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class DtConverter implements AttributeConverter<LocalDate, Date>{

	@Override
	public Date convertToDatabaseColumn(LocalDate ldt) {
		if(ldt != null)
			return Date.valueOf(ldt);//convert localdate into java.sql.Date
		return null;
	}

	@Override
	public LocalDate convertToEntityAttribute(Date sqldt) {
		if(sqldt != null)
			return sqldt.toLocalDate();//convert java.sql.Date into LocalDate
		return null;
	}

}
