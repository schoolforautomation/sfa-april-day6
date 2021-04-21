package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class SignUp {

    private int courseIndex;

    private int levelIndex;

    private String studentName;

    private String email;

    private String message;
}
