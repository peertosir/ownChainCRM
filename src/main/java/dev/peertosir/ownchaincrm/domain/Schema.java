package dev.peertosir.ownchaincrm.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.*;

@Entity
public class Schema {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @JsonManagedReference("schema-details")
    private Set<DetailSchema> details = new HashSet<>();

    public Schema() {

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

    public Set<DetailSchema> getDetails() {
        return details;
    }

    public void setDetails(Set<DetailSchema> details) {
        this.details = details;
    }

    public Schema updateWith(Schema schema) {
        this.setVendorCode(schema.getVendorCode());
        this.setTitle(schema.getTitle());
        this.setVendorCode(schema.getVendorCode());
        this.setDeveloper(schema.getDeveloper());
        return this;
    }
}
