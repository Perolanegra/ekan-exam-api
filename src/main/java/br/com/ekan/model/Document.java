package br.com.ekan.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Document implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_document")
    private Long id;

    @NotEmpty(message = "Document Type {field.not.blank}")
    @Size(min = 2, max = 150, message = "{field.size}")
    @Column(name = "document_type", length = 150, nullable = false)
    @ApiModelProperty(value = "Tipo do Documento", name = "documentType", dataType = "String", example = "CNH")
    private String documentType;

    @NotEmpty(message = "Desc {field.not.blank}")
    @Size(min = 2, max = 500, message = "{field.size}")
    @Column(name = "desc", length = 500, nullable = false)
    @ApiModelProperty(value = "Descricao do Documento", name = "desc", dataType = "String", example = "05035498755")
    private String desc;

    @Column
    @ApiModelProperty(value = "Data de Insercao dos dados", name = "addedDate", dataType = "org.joda.time.LocalDate", example = "2023-01-01")
    private LocalDate addedDate;

    @Column
    @ApiModelProperty(value = "Data de Atualizacao dos dados", name = "updatedDate", dataType = "org.joda.time.LocalDate", example = "2023-01-01")
    private LocalDate updatedDate;

    @PrePersist
    public void prePersist() {
        addedDate = LocalDate.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedDate = LocalDate.now();
    }

}
