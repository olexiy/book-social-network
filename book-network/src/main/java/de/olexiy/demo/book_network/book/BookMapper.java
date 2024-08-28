package de.olexiy.demo.book_network.book;

import org.springframework.stereotype.Service;

@Service
public class BookMapper {

    public Book toBook(BookRequest request){
        return Book.builder()
                .id(request.id())

                .build();
    }
}
