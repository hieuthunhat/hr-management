package com.hieuthunhat.hrm.repositories;

import com.hieuthunhat.hrm.models.Staff;

/**
 * Implementation of the StaffRepository interface.
 * StaffRepositoryImp
 */
public interface StaffRepository {
  int update(Staff staff);
  int remove(Long id);
  Staff find(Long id);
  int create(Staff staff);
}
