package ru.breev.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "orders")
public class Orders implements Serializable {
    private static final long serialVersionUID = -2750973356670718107L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "customer_id")
    private Long customer_id;

    @Column(name = "product_id")
    private Long product_id;

    @Column(name = "cnt")
    private Integer cnt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public Orders() {
    }

    public Orders(Long customer_id, Long product_id, Integer cnt) {
        this.customer_id = customer_id;
        this.product_id = product_id;
        this.cnt = cnt;
    }
}

