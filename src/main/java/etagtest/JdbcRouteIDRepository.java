package etagtest;

import demo.backend.jdbc.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcRouteIDRepository implements RouteIDRepository {

    private JdbcOperations jdbcOperations;
    //private final static String INSERT_GLOBAL = "INSERT INTO global VALUES(?,?)";
    private final static String SELECT_ROUTE_ID = "SELECT * From TaichungEtagRouteInfo ";

    public JdbcRouteIDRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

//	@Override
//	public void addGlobal(Global global) {
//		int row = jdbcOperations.update(INSERT_GLOBAL, global.getUid(),
//				global.getBelong());
//		System.out.println("insert: " + row);
//	}
//
//	@Override
//	public Global findOne(String uid) {
//            try{
//		return jdbcOperations.queryForObject(SELECT_GLOBAL_BY_UID,
//				new GlobalrowMapper(), uid);
//            }catch(org.springframework.dao.EmptyResultDataAccessException ex){
//                return null;
//            }
//	}
    @Override
    public List<Route_ID> getRouteID() {
        return jdbcOperations.query(SELECT_ROUTE_ID, new RouteIDrowMapper());
    }

    private static class RouteIDrowMapper implements RowMapper<Route_ID> {

        @Override
        public Route_ID mapRow(ResultSet rs, int rowNum) throws SQLException {
            Route_ID g = new Route_ID();
            g.setRoute_id(rs.getInt("route_id"));
            g.setRoad_name(rs.getString("road_name"));
            g.setDirection(rs.getString("direction"));
            g.setStartsite(rs.getInt("start_side_id"));
            g.setENDsite(rs.getInt("end_side_id"));
            g.setDist(rs.getInt("dist"));
            g.setType(rs.getString("type"));

            return g;
        }

//        @Override
//        public Route_ID mapRow(ResultSet rs, int rowNum) throws SQLException {
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        }
    }

}
