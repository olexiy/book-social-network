package de.olexiy.demo.book_network.book;

import de.olexiy.demo.book_network.user.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookMapper bookMapper;

    public Integer save(@Valid BookRequest request, Authentication connectedUser) {
        User user = ((User) connectedUser.getPrincipal());
        return null;
    }
}
