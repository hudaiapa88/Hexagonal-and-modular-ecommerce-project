package com.uc.catalogintegration.category;

import com.uc.catalog.IT;
import com.uc.catalogcatalog.ResponseSpec;
import com.uc.catalogadapters.category.jpa.repository.CategoryRepository;
import com.uc.catalogadapters.category.rest.request.CreateCategoryRequest;
import com.uc.catalog.adapters.category.rest.response.CategoryResponse;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@Tag("category")
@IT
public class CategoryControllerTest{

    @Autowired
    CategoryRepository categoryRepository;
    @Nested
    class Create {
       @Test
        void testCreate() {
            CreateCategoryRequest createCategoryRequest=buildCreateCategoryRequest();
            CategoryResponse categoryResponse=given()
                    .contentType(ContentType.JSON).body(createCategoryRequest).when().post(path())
                    .then().log().all()
                    .spec(ResponseSpec.isCreatedResponse()).extract().body().as(CategoryResponse.class);
            assertThat(categoryRepository.findById(categoryResponse.getId()).isPresent()).isTrue();
            assertThat(createCategoryRequest).isEqualToIgnoringNullFields(categoryResponse);
        }

        private String path() {
            return String.format("/category");
        }
    }

    private CreateCategoryRequest buildCreateCategoryRequest() {
        CreateCategoryRequest createCategoryRequest= new CreateCategoryRequest();
        createCategoryRequest.setTitle("Ev-Eşya");
        return createCategoryRequest;
    }
}
