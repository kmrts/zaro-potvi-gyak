package hu.nive.ujratervezes.zarovizsga.peoplesql;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PeopleDao {
    /*
    A PeopleDao osztályba dolgozz, mely egy DataSource-ot kap konstruktorban.
    A PeopleDaoTest hívja meg, ott van a DataSource deklarálva. Nyugodtan írd át a benne lévő értékeket.

Legyen egy String findIpByName(String firstName, String lastName) metódusa, mely adatbázisból visszaadja az adott névhez tartozó
ip címet! A teszteset a V1__people.sql állományt futtatja le Flyway-jel.
Létrehoz egy people táblát, amiből a lényeges a first_name, last_name és az ip_address oszlop. Adatokat is beszúrja.
     ~15+ 10p
     */
    private DataSource dataSource;

    public PeopleDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String findIpByName(String firstName, String lastName){
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement("select ip_address from people where first_name = ? and last_name =?");
        ) {
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);

            return getString(stmt);
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error by select", sqle);
        }

    }

    private String getString(PreparedStatement stmt) {
        try (
                ResultSet rs = stmt.executeQuery();
        ) {
            if (rs.next()) {

                return rs.getString("ip_address");
            }
            throw new IllegalArgumentException("No result");
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Cannot select", sqle);
        }
    }
}
