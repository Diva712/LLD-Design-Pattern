package StructuralDesignPattern.ProxyDesignPattern.EmployeeAccessProxy;

class Employee {

}

interface EmployeeDao {

  void create(String client, Employee obj);

  void delete(String client, int EmployeeId);

  Employee get(String client, int EmployeeId);
}

class EmployeeDaoImpl implements EmployeeDao {

  public void create(String client, Employee obj) {
    System.out.println("Employee has been created !!");
  }

  public void delete(String client, int EmployeeId) {
    System.out.println("Employee deleted whose Id number is : " + EmployeeId);
  }

  public Employee get(String client, int EmployeeId) {
    System.out.println("Employee data fetched Successfully whose Id is : " + EmployeeId);
    return new Employee();
  }
}

class EmployeeProxy implements EmployeeDao {

  EmployeeDao employeeDao;

  EmployeeProxy() {
    this.employeeDao = new EmployeeDaoImpl();
  }

  public void create(String client, Employee obj) {

    if (client.equals("ADMIN")) {
      employeeDao.create(client, obj);
    } else {
      System.out.println("Access Denied !! For Creation of Employee ");
    }
  }

  public void delete(String client, int EmployeeId) {

    if (client.equals("ADMIN")) {
      employeeDao.delete(client, EmployeeId);
    } else {
      System.out.println("Access Denied !! For deletion of Employee");
    }
  }

  public Employee get(String client, int EmployeeId) {
    if (client.equals("ADMIN") || client.equals("MENAGER")) {
      employeeDao.get(client, EmployeeId);
    } else {
      System.out.println("Access Denied !! For geting the information !!");
    }
    return new Employee();
  }
}

public class Main {

  public static void main(String[] args) {
    EmployeeProxy employeeProxy = new EmployeeProxy();
    employeeProxy.create("ADMIN", new Employee());
    System.out.println("Operation SuccessFull !!");
  }

}
