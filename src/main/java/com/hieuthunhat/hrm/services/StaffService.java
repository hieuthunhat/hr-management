package com.hieuthunhat.hrm.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hieuthunhat.hrm.daos.StaffRepositoryImpl;
import com.hieuthunhat.hrm.models.Staff;

/**
 * Service class for managing staff members.
 * StaffService
 */
@Service
public class StaffService {
  private final StaffRepositoryImpl staffRepositoryImpl;

  /**
   * Constructor for StaffService.
   * @param staffRepositoryImpl
   */
  public StaffService(StaffRepositoryImpl staffRepositoryImpl) {
    this.staffRepositoryImpl = staffRepositoryImpl;
  }

  /**
   * Get a paginated list of staff members.
   * @param page
   * @param size
   * @return
   */
  public List<Staff> getStaffByPaginate(int page, int size) {
    return staffRepositoryImpl.findByPageAndSize(page, size);
  }

  /**
   * Get a staff member by ID.
   * @param id
   * @return
   */
  public Staff getStaffById(Long id) {
    return staffRepositoryImpl.find(id);
  }

  /**
   * Create a new staff member.
   * @param staff
   */
  public void createStaff(Staff staff) {
    staffRepositoryImpl.create(staff);
  }

  /**
   * Update an existing staff member.
   * @param staff
   */
  public void updateStaff(Staff staff) {
    staffRepositoryImpl.update(staff);
  }

  /**
   * Soft delete a staff member.
   * @param id
   */
  public void softDeleteStaff(Long id) {
    staffRepositoryImpl.softRemove(id);
  }
}
