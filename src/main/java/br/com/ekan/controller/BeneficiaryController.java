package br.com.ekan.controller;

import br.com.ekan.dto.BeneficiaryDTO;
import br.com.ekan.service.RecipientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/beneficiary")
public class BeneficiaryController {

    @Autowired
    private RecipientService recipientService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BeneficiaryDTO>> findAll() {
        return new ResponseEntity(this.recipientService.findAll(), HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BeneficiaryDTO> create(@RequestBody BeneficiaryDTO beneficiaryDTO) {
        return new ResponseEntity(this.recipientService.create(beneficiaryDTO), HttpStatus.OK);
    }

    @PatchMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BeneficiaryDTO> update(@RequestBody @Valid BeneficiaryDTO beneficiaryDTO, @PathVariable("id") Long id) {
        return new ResponseEntity<>(this.recipientService.update(beneficiaryDTO, id), HttpStatus.OK);
    }

    @GetMapping(value = "/findById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BeneficiaryDTO> findById(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(this.recipientService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> delete(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(this.recipientService.delete(id), HttpStatus.OK);
    }


}
