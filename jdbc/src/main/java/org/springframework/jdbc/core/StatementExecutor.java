package org.springframework.jdbc.core;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class StatementExecutor {

    public <T> List<T> execute(
            final PreparedStatement preparedStatement,
            final RowMapper<T> rowMapper
    ) throws SQLException {
        final ResultSet resultSet = preparedStatement.executeQuery();
        final List<T> results = new ArrayList<>();
        while (resultSet.next()) {
            results.add(rowMapper.mapRow(resultSet));
        }
        return results;
    }
}
