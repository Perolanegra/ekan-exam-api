package br.com.ekan.service;

import br.com.ekan.dto.BeneficiaryDTO;

import java.util.List;

public interface RecipientService {

    /*
     * Cadastra um novo Beneficiario.
     *
     * @param BeneficiaryDTO, o Beneficiario que será criado.
     *
     * @return o Beneficiario que foi cadastrado.
     *
     * @throws Se existir um Beneficiario com o mesmo documento retorna uma mensagem de erro.
     *
     */

    BeneficiaryDTO create(BeneficiaryDTO beneficiaryDTO);

    /*
     * Atualiza um Beneficiario.
     *
     * @param BeneficiaryDTO, o Beneficiario que será atualizado.
     *
     * @param id, O id do Beneficiario que será atualizado.
     *
     * @return a Brand que foi atualizada.
     *
     */

    BeneficiaryDTO update(BeneficiaryDTO beneficiaryDTO, Long id);

    /*
     * Listar todos os Beneficiarios
     *
     * @return A lista de todas os Beneficiarios.
     *
     */
    List<BeneficiaryDTO> findAll();

    /*
     * Pesquisa uma Beneficiario pelo ID.
     *
     * @param id, O ID do Beneficiario que será pesquisado.
     *
     * @return o Beneficiarios que foi pesquisada.
     *
     */

    BeneficiaryDTO findById(Long id);

    /*
     * Excluir uma Brand pelo ID
     *
     * @param ID, Identificador d Beneficiario que será deletado.
     *
     * @return Um boolean confirmando que foi excluido.
     */
    Boolean delete(Long id);

}
