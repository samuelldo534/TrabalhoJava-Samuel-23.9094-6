package br.grupointegrado.educacional.dto;

import java.math.BigDecimal;
import java.util.Date;

public record NotaRequestDTO(BigDecimal nota, Date data_lancamento) {
}
