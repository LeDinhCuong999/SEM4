package com.t2010a.hellot2010aagain.demo;

import com.t2010a.hellot2010aagain.entity.Customer;
import com.t2010a.hellot2010aagain.model.customer.InMemoryCustomerModel;
import com.t2010a.hellot2010aagain.model.customer.MySqlCustomerModel;
import com.t2010a.hellot2010aagain.model.customer.CustomerModel;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class CustomerConsoleApplication {
    private static CustomerModel customerModel;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Please choose type of model: ");
            System.out.println("--------------------------");
            System.out.println("1. In memory model.");
            System.out.println("2. My SQL model.");
            System.out.println("--------------------------");
            System.out.println("Please enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    customerModel = new InMemoryCustomerModel();
                    break;
                case 2:
                    customerModel = new MySqlCustomerModel();
                    break;
            }
            generateMenu();
        }
    }

    private static void generateMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("-------------Customer Manager--------------");
            System.out.println("1. Create new customer");
            System.out.println("2. Show all customer");
            System.out.println("3. Update customer");
            System.out.println("4. Delete customer");
            System.out.println("5. Exit");
            System.out.println("------------------------------------------");
            System.out.println("Please enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    createNewCustomer();
                    break;
                case 2:
                    showAllCustomer();
                    break;
                case 3:
                    updateCustomer();
                    break;
                case 4:
                    deleteCustomer();
                    break;
                case 5:
                    System.out.println("Cya!");
                    break;
            }
            if (choice == 5) {
                break;
            }
        }
    }

    private static void deleteCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter id to update: ");
        String id = scanner.nextLine();
        Customer existingCustomer = customerModel.findById(id);
        if (existingCustomer == null) {
            System.err.println("404, Customer not found!");
        } else {
            if (customerModel.delete(id)) {
                System.out.println("Action success!");
            } else {
                System.err.println("Action fails, please try again!");
            }
        }
    }

    private static void updateCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter id to update: ");
        String id = scanner.nextLine();
        Customer existingCustomer = customerModel.findById(id);
        if (existingCustomer == null) {
            System.err.println("404, Customer not found!");
        } else {
            System.out.println("Please enter name");
            String name = scanner.nextLine();
            existingCustomer.setName(name);
            System.out.println("Please enter phone");
            String phone = scanner.nextLine();
            existingCustomer.setPhone(phone);
            System.out.println("Please enter image");
            String image = scanner.nextLine();
            existingCustomer.setImage(image);
            if (customerModel.update(id, existingCustomer) != null) {
                System.out.println("Action success!");
            } else {
                System.err.println("Action fails, please try again!");
            }
        }
    }

    private static void showAllCustomer() {
        List<Customer> list = customerModel.findAll();
        for (Customer customer :
                list) {
            System.out.println(customer.toString());
        }
    }

    private static void createNewCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter id");
        String id = scanner.nextLine();
        System.out.println("Please enter name");
        String name = scanner.nextLine();
        System.out.println("Please enter phone");
        String phone = scanner.nextLine();
        System.out.println("Please enter image");
        String image = scanner.nextLine();
        Customer customer = new Customer(id, name, "019231233", "image-demo.png", LocalDateTime.of(2000, 10, 10, 10, 10));
        if (customerModel.create(customer) != null) {
            System.out.println("Create customer success!");
        } else {
            System.err.println("Save customer fails, please try again later!");
        }
    }
}
