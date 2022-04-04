package com.genspark.SpringBootAssign1.Service;

import com.genspark.SpringBootAssign1.Entity.Course;

import java.util.List;

public interface CourseService {

    List<Course> getAllCourses();
    Course getByCourseId(int id);
    Course addCourse(Course course);
    Course updateCourse(Course course);
    Course deleteCourse(int courseId);

}
