package vn.hoidanit.laptopshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.hoidanit.laptopshop.domain.OrderDetail;

@Repository
public interface OderdetailRepository extends JpaRepository<OrderDetail, Long> {

}
