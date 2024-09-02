package tests;

import org.testng.*;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

import static tests.ChildTest.cdriver;

public class TestNGListener implements ITestListener, IExecutionListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test succeeded: " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test skipped: " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Test failed but within success percentage: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Reporter.setCurrentTestResult(result);
        System.out.println("Test failed: " + result.getName());
        if (cdriver != null) {
            String screenshotPath = ScreenshotUtil.captureScreenShot(cdriver, result.getName());
            System.out.println("Screenshot captured at: " + screenshotPath);
            try {
                File screenshotFile = new File(screenshotPath);
                String base64Image = "data:image/png;base64," + encodeFileToBase64Binary(screenshotFile);
                Reporter.log("<a href='" + base64Image + "'>Screenshot for " + result.getName() + "</a><br>");
                Reporter.log("<img src='" + base64Image + "' height='600' width='1500'/><br>");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test context started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test context finished: " + context.getName());
    }

    private String encodeFileToBase64Binary(File file) throws IOException {
        byte[] fileContent = FileUtils.readFileToByteArray(file);
        return Base64.getEncoder().encodeToString(fileContent);
    }
}
