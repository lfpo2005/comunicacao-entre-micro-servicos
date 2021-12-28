package com.lfcode.productapi.dto;

import com.lfcode.productapi.model.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {

    private String description;

    public Category build(){
        Category category = new Category()
                .setDescription(this.description);
        return category;
    }
}
