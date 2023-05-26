package com.frontendpos.posfrontend.entity;

import com.frontendpos.posfrontend.entity.enums.MeasuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "item")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Item {
    @Id
    @Column(name = "item_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemId;

    @Column(name = "item_name",length = 100,nullable = false)
    private String itemName;

    @Enumerated(EnumType.STRING)
    @Column(name ="measuring_unit",length = 100,nullable = false)
    private MeasuringUnitType measuringUnit;

    @Column(name ="balance_qty",length = 100,nullable = false)
    private double balanceQty;

    @Column(name ="supplier_price",length = 100,nullable = false)
    private double supplierPrice;

    @Column(name ="selling_price",length = 100,nullable = false)
    private double sellingPrice;

    @OneToMany(mappedBy="item")
    private Set<OrderDetails> orderDetails;

    public Item(String itemName, MeasuringUnitType measuringUnit, double balanceQty, double supplierPrice, double sellingPrice) {
        this.itemName = itemName;
        this.measuringUnit = measuringUnit;
        this.balanceQty = balanceQty;
        this.supplierPrice = supplierPrice;
        this.sellingPrice = sellingPrice;
    }
}
