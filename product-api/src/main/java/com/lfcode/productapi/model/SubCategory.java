package com.lfcode.productapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_SUB_CATEGORIES")
public class SubCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 30)
    private String subCategory;

    @ManyToOne
    @JoinColumn(name = "category_id", foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "Category_fx"))
    private Category category;
}
