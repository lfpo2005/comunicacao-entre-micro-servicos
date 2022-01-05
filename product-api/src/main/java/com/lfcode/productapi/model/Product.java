package com.lfcode.productapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "TB_PRODUCT")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nameProduct;

    private String SKU;

    @Column(nullable = false, columnDefinition = "Text")
    private String description;

    @Column(nullable = false)
    private Integer quantityAvailable;

    @Column(nullable = false, length = 10)
    private String weight;

    @Column(nullable = false, length = 10)
    private String height;

    @Column(nullable = false, length = 10)
    private String width;

    @Column(nullable = false, length = 10)
    private String depth;

    @Column(nullable = false)
    private BigDecimal price;

    private String linkYoutube;

    private Integer quantitySales;

    private Boolean active = Boolean.FALSE;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(updatable = false)
    private LocalDateTime creationDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime lastUpdateDate;

    @ManyToOne
    @JoinColumn(name = "supplier_id", nullable = false)
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "product", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Image> images = new ArrayList<Image>();

}
