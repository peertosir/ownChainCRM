package dev.peertosir.ownchaincrm.dto.request;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DetailSchemaRequestModel {
    @NotNull(message = "detailId should be provided")
    private long detailId;
    @NotNull(message = "amount should be provided")
    @Range(min=1, max=500, message = "Amount should be in range [0, 500]")
    private int amount;

    public DetailSchemaRequestModel() {
    }

    public long getDetailId() {
        return detailId;
    }

    public void setDetailId(long detailId) {
        this.detailId = detailId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
