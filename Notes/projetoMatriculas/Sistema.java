import java.util.*;

class Aluno{
    String id;
    Map<String, Disciplina> disciplinas;
    void matricular(Disciplina disciplina){
        if(disciplinas.containsKey(disciplina.id))
            return;
        disciplinas.put(disciplina.id, disciplina);
        disciplina.matricular(this);
    }

    void desmatricular(String idDisciplina){
        if(!disciplinas.containsKey(idDisciplina))
            return;
        Disciplina disciplina = disciplinas.remove(idDisciplina);
        disciplina.desmatricular(this.id);
    }
}

class Disciplina{
    String id;
    Map<String, Aluno> alunos;
    void matricular(Aluno aluno){
        if(alunos.containsKey(aluno.id))
            return;
        alunos.put(aluno.id, aluno);
        aluno.matricular(this);
    }
    void desmatricular(String idAluno){
        if(!alunos.containsKey(idAluno))
            return;
        Aluno aluno = alunos.remove(idAluno);
        aluno.desmatricular(this.id);
    }
}

class Sistema {
    Map<String, Aluno> alunos;
    Map<String, Aluno> disciplinas;

    void removerAluno(String idAluno){
        if(alunos.containsKey(idAluno))
            

    }
}
