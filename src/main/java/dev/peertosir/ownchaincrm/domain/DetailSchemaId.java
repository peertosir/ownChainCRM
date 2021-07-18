package dev.peertosir.ownchaincrm.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DetailSchemaId implements Serializable {

    @Column(name = "schema_id")
    private long schemaId;

    @Column(name = "detail_id")
    private long detailId;

    public DetailSchemaId() {
    }

    public DetailSchemaId(long schemaId, long detailId) {
        this.schemaId = schemaId;
        this.detailId = detailId;
    }

    public long getSchemaId() {
        return schemaId;
    }

    public void setSchemaId(long schemaId) {
        this.schemaId = schemaId;
    }

    public long getDetailId() {
        return detailId;
    }

    public void setDetailId(long detailId) {
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
