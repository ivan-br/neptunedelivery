package com.gmail.merikbest2015.ecommerce.dto.order.request;

import lombok.Data;

import java.io.Serializable;


@Data
public class OrderCartItem implements Serializable {
    private Long id;
    private Long quantity;
}
