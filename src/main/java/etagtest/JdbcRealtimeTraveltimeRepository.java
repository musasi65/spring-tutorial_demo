package etagtest;

import demo.backend.jdbc.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcRealtimeTraveltimeRepository implements RealtimeTraveltimeRepository {

    private JdbcOperations jdbcOperations;
    private final static String INSERT_RealtimeTraveltime = "INSERT INTO RealtimeTraveltime VALUES(?,?,?,?)";

    public JdbcRealtimeTraveltimeRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public void addRealtimeTraveltime(RealtimeTraveltime RealtimeTraveltime) {
        int row = jdbcOperations.update(INSERT_RealtimeTraveltime,
                RealtimeTraveltime.getCreatetime(),
                RealtimeTraveltime.getRoute_id(),
                RealtimeTraveltime.getTraveltime(),
                RealtimeTraveltime.getFlownum());

        System.out.println("insert: " + row);
    }

}
