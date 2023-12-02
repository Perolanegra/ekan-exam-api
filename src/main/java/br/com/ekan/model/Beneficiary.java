package br.com.ekan.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Beneficiary implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recipient")
    private Long id;

    @NotEmpty(message = "Name {field.not.blank}")
    @Size(min = 2, max = 150, message = "{field.size}")
    @Column(name = "name", length = 150, nullable = false)
    @ApiModelProperty(value = "Nome do Beneficiario", name = "name", dataType = "String", example = "Yone Rost")
    private String name;

    @NotEmpty(message = "Phone {field.not.blank}")
    @Size(min = 11, max = 11, message = "{field.size}")
    @Column(name = "phone", length = 11, nullable = false)
    @ApiModelProperty(value = "Telefone", name = "phone", dataType = "String", example = "61998557744")
    private String phone;

    @Column
    @ApiModelProperty(value = "Data de Nascimento", name = "birthDate", dataType = "org.joda.time.LocalDate", example = "2000-01-01")
    private LocalDate birthDate;

    @Column
    @ApiModelProperty(value = "Data de Insercao dos dados", name = "addedDate", dataType = "org.joda.time.LocalDate", example = "2023-01-01")
    private LocalDate addedDate;

    @Column
    @ApiModelProperty(value = "Data de Atualizacao dos dados", name = "updateDate", dataType = "org.joda.time.LocalDate", example = "2023-01-01")
    private LocalDate updateDate;


    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Document> documents;

    @PrePersist
    public void prePersist() {
        addedDate = LocalDate.now();
        updateDate = LocalDate.now();
    }

    @PreUpdate
    public void preUpdate() {
        updateDate = LocalDate.now();
    }

}
