package org.example;

class Employee {
    private String name;
    private Department department;

    public Employee(String name, Department department) {
        setName(name);
        setDepartment(department);
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            System.out.println("имя не может быть пустым");
            return;
        }
        this.name = name;
    }

    public void setDepartment(Department department) {
        if (department == null) {
            System.out.println("отдел не может быть null");
            return;
        }
        this.department = department;
    }
}
