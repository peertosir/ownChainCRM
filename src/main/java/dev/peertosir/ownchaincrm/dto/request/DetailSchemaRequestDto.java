package dev.peertosir.ownchaincrm.dto.request;

import javax.validation.constraints.NotNull;

public class DetailSchemaRequestDto {
    @NotNull(message = "detailId should be provided")
    private int detailId;
    @NotNull(message = "amount should be provided")
    private int amount;

    public DetailSchemaRequestDto() {
    }

    public int getDetailId() {
        return detailId;
    }

    public void setDetailId(int detailId) {
        this.detailId = detailId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
