package sit707_week4;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests functions in LoginForm.
 * @author Ahsan Habib
 */
public class LoginFormTest {

    @Test
    public void testStudentIdentity() {
        String studentId = "220437608"; // replace with your student ID
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "AZMAH"; // replace with your name
        Assert.assertNotNull("Student name is null", studentName);
    }

    @Test
    public void testEmptyUsernameAndEmptyPassword() {
        LoginStatus status = LoginForm.login("", "");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getErrorMsg());
    }

    @Test
    public void testEmptyUsernameAndWrongPassword() {
        LoginStatus status = LoginForm.login("", "wrongpass");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getErrorMsg());
    }

    @Test
    public void testWrongUsernameAndWrongPassword() {
        LoginStatus status = LoginForm.login("wronguser", "wrongpass");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
    }

    @Test
    public void testCorrectUsernameAndEmptyPassword() {
        LoginStatus status = LoginForm.login("ahsan", "");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Password", status.getErrorMsg());
    }

    @Test
    public void testCorrectUsernameAndWrongPassword() {
        LoginStatus status = LoginForm.login("ahsan", "wrongpass");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
    }

    @Test
    public void testEmptyUsernameAndCorrectPassword() {
        LoginStatus status = LoginForm.login("", "ahsan_pass");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getErrorMsg());
    }

    @Test
    public void testWrongUsernameAndCorrectPassword() {
        LoginStatus status = LoginForm.login("wronguser", "ahsan_pass");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
    }

    @Test
    public void testCorrectUsernameAndCorrectPassword() {
        LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
        Assert.assertTrue(status.isLoginSuccess());
        Assert.assertEquals("123456", status.getErrorMsg());
    }

    @Test
    public void testCorrectUsernameAndCorrectPasswordEmptyCode() {
        LoginForm.login("ahsan", "ahsan_pass");
        Assert.assertFalse(LoginForm.validateCode(""));
    }

    @Test
    public void testCorrectUsernameAndCorrectPasswordWrongCode() {
        LoginForm.login("ahsan", "ahsan_pass");
        Assert.assertFalse(LoginForm.validateCode("wrongcode"));
    }

    @Test
    public void testCorrectUsernameAndCorrectPasswordCorrectCode() {
        LoginForm.login("ahsan", "ahsan_pass");
        Assert.assertTrue(LoginForm.validateCode("123456"));
    }
}
