package com.genspark.SpringBootAssign1.Service;

import com.genspark.SpringBootAssign1.Entity.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    private List<Course> list;

    public CourseServiceImpl() {
        list = new ArrayList<>();
        list.add(new Course(123,"Counting class", "Dracula"));
        list.add(new Course(234,"Intermediate counting class", "Dracula"));
        list.add(new Course(345,"Advanced Counting class", "Dracula"));
        list.add(new Course(456,"Graduate Counting Lab", "Dracula, Bismarck"));
    }

    public Course getByCourseId(int id){
        Course c = null;
        for (Course course : this.list){
            if (course.getCourseId() == id) {
                c = course;
                break;
            }
        }

        return c;
    }

    public List<Course> getAllCourses(){
        return list;
    }

    public Course addCourse(Course course){
        list.add(course);
        return getByCourseId(course.getCourseId());
    }

    public Course updateCourse(Course course){
        String title = course.getTitle();
        String instructor = course.getInstructor();
        Course c = null;
        for ( Course e : this.list){
            if (e.getCourseId() == course.getCourseId()){
                e.setTitle(title);
                e.setInstructor(instructor);
                c = e;
                break;
            }
        }
        return c;
    }

    public Course deleteCourse(int courseId){
        Course c = null;
        for ( Course e : this.list){
            if (e.getCourseId() == courseId){
                list.remove(e);
                break;
            }
        }
        return c;
    }

}
