package br.com.ekan.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BeneficiaryDTO {

    private static final long serialVersionUID = 1L;

    private Long id;

    @NotEmpty(message = "Name {field.not.blank}")
    @Size(min = 2, max = 150, message = "{field.size}")
    @ApiModelProperty(value = "Nome do Beneficiario", name = "name", dataType = "String", example = "Yone Rost")
    private String name;

    @NotEmpty(message = "Phone {field.not.blank}")
    @Size(min = 11, max = 11, message = "{field.size}")
    @ApiModelProperty(value = "Telefone", name = "phone", dataType = "String", example = "61998557744")
    private String phone;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "Data de Nascimento", name = "birthDate", dataType = "org.joda.time.LocalDate", example = "2000-01-01")
    private LocalDate birthDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "Data de Insercao dos dados", name = "addedDate", dataType = "org.joda.time.LocalDate", example = "2023-01-01")
    private LocalDate addedDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "Data de Atualizacao dos dados", name = "updatedDate", dataType = "org.joda.time.LocalDate", example = "2023-01-01")
    private LocalDate updatedDate;

    private List<DocumentDTO> documents;

}
