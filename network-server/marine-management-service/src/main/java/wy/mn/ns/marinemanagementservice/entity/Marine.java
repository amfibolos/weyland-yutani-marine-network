package wy.mn.ns.marinemanagementservice.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "marines")
public class Marine extends BaseDateEntity {

    @Builder
    public Marine(LocalDateTime createdAt, String createdBy, LocalDateTime updatedAt, String updatedBy, Long id, String firstName, String lastName, String militaryRank, String spaceForce, String division, String base, String idsn, String email) {
        super(createdAt, createdBy, updatedAt, updatedBy);
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.militaryRank = militaryRank;
        this.spaceForce = spaceForce;
        this.division = division;
        this.base = base;
        this.idsn = idsn;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "military_rank")
    private String militaryRank;

    @Column(name = "space_force")
    private String spaceForce;

    @Column(name = "division")
    private String division;

    @Column(name = "base")
    private String base;

    @Column(name = "idsn", nullable = false)
    private String idsn;

    @Column(name = "email", nullable = false)
    private String email;

    @PrePersist
    protected void onPrePersist() {
        this.setIdsn(UUID.randomUUID().toString());
        this.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()).toLocalDateTime());
        this.setCreatedBy("Admin");
    }

    @PreUpdate
    protected void onPreUpdate() {
        this.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()).toLocalDateTime());
        this.setUpdatedBy("Admin");
    }

}
