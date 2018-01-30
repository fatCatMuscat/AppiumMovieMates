package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static Utils.BaseTest.driver;

public class Listeners implements ITestListener {

    ProcessTestRunnable processTestRunnable = null;

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

        String startDir = System.getProperty("user.dir");
        ProcessBuilder pb = new ProcessBuilder("adb", "logcat", "-d", "MainActivity:V");
        pb.directory(new File(startDir));
        pb.redirectErrorStream(true);

        Process p = null;
        try {
            p = pb.start();
        }   catch (IOException e) {e.printStackTrace();}
        String nameOfLogs = iTestContext.getName() + "logs.log";
        processTestRunnable = new ProcessTestRunnable(p, nameOfLogs);
        Thread logThread = new Thread(processTestRunnable);
        logThread.start();
        try {
            p.waitFor();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        processTestRunnable.killProcess();
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
        } else if (status.equalsIgnoreCase("pass")) {
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

    static class ProcessTestRunnable implements Runnable {

        Process p;
        BufferedReader br;
        String nameOfFile;

        ProcessTestRunnable(Process p, String nameOfFile) {
            this.p = p;
            this.nameOfFile = nameOfFile;
        }

        @Override
        public void run() {
            try {
                InputStreamReader isr = new InputStreamReader(p.getInputStream());

                br = new BufferedReader(isr);
                String line = null;
                PrintWriter writer = null;

                try {
                    writer = new PrintWriter(nameOfFile, "UTF-8");
                } catch (IOException e) {
                    e.printStackTrace();
                }

                while ((line = br.readLine()) != null) {
                    writer.println(line);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        public void killProcess() {
            this.p.destroy();
        }
    }
}
