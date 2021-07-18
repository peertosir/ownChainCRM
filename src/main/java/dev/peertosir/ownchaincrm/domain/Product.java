package dev.peertosir.ownchaincrm.domain;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(optional = false, cascade = CascadeType.PERSIST )
    @JoinColumn(name = "schema_id", referencedColumnName = "id", nullable = false)
    @NotNull
    private Schema schema;

    @ColumnDefault("false")
    private boolean active;

    @NotBlank
    private String title;

    @NotNull(message = "Price should be provided")
    private BigDecimal price;

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
