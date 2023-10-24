package com.gmail.merikbest2015.ecommerce.mapper;

import com.gmail.merikbest2015.ecommerce.domain.Order;
import com.gmail.merikbest2015.ecommerce.dto.HeaderResponse;
import com.gmail.merikbest2015.ecommerce.dto.order.request.OrderChangeRequestDTO;
import com.gmail.merikbest2015.ecommerce.dto.order.request.OrderRequest;
import com.gmail.merikbest2015.ecommerce.dto.order.response.OrderResponseDTO;
import com.gmail.merikbest2015.ecommerce.enums.StatusType;
import com.gmail.merikbest2015.ecommerce.exception.InputFieldException;
import com.gmail.merikbest2015.ecommerce.repository.projection.OrderProjection;
import com.gmail.merikbest2015.ecommerce.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;


@Component
@RequiredArgsConstructor
public class OrderMapper {

    private final CommonMapper commonMapper;

    private final OrderService orderService;

//    public OldOrderResponse getOrderById(Long orderId) {
//        return commonMapper.convertToResponse(orderService.getOrderById(orderId), OldOrderResponse.class);
//    }
//
//    public List<OldOrderItemResponse> getOrderItemsByOrderId(Long orderId) {
//        return commonMapper.convertToResponseList(orderService.getOrderItemsByOrderId(orderId), OldOrderItemResponse.class);
//    }
//

    public HeaderResponse<OrderResponseDTO> getAllOrders(Pageable pageable) {
        Page<OrderProjection> orders = orderService.getAllOrders(pageable);
        return commonMapper.getHeaderResponse(orders.getContent(), orders.getTotalPages(),
                orders.getTotalElements(), OrderResponseDTO.class);
    }

    public OrderResponseDTO updateOrderStatus(Long orderId, StatusType statusType) {
        Order order = orderService.updateOrderStatus(orderId, statusType);
        return commonMapper.convertToResponse(order, OrderResponseDTO.class);
    }

    public OrderResponseDTO changeOrderFull(Long orderId, OrderChangeRequestDTO orderRequest, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new InputFieldException(bindingResult);
        }

        Order updatedOrder = orderService.changeOrderFull(orderId, commonMapper.convertToEntity(orderRequest, Order.class));

        return commonMapper.convertToResponse(updatedOrder, OrderResponseDTO.class);
    }


//    public String deleteOrder(Long orderId) {
//        return orderService.deleteOrder(orderId);
//    }

    public OrderResponseDTO createOrder(OrderRequest orderRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InputFieldException(bindingResult);
        }
        Order order = orderService.createOrder(commonMapper.convertToEntity(orderRequest, Order.class));
        return commonMapper.convertToResponse(order, OrderResponseDTO.class);
    }


}
