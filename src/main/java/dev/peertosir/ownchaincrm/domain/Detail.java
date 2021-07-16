package dev.peertosir.ownchaincrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Vendor code is mandatory")
    private String vendorCode;
    @NotBlank(message = "Title is mandatory")
    private String title;
    private String description;

    @OneToMany(
            mappedBy = "detail",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<DetailSchema> schemas = new ArrayList<>();

    @NotNull(message = "Price should be provided")
    private BigDecimal price;

    public Detail() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<DetailSchema> getSchemas() {
        return schemas;
    }

    public void setSchemas(List<DetailSchema> schemas) {
        this.schemas = schemas;
    }

    public Detail updateWith(Detail newDetail) {
        this.setVendorCode(newDetail.getVendorCode());
        this.setTitle(newDetail.getTitle());
        this.setDescription(newDetail.getDescription());
        return this;
    }
}
