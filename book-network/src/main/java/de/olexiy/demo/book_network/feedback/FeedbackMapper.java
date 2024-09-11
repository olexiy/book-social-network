package de.olexiy.demo.book_network.feedback;

import de.olexiy.demo.book_network.book.Book;
import jakarta.validation.Valid;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class FeedbackMapper {
    public Feedback toFeedback(@Valid FeedbackRequest request) {
        return Feedback.builder()
                .note(request.note())
                .comment(request.comment())
                .book(Book.builder().id(request.bookId()).build())
                .build();
    }

    public FeedbackResponse toFeedbackResponse(Feedback f, Integer userId) {
        return FeedbackResponse.builder()
                .note(f.getNote())
                .comment(f.getComment())
                .ownFeedback(Objects.equals(f.getCreatedBy(), userId))
                .build();
    }
}
