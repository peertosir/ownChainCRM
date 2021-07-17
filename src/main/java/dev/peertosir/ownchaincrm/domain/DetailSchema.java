package dev.peertosir.ownchaincrm.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class DetailSchema {

    @EmbeddedId
    private DetailSchemaId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("schemaId")
    @JsonBackReference("schema-details")
    private Schema schema;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("detailId")
    @JsonBackReference("details-schema")
    private Detail detail;

    @Column(name = "amount")
    private int amount;

    public DetailSchema() {
    }

    public DetailSchema(Schema schema, Detail detail, int amount) {
        this.schema = schema;
        this.detail = detail;
        this.id = new DetailSchemaId(schema.getId(), detail.getId());
        this.amount = amount;
    }

    public DetailSchemaId getId() {
        return id;
    }

    public Schema getSchema() {
        return schema;
    }

    public void setSchema(Schema schema) {
        this.schema = schema;
    }

    public Detail getDetail() {
        return detail;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetailSchema that = (DetailSchema) o;
        return schema.equals(that.schema) && detail.equals(that.detail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(schema, detail);
    }

}
