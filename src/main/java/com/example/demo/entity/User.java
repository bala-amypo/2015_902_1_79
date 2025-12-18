package com.example.demo.entity;
import  jakarta.persistence.*;
@Entity
@Table(name="users")
public class User{
   @ID
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private Long id;
   private String name;
   @Column(unique=true,nullable=false)
   private String email;
   private String password;
   private String role;
   public User(){
    public User(Long id,String name,String email,String password,String role){
        this.id=id;
        this.name=name;
        this.email=email;
        t
    }
   }
}