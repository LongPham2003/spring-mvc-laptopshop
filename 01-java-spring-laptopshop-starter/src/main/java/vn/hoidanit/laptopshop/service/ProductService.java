package vn.hoidanit.laptopshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product saveProduct(Product product) {
        Product p = this.productRepository.save(product);
        return p;
    }

    public List<Product> feactProducts() {
        return this.productRepository.findAll();
    }

    public void deleteById(long id) {
        this.productRepository.deleteById(id);
    }

    public Optional<Product> findbyid(long id) {
        return this.productRepository.findById(id);
    }
}
