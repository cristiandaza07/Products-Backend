package com.proyecto2026.web.product.infrastructure.database.mapper;

import com.proyecto2026.web.category.domain.entity.Category;
import com.proyecto2026.web.category.infrastructure.database.entity.CategoryEntity;
import com.proyecto2026.web.product.domain.entity.Product;
import com.proyecto2026.web.product.infrastructure.database.entity.ProductEntity;
import com.proyecto2026.web.productDetail.domian.ProductDetail;
import com.proyecto2026.web.productDetail.infrastructure.ProductDetailEntity;
import com.proyecto2026.web.review.domain.Review;
import com.proyecto2026.web.review.infrastructure.ReviewEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-28T16:31:20-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class ProductEntityMapperImpl implements ProductEntityMapper {

    @Override
    public ProductEntity mapToProductEntity(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductEntity productEntity = new ProductEntity();

        productEntity.setProductDetailEntity( productDetailToProductDetailEntity( product.getProductDetail() ) );
        productEntity.setId( product.getId() );
        productEntity.setName( product.getName() );
        productEntity.setDescription( product.getDescription() );
        productEntity.setPrice( product.getPrice() );
        productEntity.setImage( product.getImage() );
        productEntity.setReviews( reviewListToReviewEntityList( product.getReviews() ) );
        productEntity.setCategories( categoryListToCategoryEntityList( product.getCategories() ) );

        linkReviews( productEntity );

        return productEntity;
    }

    @Override
    public Product mapToProduct(ProductEntity productEntity) {
        if ( productEntity == null ) {
            return null;
        }

        Product.ProductBuilder product = Product.builder();

        product.productDetail( productDetailEntityToProductDetail( productEntity.getProductDetailEntity() ) );
        product.id( productEntity.getId() );
        product.name( productEntity.getName() );
        product.description( productEntity.getDescription() );
        product.price( productEntity.getPrice() );
        product.image( productEntity.getImage() );
        product.reviews( reviewEntityListToReviewList( productEntity.getReviews() ) );
        product.categories( categoryEntityListToCategoryList( productEntity.getCategories() ) );

        return product.build();
    }

    @Override
    public Review mapToReview(ReviewEntity reviewEntity) {
        if ( reviewEntity == null ) {
            return null;
        }

        Review.ReviewBuilder review = Review.builder();

        review.id( reviewEntity.getId() );
        review.comment( reviewEntity.getComment() );
        review.score( reviewEntity.getScore() );

        return review.build();
    }

    @Override
    public ReviewEntity mapToReviewEntity(Review review) {
        if ( review == null ) {
            return null;
        }

        ReviewEntity reviewEntity = new ReviewEntity();

        reviewEntity.setId( review.getId() );
        reviewEntity.setComment( review.getComment() );
        reviewEntity.setScore( review.getScore() );

        return reviewEntity;
    }

    @Override
    public Category mapToCategory(CategoryEntity categoryEntity) {
        if ( categoryEntity == null ) {
            return null;
        }

        Category.CategoryBuilder category = Category.builder();

        category.id( categoryEntity.getId() );
        category.name( categoryEntity.getName() );

        return category.build();
    }

    @Override
    public CategoryEntity mapToCategoryEntity(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryEntity categoryEntity = new CategoryEntity();

        categoryEntity.setId( category.getId() );
        categoryEntity.setName( category.getName() );

        return categoryEntity;
    }

    protected ProductDetailEntity productDetailToProductDetailEntity(ProductDetail productDetail) {
        if ( productDetail == null ) {
            return null;
        }

        ProductDetailEntity productDetailEntity = new ProductDetailEntity();

        productDetailEntity.setId( productDetail.getId() );
        productDetailEntity.setSpecifications( productDetail.getSpecifications() );
        productDetailEntity.setWarranty( productDetail.getWarranty() );
        productDetailEntity.setProvider( productDetail.getProvider() );

        return productDetailEntity;
    }

    protected List<ReviewEntity> reviewListToReviewEntityList(List<Review> list) {
        if ( list == null ) {
            return null;
        }

        List<ReviewEntity> list1 = new ArrayList<ReviewEntity>( list.size() );
        for ( Review review : list ) {
            list1.add( mapToReviewEntity( review ) );
        }

        return list1;
    }

    protected List<CategoryEntity> categoryListToCategoryEntityList(List<Category> list) {
        if ( list == null ) {
            return null;
        }

        List<CategoryEntity> list1 = new ArrayList<CategoryEntity>( list.size() );
        for ( Category category : list ) {
            list1.add( mapToCategoryEntity( category ) );
        }

        return list1;
    }

    protected ProductDetail productDetailEntityToProductDetail(ProductDetailEntity productDetailEntity) {
        if ( productDetailEntity == null ) {
            return null;
        }

        ProductDetail.ProductDetailBuilder productDetail = ProductDetail.builder();

        productDetail.id( productDetailEntity.getId() );
        productDetail.specifications( productDetailEntity.getSpecifications() );
        productDetail.warranty( productDetailEntity.getWarranty() );
        productDetail.provider( productDetailEntity.getProvider() );

        return productDetail.build();
    }

    protected List<Review> reviewEntityListToReviewList(List<ReviewEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<Review> list1 = new ArrayList<Review>( list.size() );
        for ( ReviewEntity reviewEntity : list ) {
            list1.add( mapToReview( reviewEntity ) );
        }

        return list1;
    }

    protected List<Category> categoryEntityListToCategoryList(List<CategoryEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<Category> list1 = new ArrayList<Category>( list.size() );
        for ( CategoryEntity categoryEntity : list ) {
            list1.add( mapToCategory( categoryEntity ) );
        }

        return list1;
    }
}
