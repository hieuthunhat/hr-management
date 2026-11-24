package com.hieuthunhat.hrm.models;

import java.util.Date;

import static com.hieuthunhat.hrm.constants.StaffConstants.*;
import com.hieuthunhat.hrm.enums.Department;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

/**
 * Entity class representing a staff member in the organization.
 * Staff
 */
@Entity
@Table (name = "staffs")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = STAFF_ID_COLUMN, nullable = false)
    private Long id;
    @Column(name = STAFF_NAME_COLUMN, nullable = false)
    private String name;
    @Column (name = STAFF_EMAIL_COLUMN, nullable = false, unique = true)
    private String email;
    @Column (name = STAFF_PHONE_COLUMN, nullable = true)
    private String phone;
    @Column (name = STAFF_DOB_COLUMN, nullable = true)
    private Date dob;
    @Column (name = STAFF_DEPARTMENT_COLUMN, nullable = true)
    private Department department;
    @Column (name = STAFF_ADDRESS_COLUMN, nullable = true)
    private String address;
    @Column (name = STAFF_CREATED_AT_COLUMN, nullable = false)
    private Date createdAt;
    @Column (name = STAFF_UPDATED_AT_COLUMN, nullable = true)
    private Date updatedAt;
    @Column (name = STAFF_DELETED_AT_COLUMN, nullable = true)
    private Date deletedAt;
    @Column (name = STAFF_IS_DELETED_COLUMN, nullable = false)
    private boolean isDeleted = false;

    public Staff() {
    }

    public Staff(Long id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
