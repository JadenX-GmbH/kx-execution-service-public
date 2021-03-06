package com.jadenx.kxexecutionservice.rest;

import com.jadenx.kxexecutionservice.model.OrderDTO;
import com.jadenx.kxexecutionservice.model.OrderPatchDTO;
import com.jadenx.kxexecutionservice.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "/api/orders", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {

    private final OrderService orderService;

    public OrderController(final OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAllOrders(
        @RequestParam(defaultValue = "", name = "execution_job", required = false) final String id) {
        if (id.isBlank()) {
            return ResponseEntity.ok(orderService.findAll());
        }
        return ResponseEntity.ok(orderService.findAllByExecutionJob(Long.parseLong((id))));

    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrder(@PathVariable final Long id) {
        return ResponseEntity.ok(orderService.get(id));
    }

    @PostMapping
    public ResponseEntity<Long> createOrder(@RequestBody @Valid final OrderDTO orderDTO) {
        return new ResponseEntity<>(orderService.create(orderDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateOrder(@PathVariable final Long id,
                                            @RequestBody @Valid final OrderDTO orderDTO) {
        orderService.update(id, orderDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable final Long id) {
        orderService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> patchUpdateOrder(@PathVariable final Long id,
                                                 @RequestBody @Valid final OrderPatchDTO orderPatchDTO) {
        orderService.patchUpdate(id, orderPatchDTO);
        return ResponseEntity.ok().build();
    }
}
