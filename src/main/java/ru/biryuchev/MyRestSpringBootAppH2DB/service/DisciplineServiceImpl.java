package ru.biryuchev.MyRestSpringBootAppH2DB.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.biryuchev.MyRestSpringBootAppH2DB.dao.DisciplineDAO;
import ru.biryuchev.MyRestSpringBootAppH2DB.entity.Discipline;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DisciplineServiceImpl implements DisciplineService {
    @Autowired
    private DisciplineDAO disciplineDAO;

    @Override
    @Transactional
    public List<Discipline> getAllDisciplines(){
        return disciplineDAO.getAllDisciplines();
    }

    @Override
    @Transactional
    public Discipline getDiscipline(int disid) { return disciplineDAO.getDiscipline(disid); }

    @Override
    @Transactional
    public Discipline saveDiscipline(Discipline discipline){
        return disciplineDAO.saveDiscipline(discipline);
    }

    @Override
    @Transactional
    public void deleteDiscipline(int disid) { disciplineDAO.deleteDiscipline(disid); }
}
