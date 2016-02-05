package etagtest;

import demo.backend.jdbc.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcEtc01Repository implements Etc01Repository {

    private JdbcOperations jdbcOperations;
	//private final static String INSERT_GLOBAL = "INSERT INTO global VALUES(?,?)";
    //private final static String SELECT_GLOBAL_BY_UID = "SELECT * From global WHERE uid=?";
    private final static String SELECT_Etc01_BY_5mins = "SELECT * From etagtestdata WHERE stag_time>=?";
    private final static String SELECT_Etc01_BY_2hours = "SELECT * From etagtestdata WHERE stag_time>=?";

    public JdbcEtc01Repository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

//	@Override
//	public void addGlobal(Global global) {
//		int row = jdbcOperations.update(INSERT_GLOBAL, global.getUid(),
//				global.getBelong());
//		System.out.println("insert: " + row);
//	}
    @Override
    public List<Etc01> get5minsdata(Timestamp forlast5minstime) {
        try {
            return jdbcOperations.query(SELECT_Etc01_BY_5mins,
                    new Etc01rowMapper(), forlast5minstime);
        } catch (org.springframework.dao.EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Etc01> get2hoursdata(Timestamp forlast2hourstime) {
        try {
            return jdbcOperations.query(SELECT_Etc01_BY_2hours,
                    new Etc01rowMapper(), forlast2hourstime);
        } catch (org.springframework.dao.EmptyResultDataAccessException ex) {
            return null;
        }
    }

//    @Override
//    public List<Global> findAll() {
//        return jdbcOperations.query("SELECT * from global", new rowMapper());
//    }
    private static class Etc01rowMapper implements RowMapper<Etc01> {

        @Override
        public Etc01 mapRow(ResultSet rs, int rowNum) throws SQLException {
            Etc01 g = new Etc01();
            g.setKey_id(rs.getInt("key_id"));
            g.setEpc(rs.getString("epc"));
            g.setStation(rs.getInt("station"));
            g.setTagtime(rs.getTimestamp("stag_time"));
            return g;
        }

    }

}
