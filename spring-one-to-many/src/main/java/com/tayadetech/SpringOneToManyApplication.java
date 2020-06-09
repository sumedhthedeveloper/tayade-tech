package com.tayadetech;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;

import com.tayadetech.manyTomany.entity.Course;
import com.tayadetech.manyTomany.entity.Student;
import com.tayadetech.manyTomany.repository.CourseRepository;
import com.tayadetech.manyTomany.repository.StudentRepository;
import com.tayadetech.oneTomany.entity.Book;
import com.tayadetech.oneTomany.entity.Page;
import com.tayadetech.oneTomany.repository.BookRepository;
import com.tayadetech.oneTomany.repository.PageRepository;
import com.tayadetech.oneToone.entity.Address;
import com.tayadetech.oneToone.entity.User;
import com.tayadetech.oneToone.repository.AddressRepository;
import com.tayadetech.oneToone.repository.UserRepository;



@SpringBootApplication
public class SpringOneToManyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringOneToManyApplication.class, args);
	}

	/* For OneToMany And ManyToOne */
//	@Bean
//    public CommandLineRunner mappingDemo(BookRepository bookRepository,
//                                         PageRepository pageRepository) {
//        return args -> {
//
//            // create a new book
//            Book book = new Book("Java 101", "John Doe", "123456");
//
//            // save the book
//            bookRepository.save(book);
//
//            // create and save new pages
//            pageRepository.save(new Page(1, "Introduction contents", "Introduction", book));
//            pageRepository.save(new Page(65, "Java 8 contents", "Java 8", book));
//            pageRepository.save(new Page(95, "Concurrency contents", "Concurrency", book));
//            
//            
//        };
//    }
	
	
	/* For OneToOne */
//	@Bean
//    public CommandLineRunner mappingDemo(UserRepository userRepository,
//                                         AddressRepository addressRepository) {
//        return args -> {
//
//            // create a user instance
//            User user = new User("John Doe", "john.doe@example.com", "1234abcd");
//
//            // create an address instance
//            Address address = new Address("Lake View 321", "Berlin", "Berlin",
//                    "95781", "DE");
//
//            // set child reference
//            address.setUser(user);
//
//            // set parent reference
//            user.setAddress(address);
//
//            // save the parent
//            // which will save the child (address) as well
//            userRepository.save(user);
//        };
//    }
	
	/* For ManyToMany */
//	@Bean
//    public CommandLineRunner mappingDemo(StudentRepository studentRepository,
//                                         CourseRepository courseRepository) {
//        return args -> {
//
//            // create a student
//            Student student = new Student("John Doe", 15, "8th");
//
//            // save the student
//            studentRepository.save(student);
//
//            // create three courses
//            Course course1 = new Course("Machine Learning", "ML", 12, 1500);
//            Course course2 = new Course("Database Systems", "DS", 8, 800);
//            Course course3 = new Course("Web Basics", "WB", 10, 0);
//
//            // save courses
//            courseRepository.saveAll(Arrays.asList(course1, course2, course3));
//
//            // add courses to the student
//            student.getCourses().addAll(Arrays.asList(course1, course2, course3));
//
//            // update the student
//            studentRepository.save(student);
//        };
//    }
	
}
