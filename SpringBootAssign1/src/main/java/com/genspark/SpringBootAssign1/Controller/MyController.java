package com.genspark.SpringBootAssign1.Controller;

import com.genspark.SpringBootAssign1.Entity.Course;
import com.genspark.SpringBootAssign1.Entity.Employee;
import com.genspark.SpringBootAssign1.Service.CourseService;
import com.genspark.SpringBootAssign1.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("home")
    public String home(){
        return "<html><h1>Welcome to the course application</h1></html>";
    }

    // // // // //
    // COURSES  //
    // // // // //
    @GetMapping("courses")
    public List<Course> getCourses(){
        return this.courseService.getAllCourses();
    }

    @GetMapping("/courses/{courseId}")
    public Course getCourse(@PathVariable String courseId){
        return this.courseService.getByCourseId(Integer.parseInt(courseId));
    }

    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course){
        return this.courseService.addCourse(course);
    }

    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course){
        return this.courseService.updateCourse(course);
    }

    @DeleteMapping("/courses/{courseId}")
    public String deleteCourse(@PathVariable String courseId){
        this.courseService.deleteCourse(Integer.parseInt(courseId));
        return "Deleted Successfully";
    }

    // // // // // //
    // EMPLOYEES  //
    // // // //  //
    @GetMapping("employees")
    public List<Employee> getEmployees(){
        return this.employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable String employeeId){
        return this.employeeService.getByEmployeeId(Integer.parseInt(employeeId));
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        return this.employeeService.addEmployee(employee);
    }

    @PutMapping("/employees")
    public Employee updateCourse(@RequestBody Employee employee){
        return this.employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable String employeeId){
        this.employeeService.deleteEmployee(Integer.parseInt(employeeId));
        return "Deleted Successfully";
    }

}
