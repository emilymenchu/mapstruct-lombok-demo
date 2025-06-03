package com.mapstructcourse.mapstruct_lombok_demo.mapper;

import com.mapstructcourse.mapstruct_lombok_demo.dto.GetProduct;
import com.mapstructcourse.mapstruct_lombok_demo.entity.Product;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {CategoryMapper.class})
public interface ProductMapper {

    @Mappings({
        @Mapping(source = "creationDate", target = "creationDate", dateFormat = "yyyy-MM-dd HH:mm:ss")
    })
    GetProduct toGetDTO(Product product);
    List<GetProduct> toGetDtoList(List<Product> products);

    @InheritInverseConfiguration
    Product toProduct(GetProduct getProduct);
    List<Product> toProductList(List<GetProduct> getProductList);
}
