package de.olexiy.demo.book_network.book;

import jakarta.validation.constraints.NotEmpty;

public record BookRequest(
        Integer id,
        @NotEmpty(message = "100")
        String title,
        @NotEmpty(message = "101")
        String authorName,
        @NotEmpty(message = "102")
        String isbn,
        String synopsis,
        boolean sharable

) {
}
