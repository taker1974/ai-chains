package ru.spb.tksoft.chains.project.entity.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User entity.
 * 
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025
 */
@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    /** User ID. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long userId;

    /** User name. */
    @NotBlank(message = "name is required")
    @Size(min = 4, max = 32, message = "name must be between 4 and 32 characters")
    @Column(name = "name", nullable = false, length = 32)
    private String name;

    /** Password. */
    @NotBlank(message = "password is required")
    @Size(min = 8, max = 256, message = "password must be between 8 and 256 characters")
    @Column(name = "password", nullable = false, length = 256)
    private String password;

    /** First name. */
    @NotBlank(message = "first name is required")
    @Size(min = 2, max = 16, message = "first name must be between 2 and 16 characters")
    @Column(name = "first_name", nullable = false, length = 16)
    private String firstName;

    /** Last name. */
    @NotBlank(message = "last name is required")
    @Size(min = 2, max = 16, message = "last name must be between 2 and 16 characters")
    @Column(name = "last_name", nullable = false, length = 16)
    private String lastName;

    /** Phone. */
    @NotBlank(message = "phone is required")
    @Size(min = 11, max = 16, message = "phone must be between 11 and 16 characters")
    @Column(name = "phone", nullable = false, length = 16)
    private String phone;

    /** Role. */
    @NotBlank(message = "role is required")
    @Size(min = 1, max = 20, message = "role must be between 1 and 20 characters")
    @Column(name = "role", nullable = false, length = 20)
    private String role;
}
