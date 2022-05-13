package com.gfg.jbdl30session9.manager;

import com.gfg.jbdl30session9.model.OrderRequest;
import com.gfg.jbdl30session9.model.OrderResponse;

public interface OrderManager {
    String createOrder(OrderRequest orderRequest);

    OrderResponse get(String orderId) throws Exception;
}
