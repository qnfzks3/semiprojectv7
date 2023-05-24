package qnfzks3.semiprojectv7.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name="pdsattach")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PdsAttach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pano;
    private String fname;
    private String ftype;

    private String fsize;

    @Column(insertable = false,updatable = false)
    private String fdown;

    private Integer pno;

}
