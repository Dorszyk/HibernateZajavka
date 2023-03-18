package org.example3;


public class ExampleRunner {
    public static void main(String[] args) {

        CustomerRepository customerRepository = new CustomerRepository();

       customerRepository.deleteAll();

        Customer customer1 = customerRepository.insertCustomer(ExampleData.someCustomer1());
        Customer customer2 = customerRepository.insertCustomer(ExampleData.someCustomer2());

        customerRepository.listCustomer()
                .forEach(customer -> System.out.println("###Customer listing: " + customer));

        System.out.println("###Customer1:" + customerRepository.getCustomer(customer1.getId()));
        System.out.println("###Customer2:" + customerRepository.getCustomer(customer2.getId()));

        Address newAddress = Address.builder()
                .country("Poland")
                .city("Sopot")
                .postalCode("81-713")
                .address("Monte Cassion 10")
                .build();
        customerRepository.updateCustomer(customer1.getId(), newAddress);
        System.out.println("###Customer update: " + customerRepository.getCustomer(customer1.getId()));

        customerRepository.listCustomer()
                .forEach(customer -> System.out.println("###Customer listing: " + customer));

        customerRepository.deleteCustomer(customer2.getId());

        customerRepository.listCustomer()
                .forEach(customer -> System.out.println("###Customer listing: " + customer));

        HibernateUtilOneToOne.closeSessionFactory();
    }
}
