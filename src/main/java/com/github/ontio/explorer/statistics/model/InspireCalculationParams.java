package com.github.ontio.explorer.statistics.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Table(name = "tbl_inspire_calculation_params")
@Data
public class InspireCalculationParams {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "second_round_incentive")
    private BigDecimal secondRoundIncentive;

    @Column(name = "gas_fee")
    private BigDecimal gasFee;

}