package com.hieuthunhat.hrm.daos;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hieuthunhat.hrm.models.Staff;
import com.hieuthunhat.hrm.repositories.StaffRepository;

/**
 * Implementation of the StaffRepository interface.
 * StaffRepositoryImp
 */
@Repository
public class StaffRepositoryImpl implements StaffRepository {
  private final JdbcTemplate jdbcTemplate;
  private final String TABLE_NAME = "staffs";
  private final StaffRowMapper staffRowMapper = new StaffRowMapper();

  public StaffRepositoryImpl(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  /**
   * Create a new staff member.
   * @param staff
   * @return the number of rows affected
   */
  @Override
  public int create(Staff staff) {
    String sql = "INSERT INTO " + TABLE_NAME + " (name, email, phone, dob, address, department, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    int rowsAffected = jdbcTemplate.update(sql,
      staff.getName(),
      staff.getEmail(),
      staff.getPhone(),
      staff.getDob(),
      staff.getAddress(),
      staff.getDepartment().toString(),
      staff.getCreatedAt(),
      staff.getUpdatedAt()
    );
    if (rowsAffected == 0) {
      throw new RuntimeException("Failed to create staff member");
    }
    return rowsAffected;
  }

  /**
   * Update an existing staff member.
   * @param staff
   * @return the number of rows affected
   */
  @Override
  public int update(Staff staff) {
    String sql = "UPDATE " + TABLE_NAME + " SET name = ?, email = ?, phone = ?, dob = ?, address = ?, department = ?, updated_at = ? WHERE id = ?";
    int rowsAffected = jdbcTemplate.update(sql,
      staff.getName(),
      staff.getEmail(),
      staff.getPhone(),
      staff.getDob(),
      staff.getAddress(),
      staff.getDepartment().toString(),
      staff.getUpdatedAt(),
      staff.getId()
    );
    if (rowsAffected == 0) {
      throw new RuntimeException("Failed to update staff member with ID: " + staff.getId());
    }
    return rowsAffected;
  }

  /**
   * Remove a staff member by ID.
   * @param id
   * @return the number of rows affected
   */
  @Override
  public int remove(Long id) {
    String sql = "DELETE FROM " + TABLE_NAME + " WHERE id = ?";
    int rowsAffected = jdbcTemplate.update(sql, id);
    if (rowsAffected == 0) {
      throw new RuntimeException("Failed to remove staff member with ID: " + id);
    }
    return rowsAffected;
  }

  /**
   * Find a staff member by ID.
   * @param id
   * @return
   */
  @Override
  public Staff find(Long id) {
    String sql = "SELECT * FROM " + TABLE_NAME + " WHERE id = ?";
    List<Staff> staffList = jdbcTemplate.query(sql, staffRowMapper, id);
    if (staffList.isEmpty()) {
      return null;
    }
    return staffList.get(0);
  }

  /**
   * Find staff members by page and size.
   * @param page
   * @param size
   * @return the list of staff members
   */
  public List<Staff> findByPageAndSize(int page, int size) {
    String sql = "SELECT * FROM " + TABLE_NAME + " WHERE deleted_at IS NULL" + " ORDER BY id ASC" +  " LIMIT ? OFFSET ?";
    List<Staff> staffList = jdbcTemplate.query(sql, staffRowMapper, size, page * size);
    if (staffList.isEmpty()) {
      return null;
    }

    return staffList;
  }

  /**
   * Soft remove a staff member by ID.
   * @param id
   */
  public int softRemove(Long id) {
    String sql = "UPDATE " + TABLE_NAME + " SET deleted_at = NOW() WHERE id = ?";
    int rowsAffected = jdbcTemplate.update(sql, id);
    if (rowsAffected == 0) {
      throw new RuntimeException("Failed to soft remove staff member with ID: " + id);
    }
    return rowsAffected;
  }
}
