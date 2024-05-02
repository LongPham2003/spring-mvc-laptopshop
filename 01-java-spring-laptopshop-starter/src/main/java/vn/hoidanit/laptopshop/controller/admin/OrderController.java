package vn.hoidanit.laptopshop.controller.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import vn.hoidanit.laptopshop.domain.Order;
import vn.hoidanit.laptopshop.domain.OrderDetail;
import vn.hoidanit.laptopshop.repository.OderRepository;
import vn.hoidanit.laptopshop.repository.OderdetailRepository;
import vn.hoidanit.laptopshop.service.OderService;

@Controller
public class OrderController {
    private final OderService oderService;

    public OrderController(OderService oderService) {
        this.oderService = oderService;
    }

    @GetMapping("/admin/order")
    public String getViewOrder(Model model) {
        List<Order> orders = this.oderService.fetchAllOrders();
        model.addAttribute("order", orders);
        return "admin/order/show";
    }

    @GetMapping("/admin/order/{id}")
    public String getViewOderDetail(Model model, @PathVariable long id) {
        Order order = this.oderService.fetchOrderById(id).get();
        model.addAttribute("order", order);
        model.addAttribute("id", id);
        model.addAttribute("orderDetails", order.getOrderDetail());
        return "admin/order/detail";

    }

}
