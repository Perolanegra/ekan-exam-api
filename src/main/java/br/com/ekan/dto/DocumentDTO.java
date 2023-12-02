package br.com.ekan.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentDTO {

    private static final long serialVersionUID = 1L;

    private Long id;

    @NotEmpty(message = "Document Type {field.not.blank}")
    @Size(min = 2, max = 150, message = "{field.size}")
    @ApiModelProperty(value = "Tipo do Documento", name = "documentType", dataType = "String", example = "CNH")
    private String documentType;

    @NotEmpty(message = "Desc {field.not.blank}")
    @Size(min = 2, max = 500, message = "{field.size}")
    @ApiModelProperty(value = "Descricao do Documento", name = "desc", dataType = "String", example = "05035498755")
    private String desc;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "Data de Insercao dos dados", name = "addedDate", dataType = "org.joda.time.LocalDate", example = "2023-01-01")
    private LocalDate addedDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "Data de Atualizacao dos dados", name = "updatedDate", dataType = "org.joda.time.LocalDate", example = "2023-01-01")
    private LocalDate updatedDate;

}
