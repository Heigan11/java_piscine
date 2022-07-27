package edu.school21.repositories;

import edu.school21.models.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ProductRepositoryJdbcImplTest {

    final List<Product> EXPECTED_FIND_ALL_PRODUCTS = Arrays.asList(
            new Product(1L, "Burn", 80),
            new Product(2L, "Adrenalin", 100),
            new Product(3L, "RedBull", 130),
            new Product(4L, "Slurm", 100500),
            new Product(5L, "Monster", 15)
            );

    final Product EXPECTED_FIND_BY_ID_PRODUCT = new Product(1L, "Burn", 80);
    final Product EXPECTED_UPDATED_PRODUCT = new Product(2L, "Adrenalin", 100);
    final Product EXPECTED_SAVED_PRODUCT = new Product(6L, "Vodka", 500);

    private EmbeddedDatabase dataSource;
    private ProductsRepositoryJdbcImpl repository;

    @BeforeEach
    void init() {
        dataSource = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.HSQL)
                .addScript("schema.sql")
                .addScript("data.sql")
                .build();

        repository = new ProductsRepositoryJdbcImpl(dataSource);
    }

    @Test
    void testFindAll() throws SQLException {
        Assertions.assertEquals(EXPECTED_FIND_ALL_PRODUCTS, repository.findAll());
    }

    @Test
    void testFindById() throws SQLException {
        Optional<Product> optionalProduct = repository.findById(1L);
        Assertions.assertTrue(optionalProduct.isPresent());
        Assertions.assertEquals(optionalProduct.get(), EXPECTED_FIND_BY_ID_PRODUCT);
    }

    @Test
    void testUpdate() throws SQLException {
        Optional<Product> optionalProduct = repository.findById(2L);
        Assertions.assertTrue(optionalProduct.isPresent());
        repository.update(EXPECTED_UPDATED_PRODUCT);
        optionalProduct = repository.findById(2L);
        Assertions.assertTrue(optionalProduct.isPresent());
        Assertions.assertEquals(optionalProduct.get(), EXPECTED_UPDATED_PRODUCT);
    }

    @Test
    void testSave() throws SQLException {
        repository.save(EXPECTED_SAVED_PRODUCT);
        Optional<Product> optionalProduct = repository.findById(6L);
        Assertions.assertTrue(optionalProduct.isPresent());
        Assertions.assertEquals(optionalProduct.get(), EXPECTED_SAVED_PRODUCT);
        Assertions.assertEquals(repository.findById(6L).get(), EXPECTED_SAVED_PRODUCT);
    }

    @Test
    void testDelete() throws SQLException {
        repository.delete(1L);
        Assertions.assertFalse(repository.findById(1L).isPresent());
    }

    @AfterEach
    void close() {
        dataSource.shutdown();
    }
}
