/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import javax.inject.Named;
import javax.enterprise.context.Dependent;
import controller.StudentController;
/**
 *
 * @author archi
 */
@Named(value = "studentManagedBean")
@Dependent
public class StudentManagedBean {
    private int id;
    private String firstName,lastName;
    private StudentController controller;
    
    public StudentManagedBean(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public StudentManagedBean() {
    } 
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
   
    public StudentController getController(){
        if(controller == null ){
            controller= new StudentController();
            return controller;
        }
        return null;
    }
}
