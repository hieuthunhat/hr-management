package com.hieuthunhat.hrm.repositories;

import com.hieuthunhat.hrm.models.Staff;

/**
 * Implementation of the StaffRepository interface.
 * StaffRepositoryImp
 */
public interface StaffRepository {
  void update(Staff staff);
  void remove(Long id);
  Staff find(Long id);
  void create(Staff staff);
}
