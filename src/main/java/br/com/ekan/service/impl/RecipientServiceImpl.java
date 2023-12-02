package br.com.ekan.service.impl;

import br.com.ekan.dto.BeneficiaryDTO;
import br.com.ekan.error.ResourceNotAcceptableException;
import br.com.ekan.model.Beneficiary;
import br.com.ekan.repository.DocumentRepository;
import br.com.ekan.repository.RecipientRepository;
import br.com.ekan.service.RecipientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class RecipientServiceImpl implements RecipientService {

    @Autowired
    private RecipientRepository recipientRepository;

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public BeneficiaryDTO create(BeneficiaryDTO beneficiaryDTO) {
        validateDocument(beneficiaryDTO);
        var recipient = recipientRepository.save(this.modelMapper.map(beneficiaryDTO, Beneficiary.class));
        return this.modelMapper.map(recipient, BeneficiaryDTO.class);
    }


    @Override
    public BeneficiaryDTO update(BeneficiaryDTO beneficiaryDTO, Long id) {
        beneficiaryDTO.setId(id);
        existsById(id);
        validateDocument(beneficiaryDTO);
        var beneficiarSaved = recipientRepository.save(this.modelMapper.map(beneficiaryDTO, Beneficiary.class));
        return this.modelMapper.map(beneficiarSaved, BeneficiaryDTO.class);
    }

    @Override
    public List<BeneficiaryDTO> findAll() {
        var brands = recipientRepository.findAll();
        return brands.stream().map(brand -> this.modelMapper.map(brand, BeneficiaryDTO.class)).collect(Collectors.toList());
    }

    @Override
    public BeneficiaryDTO findById(Long id) {
        existsById(id);
        return this.modelMapper.map(recipientRepository.findById(id), BeneficiaryDTO.class);
    }

    @Override
    public Boolean delete(Long id) {
        existsById(id);
        recipientRepository.deleteById(id);
        return true;
    }

    private void existsById(Long id) {
        if (!recipientRepository.existsById(id)) {
            throw new ResourceNotAcceptableException("Nenhum Registro Encontrado!");
        }
    }

    private void validateDocument(BeneficiaryDTO beneficiaryDTO) {
        beneficiaryDTO.getDocuments().forEach(documentDTO -> {
            var documentSearched = documentRepository.findByDocumentTypeAndDesc(documentDTO.getDocumentType(), documentDTO.getDesc());
            if (documentSearched != null && documentDTO.getId() == null ||
                    documentSearched != null && documentDTO.getId() != null && !documentSearched.getId().equals(documentDTO.getId()))
                throw new ResourceNotAcceptableException("Documento já cadastrado!");
        });
    }


}
