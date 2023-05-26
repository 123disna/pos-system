package com.frontendpos.posfrontend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestOrderDetailsSaveDTO {
    private String itemName;
    private double qty;
    private double amount;
    private int item;
}
