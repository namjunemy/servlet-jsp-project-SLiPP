package io.namjune.support;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTemplate {
  public void executeUpdate(String sql, PreparedStatementSetter pss) throws SQLException {
    Connection conn = null;
    PreparedStatement pstmt = null;
    try {
      conn = ConnectionManager.getConnection();
      pstmt = conn.prepareStatement(sql);
      pss.setParameters(pstmt);

      pstmt.executeUpdate();
    } finally {
      if (pstmt != null)
        pstmt.close();
      if (conn != null)
        conn.close();
    }
  }

  public void executeUpdate(String sql, Object... parameters) throws SQLException {
    executeUpdate(sql, createPreparedStatementSetter(parameters));
  }

  public <T> T executeQuery(String sql, RowMapper<T> rm, PreparedStatementSetter pss) throws SQLException {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
      conn = ConnectionManager.getConnection();
      pstmt = conn.prepareStatement(sql);
      pss.setParameters(pstmt);

      rs = pstmt.executeQuery();
      if (!rs.next()) {
        return null;
      }

      return rm.mapRow(rs);
    } finally {
      if (rs != null)
        rs.close();
      if (pstmt != null)
        pstmt.close();
      if (conn != null)
        conn.close();
    }
  }

  public <T> T executeQuery(String sql, RowMapper<T> rm, Object... parameters) throws SQLException {
    return executeQuery(sql, rm, createPreparedStatementSetter(parameters));
  }

  private PreparedStatementSetter createPreparedStatementSetter(Object... parameters) {
    return new PreparedStatementSetter() {
      @Override
      public void setParameters(PreparedStatement pstmt) throws SQLException {
        for (int i = 0; i < parameters.length; i++) {
          pstmt.setObject(i + 1, parameters[i]);
        }
      }
    };
  }
}
