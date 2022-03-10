package com.lfcode.productapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "TB_SUB_CATEGORY")
public class SubCategory implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String subCategory;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name ="category_id")
    private Category category;




}
