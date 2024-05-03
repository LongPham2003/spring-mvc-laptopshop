package vn.hoidanit.laptopshop.controller.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import vn.hoidanit.laptopshop.domain.Order;
import vn.hoidanit.laptopshop.domain.OrderDetail;
import vn.hoidanit.laptopshop.domain.Product;
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

    @GetMapping("admin/order/delete/{id}")
    public String getViewDeleteOrder(Model model, @PathVariable long id) {
        model.addAttribute("id", id);
        model.addAttribute("newOrder", new Order());
        return "admin/order/delete";
    }

    @PostMapping("/admin/order/delete")
    public String deleteProduct(Model model, @ModelAttribute("newOrder") Order order) {
        this.oderService.deleteOrderById(order.getId());
        return "redirect:/admin/order";
    }

    @GetMapping("/admin/order/update/{id}")
    public String getUpdateOrderPage(Model model, @PathVariable long id) {
        Optional<Order> currentOrder = this.oderService.fetchOrderById(id);
        model.addAttribute("newOrder", currentOrder.get());
        return "admin/order/update";
    }

    @PostMapping("/admin/order/update")
    public String handleUpdateOrder(@ModelAttribute("newOrder") Order order) {
        this.oderService.updateOrder(order);
        return "redirect:/admin/order";
    }

}
