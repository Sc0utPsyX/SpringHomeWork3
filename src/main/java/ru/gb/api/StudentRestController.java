package ru.gb.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.model.Student;

import java.util.List;

@RestController
@RequestMapping("/students/rest")
public class StudentRestController {


    @GetMapping("/all")
    public List<Student> getAllStudents() {
        List<Student> students = List.of(
                new Student(),
                new Student(),
                new Student(),
                new Student(),
                new Student()
        );

        return students;
    }

}
