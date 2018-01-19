package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static Utils.BaseTest.driver;

public class Listeners implements ITestListener {


    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        try {
            captureScreenshot(iTestResult, "success");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        try {
            captureScreenshot(iTestResult, "fail");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        deleteDir(new File("screenshots"));
    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

    private void captureScreenshot(ITestResult result, String status) throws IOException {
        String destDir = "";
        String passFailMethod = result.getMethod().getRealClass().getSimpleName() + "." + result.getMethod().getMethodName();

        // To capture a screenshot
        File scrFile = driver.getScreenshotAs(OutputType.FILE);
        // setting date format
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
        if (status.equalsIgnoreCase("fail")) {
            destDir = "screenshots/Failures";
        }
        else if (status.equalsIgnoreCase("pass")) {
            destDir = "screenshots/Success";
        }

        new File(destDir).mkdir();

        String destFile = passFailMethod + " - " + dateFormat.format(new Date()) + ".png";
        FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
    }

    private static boolean deleteDir(File dir) {
        // check if it is a directory
        if (dir.isDirectory()) {
        String[] children = dir.list();
        assert children != null;
            {
                // go through all files and dirs and removethem
                for (String aChildren : children) {
                    boolean success = deleteDir(new File(dir, aChildren));
                    if (!success) return false;
                }
            }
        }
        return dir.delete();
    }


}
