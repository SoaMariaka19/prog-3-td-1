package app.prog.controller.response;

import app.prog.model.CategoryEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AuthorResponse {
    private int id;
    private String name;
    private String particularity;
    private boolean hasParticularity;
}
