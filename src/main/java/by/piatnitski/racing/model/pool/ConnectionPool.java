package by.piatnitski.racing.model.pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Deque;

public class ConnectionPool {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/racing_system?useSSL=false&serverTimezone=UTC";
    private static final String USER = "racing_user";
    private static final String PASSWORD = "racing_pass";

    private static final int INITIAL_POOL_SIZE = 10;
    private static final Deque<Connection> pool = new ArrayDeque<>();

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
                pool.add(createConnection());
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("Ошибка инициализации пула соединений: " + e);
        }
    }

    private static Connection createConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static synchronized Connection getConnection() throws SQLException {
        Connection conn;
        if (pool.isEmpty()) {
            conn = createConnection();
        } else {
            conn = pool.poll();
            if (conn == null || conn.isClosed()) {
                conn = createConnection();
            }
        }
        return conn;
    }

    public static synchronized void releaseConnection(Connection connection) {
        if (connection != null) {
            pool.offer(connection);
        }
    }

    public static synchronized void shutdown() throws SQLException {
        while (!pool.isEmpty()) {
            Connection conn = pool.poll();
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        }
    }
}