package ru.biryuchev.MyRestSpringBootAppH2DB.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.biryuchev.MyRestSpringBootAppH2DB.entity.Discipline;
import ru.biryuchev.MyRestSpringBootAppH2DB.entity.Student;
import ru.biryuchev.MyRestSpringBootAppH2DB.service.DisciplineService;
import ru.biryuchev.MyRestSpringBootAppH2DB.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private DisciplineService disciplineService;

    @GetMapping("/students")
    public Object[] showAllStudents(){
        Object[] res;
        String mes;
        List<Student> allStudents = studentService.getAllStudents();

        if(allStudents.isEmpty()) {
            mes = "В базе нет записей";
            res = new Object[1];
        } else {
            mes = "Операция выполнена успешно";
            res = new Object[2];
            res[1] = allStudents;
        }

        res[0] = mes;

        return res;
    }

    @GetMapping("/students/{id}")
    public Object[] getStudent(@PathVariable("id") int id) {
        Object[] res;
        String mes;
        Student student = studentService.getStudent(id);

        if(student == null) {
            mes = "Запись не найдена";
            res = new Object[1];
        } else {
            mes = "Операция выполнена успешно";
            res = new Object[2];
            res[1] = student;
        }

        res[0] = mes;

        return res;
    }

    @PostMapping("/students")
    public Student saveStudent(@RequestBody Student student) { return studentService.saveStudent(student); }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student){
        studentService.saveStudent(student);
        return student;
    }

    @DeleteMapping("/students/{id}")
    public void updateStudent(@PathVariable("id") int id) { studentService.deleteStudent(id); }


    @GetMapping("/disciplines")
    public Object[] showAllDisciplines(){
        Object[] res;
        String mes;
        List<Discipline> allDisciplines = disciplineService.getAllDisciplines();

        if(allDisciplines.isEmpty()) {
            mes = "В базе нет записей";
            res = new Object[1];
        } else {
            mes = "Операция выполнена успешно";
            res = new Object[2];
            res[1] = allDisciplines;
        }

        res[0] = mes;

        return res;
    }

    @GetMapping("/disciplines/{id}")
    public Object[] getDisciplines(@PathVariable("id") int disid) {
        Object[] res;
        String mes;
        Discipline discipline = disciplineService.getDiscipline(disid);

        if(discipline == null) {
            mes = "Запись не найдена";
            res = new Object[1];
        } else {
            mes = "Операция выполнена успешно";
            res = new Object[2];
            res[1] = discipline;
        }

        res[0] = mes;

        return res;
    }

    @PostMapping("/disciplines")
    public Discipline saveDiscipline(@RequestBody Discipline discipline) { return disciplineService.saveDiscipline(discipline); }

    @PutMapping("/disciplines")
    public Discipline updateDiscipline(@RequestBody Discipline discipline){
        disciplineService.saveDiscipline(discipline);
        return discipline;
    }

    @DeleteMapping("/disciplines/{id}")
    public void updateDiscipline(@PathVariable("id") int disid) { disciplineService.deleteDiscipline(disid); }
}