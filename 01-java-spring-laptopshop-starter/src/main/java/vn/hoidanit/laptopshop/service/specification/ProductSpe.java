package vn.hoidanit.laptopshop.service.specification;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.domain.Product_;

public class ProductSpe {

    // case name
    public static Specification<Product> nameLike(String name) {
        return (root, query, criteraBuilder) -> criteraBuilder.like(root.get(Product_.NAME), "%" + name + "%");
    }

    // case min price
    public static Specification<Product> minPrice(double price) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.ge(root.get(Product_.PRICE), price);
    }

    // case max price
    public static Specification<Product> maxPrice(double price) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.le(root.get(Product_.PRICE), price);
    }

    /// case factory

    public static Specification<Product> factoryLike(String factory) {
        return (root, query, criteraBuilder) -> criteraBuilder.equal(root.get(Product_.FACTORY), "%" + factory + "%");
    }

    // case factorys tìm 1 lúc nhiều điều kiện target
    public static Specification<Product> matchListTarget(List<String> target) {
        return (root, query, criteraBuilder) -> criteraBuilder.in(root.get(Product_.TARGET)).value(target);
    }

    // case factorys tìm 1 lúc nhiều điều kiện factory

    public static Specification<Product> factorysLike(List<String> factory) {
        return (root, query, criteraBuilder) -> criteraBuilder.in(root.get(Product_.FACTORY)).value(factory);
    }

    // case price
    public static Specification<Product> matchPrice(double min, double max) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.and(
                criteriaBuilder.gt(root.get(Product_.PRICE), min), // lớn hơn hoặc bằng
                criteriaBuilder.le(root.get(Product_.PRICE), max));// bé hơn hoặc bằng
    }

    // case 6
    public static Specification<Product> matchMultiplePice(double min, double max) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.between(root.get(Product_.PRICE), min, max);

    }
}
