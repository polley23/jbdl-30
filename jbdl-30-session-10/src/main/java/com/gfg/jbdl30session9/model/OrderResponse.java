package com.gfg.jbdl30session9.model;

import com.gfg.jbdl30session9.entity.Item;
import lombok.*;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrderResponse {
    String userId;
    Date orderDate;
    List<Item> items;

}
