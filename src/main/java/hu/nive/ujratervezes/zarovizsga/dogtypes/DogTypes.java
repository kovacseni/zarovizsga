package hu.nive.ujratervezes.zarovizsga.dogtypes;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DogTypes {

    private MariaDbDataSource dataSource;

    public DogTypes(MariaDbDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> getDogsByCountry(String country) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("select name from dog_types where country = ?;")) {

            stmt.setString(1, country.toUpperCase());
            return getDogs(stmt);

        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not read database.", sqle);
        }
    }

    private List<String> getDogs(PreparedStatement stmt) throws SQLException {
        List<String> dogs = new ArrayList<>();
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String dogName = rs.getString(1).toLowerCase();
                dogs.add(dogName);
            }
        }
        return dogs;
    }
}
