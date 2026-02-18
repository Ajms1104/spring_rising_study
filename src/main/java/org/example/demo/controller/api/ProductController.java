//study_file controller
//상품 조회용 REST API /
package org.example.demo.controller.api;

import org.example.demo.controller.api.dto.ProductResponseDto;
import org.example.demo.repository.entity.Product;
import org.example.demo.service.usecases.IDisplayProductUseCase;

import java.util.List; //import할 때 List가 2개네.. 뭐지
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final IDisplayProductUseCase productService;

    //전체 상품 목록을 DTO로 반환
    @GetMapping("")
    @ResponseBody
    public ResponseEntity<List<ProductResponseDto>> listProducts() {
        List<Product> retrieved = productService.getProducts(null);
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(retrieved.stream().map(ProductResponseDto::from).toList());
    }

    //특정 상품 한 건을 DTO로 반환
    @GetMapping("/{productId}")
    @ResponseBody
    public ResponseEntity<ProductResponseDto> productDetail(@PathVariable Long productId){
        Product retrieved = productService.getProductById(productId);
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(ProductResponseDto.from(retrieved));
    }
}
