package wy.mn.ns.marinemanagementservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Schema(
        name = "Marine Creation DTO",
        description = "Schema for initial Marine Registration in the network"
)
public class MarineCreationDTO {

    @Schema(
            description = "First Name of the marine", example = "John"
    )
    @NotEmpty(message = "First Name can not be a null or empty")
    @Size(min = 2, max = 50, message = "The length of the marine first name should be between 2 and 50")
    private String firstName;

    @Schema(
            description = "Last Name of the marine", example = "Doe"
    )
    @NotEmpty(message = "Last Name can not be a null or empty")
    @Size(min = 2, max = 50, message = "The length of the marine Last name should be between 2 and 50")
    private String lastName;

    @Schema(
            description = "Corporate email of the marine", example = "john.doe@weyland.yutani.com"
    )
    @NotEmpty(message = "Email address can not be a null or empty")
    @Email(message = "Email address should be a valid value")
    private String email;

    @Schema(
            description = "Personal Password of the marine", example = "password"
    )
    @NotEmpty(message = "Password can not be a null or empty")
    private String password;

}
