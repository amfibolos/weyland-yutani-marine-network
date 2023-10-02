package wy.mn.ns.marinemanagementservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Schema(
        name = "Marine DTO",
        description = "Schema to hold Marine related information"
)
public class MarineDTO {

    @Schema(
            description = "Internal ID of each Marine", example = "1"
    )
    @Positive
    @NotNull
    private Long id;

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
            description = "Military Rank of the marine", example = "Corporal"
    )
    private String militaryRank;

    @Schema(
            description = "Space Force of the marine", example = "Eridani"
    )
    private String spaceForce;

    @Schema(
            description = "Division of the marine", example = "3rd Colonial Marine Division"
    )
    private String division;

    @Schema(
            description = "Base of the marine", example = "Surier 430"
    )
    private String base;

    @Schema(
            description = "Identifying Serial Number of the marine", example = "b8fb5ac0-a38b-416e-819f-0819bc4f2e06"
    )
    private String idsn;

    @Schema(
            description = "Corporate email of the marine", example = "john.doe@weyland.yutani.com"
    )
    @NotEmpty(message = "Email address can not be a null or empty")
    @Email(message = "Email address should be a valid value")
    private String email;

    @Schema(
            description = "Timestamp of the creation date", example = "2020-06-14T15:50:36.068076300"
    )
    protected LocalDateTime createdAt;


    @Schema(
            description = "Who created the record", example = "admin"
    )
    protected String createdBy;

    @Schema(
            description = "Timestamp of the update date", example = "2021-06-14T15:50:36.068076300"
    )
    protected LocalDateTime updatedAt;

    @Schema(
            description = "Who updated the record", example = "admin"
    )
    protected String updatedBy;

}
