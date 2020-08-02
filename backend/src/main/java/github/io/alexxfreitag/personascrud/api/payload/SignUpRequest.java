package github.io.alexxfreitag.personascrud.api.payload;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class SignUpRequest {

    @NotEmpty
    private String nome;

    @NotEmpty(message = "Cpf is required")
    @Size(min = 11, max = 11, message = "Cpf must contains only 11 numbers")
    private String cpf;

    public SignUpRequest() {}

    public SignUpRequest(@NotEmpty String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
