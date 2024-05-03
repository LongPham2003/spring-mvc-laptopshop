package vn.hoidanit.laptopshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import vn.hoidanit.laptopshop.domain.Order;
import vn.hoidanit.laptopshop.domain.OrderDetail;
import vn.hoidanit.laptopshop.domain.User;
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
        this.oderRepository.deleteById(id);
    }

    public void updateOrder(Order order) {
        // tìm oder muốn update
        Optional<Order> orDerOptional = this.fetchOrderById(order.getId());
        if (orDerOptional.isPresent()) {
            Order currentOrder = orDerOptional.get();// lấy ra đối tượng đó
            currentOrder.setStatus(order.getStatus());
            this.oderRepository.save(currentOrder);
        }
    }

    public List<Order> fetchOrderByUser(User user) {
        return this.oderRepository.findByUser(user);
    }

}
