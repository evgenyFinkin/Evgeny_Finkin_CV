package com.example.jonfi.evgenyfinkincv;

//All my String constants

public class Constants {
    private static final String PhoneNum = "0548062240";
    private static final String[] MailAddress = {"jon.finkin@gmail.com"};
    private static final String Subject = "Schedule a job interview";
    private static final String Body = "We were very impressed with your abilities and we are interested in setting up a job interview.";
    private static final String LinkedinUrl = "https://www.linkedin.com/in/evgeny-finkin-3a1809b0/";
    private static final String GitUrl = "http://api.github.com";

    public static String getPhoneNum() {
        return PhoneNum;
    }

    public static String[] getMailAddress() {
        return MailAddress;
    }

    public static String getSubject() {
        return Subject;
    }

    public static String getBody() {
        return Body;
    }

    public static String getLinkedinUrl() {
        return LinkedinUrl;
    }

    public static String getGitUrl() {
        return GitUrl;
    }
}