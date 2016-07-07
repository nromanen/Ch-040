package hospitalSeeker;

import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;

import java.io.FileInputStream;

/**
 * Created by Alex on 07-Jul-16.
 */
public class DatabaseConfig {

    public DatabaseConfig() {
    }

    IDatabaseTester databaseTester;
    IDataSet dataSet;

    public void databaseSetup() {
        long startTime = System.currentTimeMillis();
        try {
        databaseTester = new JdbcDatabaseTester("org.postgresql.Driver", "jdbc:postgresql://localhost:5432/hospital", "postgres", "root");
        dataSet = new FlatXmlDataSetBuilder().build(new FileInputStream("src/test/resources/database_full.xml"));
        databaseTester.setDataSet(dataSet);
        databaseTester.onSetup();
    } catch (Exception e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);
        System.out.println(duration);
    }

    public void databaseTearDown() {
        try {
            databaseTester.onTearDown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
