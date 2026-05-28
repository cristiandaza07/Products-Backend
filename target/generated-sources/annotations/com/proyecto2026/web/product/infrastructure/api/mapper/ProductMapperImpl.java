package com.proyecto2026.web.product.infrastructure.api.mapper;

import com.proyecto2026.web.product.application.command.create.CreateProductRequest;
import com.proyecto2026.web.product.application.command.update.UpdateProductRequest;
import com.proyecto2026.web.product.domain.entity.Product;
import com.proyecto2026.web.product.infrastructure.api.dto.CreateProductDto;
import com.proyecto2026.web.product.infrastructure.api.dto.ProductDto;
import com.proyecto2026.web.product.infrastructure.api.dto.ReviewDto;
import com.proyecto2026.web.product.infrastructure.api.dto.UpdateProductDto;
import com.proyecto2026.web.productDetail.domian.ProductDetail;
import com.proyecto2026.web.review.domain.Review;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-28T16:31:20-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public CreateProductRequest mapToCreateProductRequest(CreateProductDto createProductDto) {
        if ( createProductDto == null ) {
            return null;
        }

        String name = null;
        String description = null;
        Double price = null;
        MultipartFile file = null;

        name = createProductDto.getName();
        description = createProductDto.getDescription();
        price = createProductDto.getPrice();
        file = createProductDto.getFile();

        CreateProductRequest createProductRequest = new CreateProductRequest( name, description, price, file );

        return createProductRequest;
    }

    @Override
    public UpdateProductRequest mapToUpdateProductRequest(UpdateProductDto updateProductDto) {
        if ( updateProductDto == null ) {
            return null;
        }

        UpdateProductRequest updateProductRequest = new UpdateProductRequest();

        updateProductRequest.setId( updateProductDto.getId() );
        updateProductRequest.setName( updateProductDto.getName() );
        updateProductRequest.setDescription( updateProductDto.getDescription() );
        updateProductRequest.setPrice( updateProductDto.getPrice() );
        updateProductRequest.setProvider( updateProductDto.getProvider() );
        updateProductRequest.setReview( mapToReview( updateProductDto.getReview() ) );
        updateProductRequest.setCategoryId( updateProductDto.getCategoryId() );

        return updateProductRequest;
    }

    @Override
    public ProductDto mapToProductDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setProvider( productProductDetailProvider( product ) );
        productDto.setId( product.getId() );
        productDto.setName( product.getName() );
        productDto.setDescription( product.getDescription() );
        productDto.setPrice( product.getPrice() );
        productDto.setImage( product.getImage() );
        productDto.setReviews( reviewListToReviewDtoList( product.getReviews() ) );
        productDto.setCategories( mapToCategoryNames( product.getCategories() ) );

        return productDto;
    }

    @Override
    public Review mapToReview(ReviewDto reviewDto) {
        if ( reviewDto == null ) {
            return null;
        }

        Review.ReviewBuilder review = Review.builder();

        review.id( reviewDto.getId() );
        review.comment( reviewDto.getComment() );
        review.score( reviewDto.getScore() );

        return review.build();
    }

    private String productProductDetailProvider(Product product) {
        ProductDetail productDetail = product.getProductDetail();
        if ( productDetail == null ) {
            return null;
        }
        return productDetail.getProvider();
    }

    protected ReviewDto reviewToReviewDto(Review review) {
        if ( review == null ) {
            return null;
        }

        ReviewDto reviewDto = new ReviewDto();

        reviewDto.setId( review.getId() );
        reviewDto.setComment( review.getComment() );
        reviewDto.setScore( review.getScore() );

        return reviewDto;
    }

    protected List<ReviewDto> reviewListToReviewDtoList(List<Review> list) {
        if ( list == null ) {
            return null;
        }

        List<ReviewDto> list1 = new ArrayList<ReviewDto>( list.size() );
        for ( Review review : list ) {
            list1.add( reviewToReviewDto( review ) );
        }

        return list1;
    }
}
