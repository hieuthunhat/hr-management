package com.hieuthunhat.hrm.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hieuthunhat.hrm.models.Staff;
import com.hieuthunhat.hrm.services.StaffService;

/**
 * Controller for managing staff members.
 * StaffController
 */
@RestController
@RequestMapping("/api/employees")
public class StaffController {
  private final StaffService staffService;

  public StaffController(StaffService staffService) {
    this.staffService = staffService;
  }

  /**
   * Get a staff member by ID.
   * @param id
   * @return Staff
   */
  @GetMapping("{id}")
  public Staff getStaffById(@PathVariable Long id) {
    if (id == null || id <= 0) {
      throw new IllegalArgumentException("Invalid staff ID: " + id);
    }
    return staffService.getStaffById(id);
  }

  /**
   * Get a paginated list of staff members.
   * @param page
   * @param size
   * @return List<Staff>
   */
  @GetMapping("")
  public List<Staff> getStaffByPaginate(
              @RequestParam(defaultValue = "0") int page,
              @RequestParam(defaultValue = "25") int size
  ) {
    return staffService.getStaffByPaginate(page, size);
  }

  /**
   * Create a new staff member.
   * @param object
   */
  @PostMapping("")
  public void createStaff(@RequestBody Staff staff) {
    if (staff == null) {
      throw new IllegalArgumentException("Staff object cannot be null");
    }
    staffService.createStaff(staff);
  }

  @PutMapping("{id}")
  public void updateStaff(@PathVariable Long id, @RequestBody Staff staff) {
    if (id == null || id <= 0) {
      throw new IllegalArgumentException("Invalid staff ID: " + id);
    }
    if (staff == null) {
      throw new IllegalArgumentException("Staff object cannot be null");
    }
    staffService.updateStaff(staff);
  }
}
