package br.com.cespec.java.data;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

public class DataTest {

	private final LocalDate DATA_ATUAL = LocalDate.of(2015, Month.MARCH, 23);
	private final LocalDate INICIO_COPA_2014 = LocalDate.of(2014, Month.JUNE, 12);

	@Test
	public void deveCalcularTempoRestanteAteAsOlimpiadasDoRioEm2016() {

		LocalDate lOlimpiadasRio = LocalDate.of(2016, Month.JUNE, 5);

		Period lPeriodo = Period.between(DATA_ATUAL, lOlimpiadasRio);

		assertEquals(1, lPeriodo.getYears());
		assertEquals(2, lPeriodo.getMonths());
		assertEquals(13, lPeriodo.getDays());
	}

	@Test
	public void deveCalcularDataDaProximaCopaDoMundo() {

		LocalDate lInicioProximaCopa = INICIO_COPA_2014.plusYears(4);

		assertEquals("12/06/2018", DateTimeFormatter.ofPattern("dd/MM/yyyy").format(lInicioProximaCopa));
	}
}
