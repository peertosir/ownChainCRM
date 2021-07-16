package dev.peertosir.ownchaincrm.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DetailSchemaId implements Serializable {

    @Column(name = "schema_id")
    private int schemaId;

    @Column(name = "detail_id")
    private int detailId;

    public DetailSchemaId() {
    }

    public DetailSchemaId(int schemaId, int detailId) {
        this.schemaId = schemaId;
        this.detailId = detailId;
    }

    public int getSchemaId() {
        return schemaId;
    }

    public void setSchemaId(int schemaId) {
        this.schemaId = schemaId;
    }

    public int getDetailId() {
        return detailId;
    }

    public void setDetailId(int detailId) {
        this.detailId = detailId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetailSchemaId that = (DetailSchemaId) o;
        return schemaId == that.schemaId && detailId == that.detailId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(schemaId, detailId);
    }
}
