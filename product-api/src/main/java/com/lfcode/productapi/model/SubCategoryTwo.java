package com.lfcode.productapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Entity
@Table(name = "TB_SUB_CATEGORY_TWO")
public class SubCategoryTwo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 30)
    private String subCategoryTwo;

    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(name = "subCategoryOne_id", foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "subCategoryOne_fx"))
   private SubCategoryOne subCategoryOne;


    public SubCategoryTwo() {
    }

    public SubCategoryTwo(Long id, String subCategoryTwo) {
        this.id = id;
        this.subCategoryTwo = subCategoryTwo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubCategoryTwo() {
        return subCategoryTwo;
    }

    public void setSubCategoryTwo(String subCategoryTwo) {
        this.subCategoryTwo = subCategoryTwo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubCategoryTwo that = (SubCategoryTwo) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
