package hospitalSeeker.tools;

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
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataSetUtils {

    private String jdbcDriver;
    private String jdbcUrl;
    private String user;
    private String password;
    public static String fullDataSet;
    public static String smallDataSet;

    private IDatabaseTester databaseTester;
    private IDataSet dataSet;


    public void getProperties() {
        Properties prop = new Properties();
        try {
            InputStream input = DataSetUtils.class.getResourceAsStream("/db.properties");
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        jdbcDriver = prop.getProperty("JDBC_DRIVER");
        jdbcUrl = prop.getProperty("JDBC_URL");
        user = prop.getProperty("USER");
        password = prop.getProperty("PASSWORD");
        fullDataSet = prop.getProperty("FULL_DATASET_PATH");
        smallDataSet = prop.getProperty("SMALL_DATASET_PATH");
    }

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
        getProperties();
        return new FlatXmlDataSetBuilder().build(new FileInputStream(smallDataSet));
    }

    private void cleanlyInsert(IDataSet dataSet) throws Exception {
        databaseTester = new JdbcDatabaseTester(jdbcDriver, jdbcUrl, user, password);
        databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
        databaseTester.setDataSet(dataSet);
        databaseTester.onSetup();
    }

    public void selectDataSet(String xml) {
        try {
            dataSet = new FlatXmlDataSetBuilder().build(new FileInputStream(xml));
            DatabaseOperation.CLEAN_INSERT.execute(getConnection(), dataSet);
        } catch (DatabaseUnitException | SQLException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private IDatabaseConnection getConnection() throws SQLException, DatabaseUnitException {
        Connection jdbcConnection = DriverManager.getConnection(jdbcUrl, user, password);
        return new DatabaseConnection(jdbcConnection);
    }
}
