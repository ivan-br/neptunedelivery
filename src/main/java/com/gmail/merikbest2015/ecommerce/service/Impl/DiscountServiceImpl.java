package com.gmail.merikbest2015.ecommerce.service.Impl;

import com.gmail.merikbest2015.ecommerce.domain.Category;
import com.gmail.merikbest2015.ecommerce.domain.Discount;
import com.gmail.merikbest2015.ecommerce.domain.Product;
import com.gmail.merikbest2015.ecommerce.exception.ApiRequestException;
import com.gmail.merikbest2015.ecommerce.repository.CategoryRepository;
import com.gmail.merikbest2015.ecommerce.repository.DiscountRepository;
import com.gmail.merikbest2015.ecommerce.repository.ProductRepository;
import com.gmail.merikbest2015.ecommerce.service.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import static com.gmail.merikbest2015.ecommerce.constants.ErrorMessage.*;

@Service
@RequiredArgsConstructor
public class DiscountServiceImpl implements DiscountService {

    private final DiscountRepository discountRepository;

    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    @Override
    public Discount createDiscount(Discount discount) {
        switch(discount.getType()){
            case PRODUCT:
                Product product = productRepository.findById(discount.getRelationId()).orElseThrow(()->
                        new ApiRequestException(PRODUCT_NOT_FOUND, HttpStatus.NOT_FOUND));
                product.setDiscount(discount);
                productRepository.save(product);
                break;
            case CATEGORY:
                Category category = categoryRepository.findById(discount.getRelationId()).orElseThrow(()->
                        new ApiRequestException(CATEGORY_NOT_FOUND, HttpStatus.NOT_FOUND));
                category.setDiscount(discount);
                categoryRepository.save(category);
                break;
            default:
                throw new ApiRequestException(DISCOUNT_TYPE_NOT_EXIST, HttpStatus.NOT_FOUND);
        }
        return discountRepository.save(discount);
    }
}
