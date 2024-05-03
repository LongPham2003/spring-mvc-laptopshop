package vn.hoidanit.laptopshop.controller.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.service.ProductService;
import vn.hoidanit.laptopshop.service.UploadService;

@Controller
public class ProductController {

    private ProductService productService;
    private UploadService uploadService;

    public ProductController(ProductService productService, UploadService uploadService) {
        this.productService = productService;
        this.uploadService = uploadService;
    }

    @GetMapping("/admin/product")
    public String getDashboard(Model model, @RequestParam("page") Optional<String> pageOptional) {
        int page = 1;

        try {
            if (pageOptional.isPresent()) {
                // người dùng truyền lên khi click vào option page
                page = Integer.parseInt(pageOptional.get());
            } else {
                // page =1
            }
        } catch (Exception e) {
            // page =1
            // TODO: handle exception
        }
        Pageable pageable = PageRequest.of(page - 1, 2);
        Page<Product> product = this.productService.fetchProducts(pageable);
        List<Product> products = product.getContent();
        model.addAttribute("pr", products);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPage", product.getTotalPages());
        return "admin/product/show";
    }

    @GetMapping("/admin/product/create")
    public String getCreateProductpage(Model model) {
        model.addAttribute("newProduct", new Product());
        return "admin/product/create";
    }

    @PostMapping("/admin/product/create")
    public String creatProduct(Model model, @ModelAttribute("newProduct") Product product,
            @RequestParam("productImgFile") MultipartFile file) {
        String pri = this.uploadService.handleSaveUploadFile(file, "product");
        product.setImage(pri);
        this.productService.saveProduct(product);
        return "redirect:/admin/product";
    }

    @GetMapping("/admin/product/delete/{id}")
    public String getdeleteProductByID(Model model, @PathVariable long id) {
        model.addAttribute("id", id);
        model.addAttribute("newProduct", new Product());
        return "admin/product/delete";

    }

    @PostMapping("/admin/product/delete")
    public String deleteProduct(Model model, @ModelAttribute("newPoduct") Product pr) {
        this.productService.deleteById(pr.getId());
        return "redirect:/admin/product";
    }

    @RequestMapping("/admin/product/{id}")
    public String getProductDetailPage(Model model, @PathVariable long id) {
        Product pr = this.productService.findbyid(id).get();
        model.addAttribute("productdetail", pr);
        model.addAttribute("id", id);
        return "admin/product/detail";
    }

    @RequestMapping("/admin/product/update/{id}")
    public String getUpdateProductPage(Model model, @PathVariable long id) {
        Product updateProduct = this.productService.findbyid(id).get();
        model.addAttribute("newProduct", updateProduct);
        return "admin/product/update";
    }

    @PostMapping("/admin/product/update")
    public String handleUpdateProduct(@ModelAttribute("newProduct") Product pr,
            @RequestParam("productImgFile") MultipartFile file) {

        Product currentProduct = this.productService.findbyid(pr.getId()).get();
        if (currentProduct != null) {

            if (!file.isEmpty()) {
                String img = this.uploadService.handleSaveUploadFile(file, "product");
                currentProduct.setImage(img);
            }

            currentProduct.setName(pr.getName());
            currentProduct.setPrice(pr.getPrice());
            currentProduct.setQuantity(pr.getQuantity());
            currentProduct.setDetailDesc(pr.getDetailDesc());
            currentProduct.setShortDesc(pr.getShortDesc());
            currentProduct.setFactory(pr.getFactory());
            currentProduct.setTarget(pr.getTarget());

            this.productService.saveProduct(currentProduct);
        }

        return "redirect:/admin/product";
    }

}
