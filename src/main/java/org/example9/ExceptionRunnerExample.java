package org.example9;


import java.util.List;

public class ExceptionRunnerExample {
    public static void main(String[] args) {

        CustomerRepository customerRepository = new CustomerRepository();

        customerRepository.deleteAll();

        Customer customer1 = customerRepository.insertCustomer(ExampleData.someCustomer1());
        Customer customer2 = customerRepository.insertCustomer(ExampleData.someCustomer2());

        List<Customer> customers = customerRepository.listCustomer();
        customers.forEach(customer -> System.out.println("###C: " + customer));

        // Customer c1 = customerRepository.getCustomer(customer1.getId()).orElseThrow();
        // Customer c2 = customerRepository.getCustomer(customer2.getId()).orElseThrow();
        //
        // System.out.println("c1 == c2 :" + (c1 == c2));
        // System.out.println("c1.equals(c2) :" + c1.equals(c2));

        //customerRepository.testSession(customer1.getId());

        ExceptionOneToOne.closeSessionFactory();
    }
}
