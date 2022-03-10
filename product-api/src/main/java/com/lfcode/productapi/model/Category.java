package com.lfcode.productapi.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "TB_CATEGORY")
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String Category;

    @OneToMany(mappedBy = "category", orphanRemoval = true, cascade = CascadeType.ALL, fetch =  FetchType.LAZY)
    private List<SubCategory> subCategories = new ArrayList<SubCategory>();

}
