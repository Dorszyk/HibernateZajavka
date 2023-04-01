package org.example10;



public class CachedRunner {
    public static void main(String[] args) {

        CachedEmployeeRepository cachedEmployeeRepository = new CachedEmployeeRepository();

        cachedEmployeeRepository.deleteAll();

        cachedEmployeeRepository.insertData(CachedExampleData.someEmployee1());
        CachedEmployee employee = cachedEmployeeRepository.insertData(CachedExampleData.someEmployee2());
        cachedEmployeeRepository.insertData(CachedExampleData.someEmployee3());

       // cachedEmployeeRepository.levelOneCached(employee.getEmployeeId());

        cachedEmployeeRepository.levelTwoCached(employee.getEmployeeId());
        cachedEmployeeRepository.levelTwoCached(employee.getEmployeeId());

        CachedHibernateUtil.closeSessionFactory();

    }
}
