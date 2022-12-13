package app.prog.controller.mapper;

import app.prog.controller.response.BookResponse;
import app.prog.controller.response.CreateBookResponse;
import app.prog.controller.response.UpdateBookResponse;
import app.prog.model.AuthorEntity;
import app.prog.model.BookEntity;
import app.prog.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BookRestMapper {
    private final AuthorRepository authorRepository;
    public BookResponse toRest(BookEntity domain) {
        AuthorEntity author = authorRepository.findByName(domain.getAuthor().getName());
        return BookResponse.builder()
                .id(domain.getId())
                .title(domain.getTitle())
                .author(author.getName())
                .categories(domain.getCategories())
                .hasAuthor(domain.hasAuthor())
                .build();
    }

    public BookEntity toDomain(CreateBookResponse rest) {
        AuthorEntity author = authorRepository.findByName(rest.getAuthor());

        return BookEntity.builder()
                .author(author)
                .title(rest.getTitle())
                .categories(rest.getCategories())
                .pageNumber(0) //Constraint not null in database, default value is 0
                .build();
    }

    public BookEntity toDomain(UpdateBookResponse rest) {
        AuthorEntity author = authorRepository.findByName(rest.getAuthor());

        return BookEntity.builder()
                .id(rest.getId())
                .author(author)
                .title(rest.getTitle())
                .categories(rest.getCategories())
                .pageNumber(0) //Constraint not null in database, default value is 0
                .build();
    }
}
