package br.edu.uniesp.softfact.domain.aluno;

import br.edu.uniesp.softfact.application.aluno.AlunoResponse;
import br.edu.uniesp.softfact.application.stack.VincularStackRequest;

public interface UpdateAlunoService {
    AlunoResponse criar(Aluno domain);
    AlunoResponse atualizar(Long id, Aluno domain);
    void excluir(Long id);

    AlunoResponse vincularStack(Long alunoId, VincularStackRequest request);
    AlunoResponse desvincularStack(Long alunoId, VincularStackRequest request);
}
