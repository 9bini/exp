package me.kbin.exp.mybatis.tenum;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

@MappedTypes(EnumUsingDbCode.class)
public class EnumUsingDbCodeTypeHandler<E extends Enum<E> & EnumUsingDbCode> extends
    BaseTypeHandler<E> {

  private final Class<E> type;
  private final E[] enumConstants;

  public EnumUsingDbCodeTypeHandler(Class<E> type) {
    if (type == null) {
      throw new IllegalArgumentException("Type argument cannot be null");
    }
    this.type = type;
    this.enumConstants = type.getEnumConstants();
    if (!type.isInterface() && this.enumConstants == null) {
      throw new IllegalArgumentException(
          type.getSimpleName() + " does not represent an enum type.");
    }
  }
  @Override
  public void setNonNullParameter(PreparedStatement ps, int i, E parameter, JdbcType jdbcType)
      throws SQLException {
    ps.setString(i, parameter.getDbCode());
  }

  @Override
  public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
    String dbCode = rs.getString(columnName);
    return rs.wasNull() ? null : getEnum(dbCode);
  }

  @Override
  public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
    String dbCode = rs.getString(columnIndex);
    return rs.wasNull() ? null : getEnum(dbCode);
  }

  @Override
  public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
    String dbCode = cs.getString(columnIndex);
    return cs.wasNull() ? null : getEnum(dbCode);
  }

  private E getEnum(String dbCode) {
    return Arrays.stream(enumConstants)
        .filter(e -> e.getDbCode().equals(dbCode))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException(
            "Cannot convert " + dbCode + " to " + type.getSimpleName()));
  }
}
