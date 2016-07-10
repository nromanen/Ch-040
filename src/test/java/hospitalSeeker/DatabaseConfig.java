package hospitalSeeker;

import org.dbunit.DatabaseUnitException;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Alex on 07-Jul-16.
 */
public class DatabaseConfig {

    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/hospital";
    private static final String USER = "postgres";
    private static final String PASSWORD = "root";
    public static final String FULL_DATASET_PATH = "src/test/resources/database_full.xml";
    public static final String SMALL_DATASET_PATH = "src/test/resources/database_small.xml";

    private IDatabaseTester databaseTester;
    private IDataSet dataSet;

    public void databaseTearDown() {
        try {
            databaseTester.onTearDown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void importDataSet() {
        try {
            dataSet = readDataSet();
            cleanlyInsert(dataSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private IDataSet readDataSet() throws Exception {
        return new FlatXmlDataSetBuilder().build(new FileInputStream(SMALL_DATASET_PATH));
    }

    private void cleanlyInsert(IDataSet dataSet) throws Exception {
        databaseTester = new JdbcDatabaseTester(JDBC_DRIVER, JDBC_URL, USER, PASSWORD);
        databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
        databaseTester.setDataSet(dataSet);
        databaseTester.onSetup();
    }

    public void selectAnotherDataset(String xml) {
        try {
            dataSet = new FlatXmlDataSetBuilder().build(new FileInputStream(xml));
            DatabaseOperation.CLEAN_INSERT.execute(getConnection(), dataSet);
        } catch (DatabaseUnitException | SQLException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private IDatabaseConnection getConnection() throws SQLException, DatabaseUnitException {
        Connection jdbcConnection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
        return new DatabaseConnection(jdbcConnection);
    }
}
