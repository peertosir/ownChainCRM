package dev.peertosir.ownchaincrm.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
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
    @JsonManagedReference("details-schema")
    private Set<DetailSchema> schemas = new HashSet<>();

    @NotNull(message = "Price should be provided")
    private BigDecimal price;

    public Detail() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Set<DetailSchema> getSchemas() {
        return schemas;
    }

    public void setSchemas(Set<DetailSchema> schemas) {
        this.schemas = schemas;
    }
}
