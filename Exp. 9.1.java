//   Course.java

public class Course {
    private String courseName;
    private int duration;

    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Course Name: " + courseName + ", Duration: " + duration + " months";
    }
}

//   Student.java

public class Student {
    private String name;
    private Course course;

    public Student(String name, Course course) {
        this.name = name;
        this.course = course;
    }

    public void displayDetails() {
        System.out.println("Student Name: " + name);
        System.out.println("Course Details: " + course);
    }
}


//   AppConfig.java (Java-based Spring Configuration)

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Course course() {
        return new Course("Spring Framework", 3);
    }

    @Bean
    public Student student() {
        return new Student("Alice", course());
    }
}


//   MainApp.java (Load context and print student details)

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Student student = context.getBean(Student.class);
        student.displayDetails();
    }
}
