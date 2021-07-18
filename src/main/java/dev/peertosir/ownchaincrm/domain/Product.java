package dev.peertosir.ownchaincrm.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(optional = false, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "schema_id", referencedColumnName = "id", nullable = false, unique = false)
    @NotNull
    @JsonManagedReference("product-schema")
    private Schema schema;

    @ColumnDefault("false")
    private boolean active;

    @NotBlank
    private String title;

    @NotNull(message = "Price should be provided")
    @Range(min=1, max=2000000000, message = "Price should be in range [0, 2000000000]")
    private BigDecimal price;

    @Range(min=1, max=9000, message = "Amount should be in range [0, 500]")
    private int hoursToProduce;

    public Product() {
    }

    public Product(Schema schema, boolean active, BigDecimal price, int hoursToProduce) {
        this.schema = schema;
        this.active = active;
        this.price = price;
        this.hoursToProduce = hoursToProduce;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Schema getSchema() {
        return schema;
    }

    public void setSchema(Schema schema) {
        this.schema = schema;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getHoursToProduce() {
        return hoursToProduce;
    }

    public void setHoursToProduce(int hoursToProduce) {
        this.hoursToProduce = hoursToProduce;
    }

}
