package dev.peertosir.ownchaincrm.dto.request;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DetailAmountInSchemaRequestModel {
    @NotNull
    @Range(min=1, max=500, message = "Amount should be in range [0, 500]")
    private int amount;

    public DetailAmountInSchemaRequestModel() {
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
