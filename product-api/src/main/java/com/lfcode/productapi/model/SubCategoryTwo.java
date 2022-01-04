package com.lfcode.productapi.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
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


}
