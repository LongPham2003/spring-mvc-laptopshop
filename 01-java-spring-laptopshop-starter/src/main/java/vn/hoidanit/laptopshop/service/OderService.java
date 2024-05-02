package vn.hoidanit.laptopshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import vn.hoidanit.laptopshop.domain.Order;
import vn.hoidanit.laptopshop.domain.OrderDetail;
import vn.hoidanit.laptopshop.repository.OderRepository;
import vn.hoidanit.laptopshop.repository.OderdetailRepository;

@Service
public class OderService {

    private final OderRepository oderRepository;
    private final OderdetailRepository oderdetailRepository;

    public OderService(OderRepository oderRepository, OderdetailRepository oderdetailRepository) {
        this.oderRepository = oderRepository;
        this.oderdetailRepository = oderdetailRepository;
    }

    public List<Order> fetchAllOrders() {
        return this.oderRepository.findAll();
    }

    public Optional<Order> fetchOrderById(long id) {
        return this.oderRepository.findById(id);
    }

    public void deleteOrderById(long id) {
        Optional<Order> orderOptional = this.fetchOrderById(id);
        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            List<OrderDetail> orderDetails = order.getOrderDetail();
            for (OrderDetail od : orderDetails) {
                this.oderdetailRepository.deleteById(od.getId());
            }
        }
    }

}
