package com.appgate.connection.models;

public class Employee {

    private Integer idEmpleado;
    private String nombre;
    private Integer meses;
    private Integer salario;

    public Employee(){}

    public Employee(Integer idEmpleado, String nombre, Integer meses, Integer salario) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.meses = meses;
        this.salario = salario;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getMeses() {
        return meses;
    }

    public void setMeses(Integer meses) {
        this.meses = meses;
    }

    public Integer getSalario() {
        return salario;
    }

    public void setSalario(Integer salario) {
        this.salario = salario;
    }
}
