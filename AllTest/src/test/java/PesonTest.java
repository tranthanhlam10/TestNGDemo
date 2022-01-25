import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.testng.Assert;
import org.testng.annotations.*;
import io.qameta.allure.Description;
import java.io.IOException;



@Test
public class PesonTest {

    Person TranLam = new Person();
    Person TranLong = new Person();
    Person TranDan = new Person();

    ExtentReports extent;
    ExtentSparkReporter spark;

    public PesonTest() throws IOException {
    }

    @BeforeTest
    public void Setup() {
        TranLam.SetAge(18);
        TranLong.SetAge(51);
        TranDan.SetAge(9);

        //Khai bao extent rp
        extent = new ExtentReports();
        spark = new ExtentSparkReporter("VaccinTest.html");
        spark.config().setTheme(Theme.STANDARD);
        spark.config().setDocumentTitle("MyReport");
        spark.config().setReportName("Test1");
        extent.attachReporter(spark);
    }

    // doan
    @Test
    @Description("Some detailed test description")
    public void testVaccin() throws Exception {
        Assert.assertEquals(TranLam.checkAgeToVaccinCovid(),"Verocell","Thanh cong");
    }




    @Test(description = "Ban Tran Lam da duoc chich vaccin")
    public void testPersonVaccin() {
        Assert.assertEquals(TranLam.checkAgeToVaccinCovid(),"Verocell","Thanh cong");
    }
    @Test(description = "Ban Tran Long da duoc chich vaccin")
    public void testPesonVaccin2() {
        Assert.assertNotEquals(TranLong.checkAgeToVaccinCovid(),"Verocell","Thanh cong");
    }

    @DataProvider(name = "data-provider")
    public Object[][] dpMethod(){
        return new Object[][]  {{18},{21},{51}};
    }
    @Test (dataProvider = "data-provider")
    public void checkVaccined( int value) {


//        ExtentTest test = extent.createTest("Name test");
        Assert.assertEquals(TranLam.getAllAge(value),18);

        extent.createTest("LogLevel")
                .info("info")
                .pass("pass")
                .warning("warn")
                .skip("skip")
                .fail("fail");

        extent.createTest("CodeBlock").generateLog(
                Status.PASS,
                MarkupHelper.createCodeBlock("Thanh Lam"));

        extent.createTest("Nhung nguoi duoc chich")
                .createNode("18")
                .createNode("21")
                .createNode("52")
                .pass("Nhung nguoi du tuoi nay se duoc chich cac loai vaccin khac nhau");

        extent.createTest("Duoi 18 tuoi chich vaccin Astra")
                .assignDevice("Astra")
                .pass("Age < 18");
        extent.createTest("Tren 50 tuoi chich vaccin Prifzer")
                .assignDevice("Prifzer")
                .pass("Age > 50");
        extent.createTest("Cac so tuoi con lai chich vaccin Verocell")
                .assignDevice("Verocell")
                .fail("18 <= Age >= 50");

        extent.createTest("Nhung loi con lai khong the test duoc")
                .fail(new RuntimeException("Nhung tuoi khac thi khong co trong pham vi test"));

    }

    @AfterTest
    public void TearDown() {
        System.out.println("Class test pass");
        extent.flush();
    }
}
