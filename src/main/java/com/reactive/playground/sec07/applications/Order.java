package com.reactive.playground.sec07.applications;

public record Order(Integer userId,
                    String productName,
                    Integer price) {
}
