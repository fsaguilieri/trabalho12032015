package br.unicesumar.restserver.disciplina;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/disciplinas")
@Transactional
public class DisciplinaController {

    @Autowired
    private EntityManager em;
    
    private List<Disciplina> disciplinas = new ArrayList();

    @RequestMapping(method = RequestMethod.GET)
    public List<Disciplina> getDisciplina() {
        return disciplinas;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public Exception criarDisciplina(@RequestBody Disciplina disciplina) {
        if(!disciplinas.contains(disciplina)){
            disciplinas.add(disciplina);
        }else{
            return new Exception("Disciplina Já Existe");
        }
        return null;
        
    }        
    
    @RequestMapping(method = RequestMethod.PUT)
    public void alterarDisciplina(@RequestBody Disciplina disciplina) {
    }        
    
    @RequestMapping(method = RequestMethod.DELETE)
    public void excluirDisciplina(@PathVariable Long id) {
    }        
    
}