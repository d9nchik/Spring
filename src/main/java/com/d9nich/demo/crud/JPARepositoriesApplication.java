package com.d9nich.demo.crud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JPARepositoriesApplication {
    public static void main(String[] args) {
        SpringApplication.run(JPARepositoriesApplication.class, args);
    }

    @Bean
    public CommandLineRunner runApplication(TaskRepository taskRepository) {
        return (args -> {
            //Create
            Task articleTask = new Task("Finish article", "Finish the article and send for review", true, 0);
            taskRepository.save(articleTask);

            Task speechTask = new Task("Meeting speech", "Prepare the speech for the meeting", false, 2);
            taskRepository.save(speechTask);

            Task drTask = new Task("Call dr Robbins", "Cancel the visit", true, 1);
            taskRepository.save(drTask);

            Task bookingTask = new Task("Book a hotel", "Book a hotel for vacation", true, 4);
            Task savedTask = taskRepository.save(bookingTask);

            //Read
            System.out.println("Task list:");
            for (Task task : taskRepository.findAll()) {
                System.out.println(task);
            }

            System.out.println("List of enabled tasks:");
            for (Task task : taskRepository.findAllByEnabled(true)) {
                System.out.println(task);
            }

            for (Task task : taskRepository.findBySummaryContaining("hotel")) {
                System.out.println(task);
            }

            //Update
            System.out.println("Updating tasks's title");
            Task task = taskRepository.findByTitle("Meeting speech");

            if (task != null) {
                System.out.println(task);
                task.setEnabled(true);
                taskRepository.save(task);
                System.out.println(taskRepository.findByTitle("Meeting speech"));
            }

            //Delete
            taskRepository.delete(taskRepository.findByTitle("Call dr Robbins"));
        });
    }
}
