package dev.peertosir.ownchaincrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Entity
public class Schema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Title should be provided")
    private String title;
    @NotBlank(message = "Vendor code should be provided")
    private String vendorCode;
    @NotBlank(message = "Developer should be provided")
    private String developer;

    @OneToMany(
            mappedBy = "schema",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<DetailSchema> details = new ArrayList<>();

    public Schema() {

    }

    public void addDetail(Detail detail, int amount) {
        DetailSchema detailSchema = new DetailSchema(this, detail, amount);
        details.add(detailSchema);
        detail.getSchemas().add(detailSchema);
    }

    public void removeDetail(Detail detail) {
        for (Iterator<DetailSchema> iterator = this.details.iterator(); iterator.hasNext();) {
            DetailSchema detailSchema = iterator.next();

            if (detailSchema.getDetail().equals(detail) && detailSchema.getSchema().equals(this)) {
                iterator.remove();
                detailSchema.getDetail().getSchemas().remove(detailSchema);
                detailSchema.setDetail(null);
                detailSchema.setSchema(null);
            }
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }
}
