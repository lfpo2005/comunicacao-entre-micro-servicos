package com.lfcode.productapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "TB_SUB_CATEGORY_ONE")
public class SubCategoryOne implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 30)
    private String subCategoryOne;

    @OneToMany(mappedBy = "subCategoryOne", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SubCategoryTwo> SubCategoryTwos = new ArrayList<SubCategoryTwo>();

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "category_id", foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "category_fx"))
    private Category category;

    public SubCategoryOne() {
    }

    public SubCategoryOne(Long id, String subCategoryOne, List<SubCategoryTwo> subCategoryTwos, Category category) {
        this.id = id;
        this.subCategoryOne = subCategoryOne;
        SubCategoryTwos = subCategoryTwos;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubCategoryOne() {
        return subCategoryOne;
    }

    public void setSubCategoryOne(String subCategoryOne) {
        this.subCategoryOne = subCategoryOne;
    }

    public List<SubCategoryTwo> getSubCategoryTwos() {
        return SubCategoryTwos;
    }

    public void setSubCategoryTwos(List<SubCategoryTwo> subCategoryTwos) {
        SubCategoryTwos = subCategoryTwos;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubCategoryOne that = (SubCategoryOne) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
