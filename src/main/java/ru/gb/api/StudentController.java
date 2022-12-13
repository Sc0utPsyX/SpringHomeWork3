package ru.gb.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.StudentRepository;
import ru.gb.model.Student;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    // серые IP адреса
    // белые IP адреса

    // http://localhost:8180/app/hello?name=Igor
    // http:/10.15.22.33:8180/app/hello?name=Igor

    // cmd -> ipconfig

    @Autowired
    private StudentRepository studentRepository;


    @GetMapping("/all")
    public String getAllStudents(Model model) {
        List<Student> students = studentRepository.getAll();
        model.addAttribute("students", students);

        return "students";
    }

}
