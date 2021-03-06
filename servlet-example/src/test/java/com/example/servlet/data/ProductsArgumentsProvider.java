package com.example.servlet.data;

import com.example.servlet.entity.ProductEntity;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.Arrays;
import java.util.stream.Stream;

public class ProductsArgumentsProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of(
            Arguments.of(
                Arrays.asList(
                    ProductEntity.builder().build(),
                    ProductEntity.builder().build(),
                    ProductEntity.builder().build(),
                    ProductEntity.builder().build()
                )
            )
        );
    }
}
