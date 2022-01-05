package com.lfcode.productapi.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "TB_SUPPLIER")
public class Supplier implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 50, unique = true)
    private String nameSupplier;

  /*  @OneToMany(mappedBy = "supplier", fetch = FetchType.LAZY)
    private List<Product> product;*/


}
