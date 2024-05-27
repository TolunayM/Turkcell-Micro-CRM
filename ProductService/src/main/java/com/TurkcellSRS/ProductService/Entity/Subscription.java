package com.TurkcellSRS.ProductService.Entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("subscription")
@Data
public class Subscription extends Product{
    private Integer internetData;
    private Integer sms;
    private Integer minute;
}
