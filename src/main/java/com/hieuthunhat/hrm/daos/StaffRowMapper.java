package com.hieuthunhat.hrm.daos;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hieuthunhat.hrm.models.Staff;

import static com.hieuthunhat.hrm.constants.StaffConstants.*;
import com.hieuthunhat.hrm.enums.Department;

/**
 * RowMapper implementation for mapping ResultSet rows to Staff objects.
 * StaffRowMapper
 */
public class StaffRowMapper implements RowMapper<Staff> {

  /**
   * Maps a row from the ResultSet to a Staff object.
   * @param rs the ResultSet to map
   * @param rowNum the row number
   * @return the mapped Staff object
   * @throws SQLException if an error occurs while mapping the row
   */
  @Override
  public Staff mapRow(ResultSet rs, int rowNum) throws SQLException {
    Staff staff = new Staff();
    staff.setId(rs.getLong(STAFF_ID_COLUMN));
    staff.setName(rs.getString(STAFF_NAME_COLUMN));
    staff.setEmail(rs.getString(STAFF_EMAIL_COLUMN));
    staff.setPhone(rs.getString(STAFF_PHONE_COLUMN));
    staff.setDob(rs.getDate(STAFF_DOB_COLUMN));
    staff.setAddress(rs.getString(STAFF_ADDRESS_COLUMN));
    staff.setDepartment(Department.valueOf(rs.getString(STAFF_DEPARTMENT_COLUMN)));
    staff.setCreatedAt(rs.getDate(STAFF_CREATED_AT_COLUMN));
    staff.setUpdatedAt(rs.getDate(STAFF_UPDATED_AT_COLUMN));
    staff.setDeletedAt(rs.getDate(STAFF_DELETED_AT_COLUMN));
    return staff;
  }

}
