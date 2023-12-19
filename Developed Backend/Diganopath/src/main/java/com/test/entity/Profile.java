package com.test.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="user_profile")
public class Profile {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name ="Firstname")
        private String firstname;
        @Column(name ="Lastname")
        private String lastname;
        @Column(name ="Age")
        private float age;
        private String gender;
        private String bloodgroup;
        @Column(name = "Email")
        private String email;
        @Column(name = "Address")
        private String address;

        @OneToMany(cascade = CascadeType.ALL)
        private List<User> user= new ArrayList<>();
        
        public Profile() {
        } 


        public Profile(String firstname, String lastname, float age, String gender, String bloodgroup, String email,
                String address, List<User> user) {
            this.firstname = firstname;
            this.lastname = lastname;
            this.age = age;
            this.gender = gender;
            this.bloodgroup = bloodgroup;
            this.email = email;
            this.address = address;
            this.user = user;
        }

        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public float getAge() {
            return age;
        }

        public void setAge(float age) {
            this.age = age;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getBloodgroup() {
            return bloodgroup;
        }

        public void setBloodgroup(String bloodgroup) {
            this.bloodgroup = bloodgroup;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public List<User> getUser() {
            return user;
        }


        public void setUser(List<User> user) {
            this.user = user;
        }

        @Override
        public String toString() {
            return "Profile [firstname=" + firstname + ", lastname=" + lastname + ", age=" + age + ", gender=" + gender
                    + ", bloodgroup=" + bloodgroup + ", email=" + email + ", address=" + address + "]";
        }

}
