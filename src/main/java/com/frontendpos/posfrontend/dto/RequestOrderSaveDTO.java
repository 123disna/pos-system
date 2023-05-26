package com.frontendpos.posfrontend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequestOrderSaveDTO {
    private int customer;
    private Date date;
    private double total;
    private List<RequestOrderDetailsSaveDTO> orderDetailsSaveDTOS;
}
