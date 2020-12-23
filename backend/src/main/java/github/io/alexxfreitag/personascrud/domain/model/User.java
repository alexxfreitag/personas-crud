package github.io.alexxfreitag.personascrud.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    private UUID id;

    @Column(name = "name")
    @NotEmpty(message = "Name is required")
    private String name;

    @Column(name = "cpf")
    @NotEmpty(message = "Cpf is required")
    @Size(max = 11, message = "Cpf must contains only 11 numbers")
    private String cpf;

    @Column(name = "gender")
    private String gender;

    @Column(name = "email")
    @Email(message = "Email must be valid")
    private String email;

    @Column(name = "date_of_birth")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @NotBlank(message = "Date of birth is required")
    private LocalDate dateOfBirth;

    @Column(name = "nacionality")
    private String nacionality;

    @Column(name = "naturality", length = 2)
    @Size(max = 2, message = "Naturality must contains only 2 characters")
    private String naturality;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public User() {}

    public User(String name, String cpf, String gender, String email, LocalDate dateOfBirth, String nacionality, String naturality) {
        this.name = name;
        this.cpf = cpf;
        this.gender = gender;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.nacionality = nacionality;
        this.naturality = naturality;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNacionality() {
        return nacionality;
    }

    public void setNacionality(String nacionality) {
        this.nacionality = nacionality;
    }

    public String getNaturality() {
        return naturality;
    }

    public void setNaturality(String naturality) {
        this.naturality = naturality;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", nacionality='" + nacionality + '\'' +
                ", naturality='" + naturality + '\'' +
                '}';
    }
}
