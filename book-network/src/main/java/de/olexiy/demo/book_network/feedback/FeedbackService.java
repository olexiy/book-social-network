package de.olexiy.demo.book_network.feedback;

import de.olexiy.demo.book_network.book.Book;
import de.olexiy.demo.book_network.book.BookRepository;
import de.olexiy.demo.book_network.common.PageResponse;
import de.olexiy.demo.book_network.exception.OperationNotPermitted;
import de.olexiy.demo.book_network.user.User;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FeedbackService {
    private final BookRepository bookRepository;
    private final FeedbackMapper feedbackMapper;
    private final FeedbackRepository feedbackRepository;

    public Integer save(@Valid FeedbackRequest request, Authentication connectedUser) {
        Book book = bookRepository.findById(request.bookId())
                .orElseThrow(() -> new EntityNotFoundException("Book not found with id: " + request.bookId()));
        if (book.isArchived() || !book.isShareable()) {
            throw new OperationNotPermitted("You cannot give a feedback an archived or not shareable book");
        }
        Feedback feedback = feedbackMapper.toFeedback(request);
        return feedbackRepository.save(feedback).getId();
    }

    public PageResponse<FeedbackResponse> findAllFeedbacksByBook(Integer bookId, Integer page, Integer size, Authentication connectedUser) {
        Pageable pageable = PageRequest.of(page, size);
        User user = (( User) connectedUser.getPrincipal());
        Page<Feedback> feedbacks = feedbackRepository.findAllByBookId(bookId, pageable);
        List<FeedbackResponse> feedbackResponses = feedbacks.stream().map(
                f -> feedbackMapper.toFeedbackResponse(f, user.getId())).toList();
         return new PageResponse<>(
                 feedbackResponses,
                 feedbacks.getNumber(),
                 feedbacks.getSize(),
                 feedbacks.getTotalElements(),
                 feedbacks.getTotalPages(),
                 feedbacks.isFirst(),
                 feedbacks.isLast());
    }
}
