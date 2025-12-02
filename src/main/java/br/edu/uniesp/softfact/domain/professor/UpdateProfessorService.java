package br.edu.uniesp.softfact.domain.professor;

import br.edu.uniesp.softfact.application.professor.ProfessorResponse;

public interface UpdateProfessorService {

    ProfessorResponse criar(Professor domain);

    ProfessorResponse atualizar(Long id, Professor domain);

    void excluir(Long id);
}
