package at.bha;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO {

    public List<TaskVO> getAllTasks() {

        List<TaskVO> tasks = new ArrayList<>();
/*      tasks.add(new TaskVO(0, "singen"));
        tasks.add(new TaskVO(1, "tanzen"));
        tasks.add(new TaskVO(2, "snowboarden"));*/

        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/tasks?user=root";
            conn = DriverManager.getConnection(url);

            System.out.println("Connected to Database");

            Statement stmt = null;
            String query = "select * from tasks";

            try {
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()){
                    int id = rs.getInt("id");
                    String name = rs.getString("name");

                 TaskVO task = new TaskVO(id, name);
                    tasks.add(task);
                }
            } catch (SQLException e) {
                throw new Error("Problem", e);
            }finally {
                if(stmt != null) {stmt.close();}
            }

        } catch (SQLException e) {
            throw new Error("Problem", e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return tasks;
    }
}