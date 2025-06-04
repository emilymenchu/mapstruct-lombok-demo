package com.mapstructcourse.mapstruct_lombok_demo.mapper;

import com.mapstructcourse.mapstruct_lombok_demo.dto.GetProduct;
import com.mapstructcourse.mapstruct_lombok_demo.entity.Product;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {CategoryMapper.class})
public interface ProductMapper {

    @Mappings({
        @Mapping(source = "id", target = "productId"),
        @Mapping(source = "name", target = "productName"),
        @Mapping(source = "creationDate", target = "creationDate", dateFormat = "yyyy-MM-dd HH:mm:ss"),
        @Mapping(source = "category", target = "productCategory"),
        @Mapping(source = "price", target = "price", numberFormat = "$#0.00"),
    })
    GetProduct toGetDTO(Product product);
    List<GetProduct> toGetDtoList(List<Product> products);

    @InheritInverseConfiguration
//    @Mapping(target = "creationDate", ignore = true)
    Product toProduct(GetProduct getProduct);
    List<Product> toProductList(List<GetProduct> getProductList);
}
