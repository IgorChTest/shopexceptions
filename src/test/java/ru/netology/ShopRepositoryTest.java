package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    ShopRepository repo = new ShopRepository();

    Product product1 = new Product(1, "Book", 300);
    Product product2 = new Product(2, "T-shirt", 1000);
    Product product3 = new Product(3, "Phone", 10_000);


    @Test
    public void shouldRemoveProduct() {
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.removeById(2);

        Product[] expected = { product1, product3 };
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testNotFoundException() {
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(10);
        });
    }
}