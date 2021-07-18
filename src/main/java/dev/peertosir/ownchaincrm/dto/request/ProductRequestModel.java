package dev.peertosir.ownchaincrm.dto.request;

import dev.peertosir.ownchaincrm.domain.Schema;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ProductRequestModel {
    private Long id;

    @NotNull
    private long schema;

    private boolean active;

    @NotBlank
    private String title;

    @NotNull(message = "Price should be provided")
    private BigDecimal price;

    private int hoursToProduce;

    public ProductRequestModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getSchema() {
        return schema;
    }

    public void setSchema(long schema) {
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
