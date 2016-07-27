package astro;

import org.apache.axis2.AxisFault;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.rmi.RemoteException;

public class AstroTest {
    public static final double MILES_IN_LIGHTYEAR = 5.878639427505244E12;

    AstronomicalUnitStub.ChangeAstronomicalUnit changeAstronomicalUnit;
    AstronomicalUnitStub stub;

    @DataProvider(name = "lightyears")
    public Object[][] lightyears() {
        return new Object[][]{{1, MILES_IN_LIGHTYEAR}, {0, 0.0}
        };
    }

    @BeforeMethod
    public void beforeMethod() {
        try {
            stub = new AstronomicalUnitStub("http://www.webservicex.net/Astronomical.asmx?WSDL");
            changeAstronomicalUnit = new AstronomicalUnitStub.ChangeAstronomicalUnit();
        } catch (AxisFault axisFault) {
            axisFault.printStackTrace();
        }
    }

    @Test(dataProvider = "lightyears")
    public void testLightyearsToMiles(int astronomicalValue, double expectedResult) {
        changeAstronomicalUnit.setAstronomicalValue(astronomicalValue);
        changeAstronomicalUnit.setFromAstronomicalUnit(AstronomicalUnitStub.Astronomicals.lightyear);
        changeAstronomicalUnit.setToAstronomicalUnit(AstronomicalUnitStub.Astronomicals.miles);
        AstronomicalUnitStub.ChangeAstronomicalUnitResponse changeAstronomicalUnitResponse;
        try {
            changeAstronomicalUnitResponse = stub.changeAstronomicalUnit(changeAstronomicalUnit);
            Assert.assertEquals(changeAstronomicalUnitResponse.getChangeAstronomicalUnitResult(), expectedResult);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
