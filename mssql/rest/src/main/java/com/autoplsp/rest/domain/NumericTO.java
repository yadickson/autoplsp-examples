/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autoplsp.rest.domain;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Yadickson Soto
 */
@Getter
@Setter
public class NumericTO {

    private Long id;
    private Integer cInt;
    private Long cBigInt;
    private Integer cSmallInt;
    private Integer cTinyInt;
    private Long cDecimal;
    private Long cNumeric;
    private Float cFloat;
    private Double cReal;
    private Boolean cBit;
    private Double cMoney;
    private Double cSmallMoney;
}
