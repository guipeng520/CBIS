package com.school.cbis.util;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * Created by Administrator on 2016/3/29.
 */
public class RandomUtils {
    private static final int DEF_COUNT = 20;

    private static final int MOBILE_COUNT = 6;

    private RandomUtils() {

    }

    /**
     * Generates a password.
     *
     * @return the generated password
     */
    public static String generatePassword() {
        return RandomStringUtils.randomAlphanumeric(DEF_COUNT);
    }

    /**
     * Generates an activation key.
     *
     * @return the generated activation key
     */
    public static String generateActivationKey() {
        return RandomStringUtils.randomNumeric(DEF_COUNT);
    }

    /**
     * Generates a reset key.
     *
     * @return the generated reset key
     */
    public static String generateResetKey() {
        return RandomStringUtils.randomNumeric(DEF_COUNT);
    }

    /**
     * Generates a autonomous_practice_head title_variable
     *
     * @return the autonomous_practice_head title_variable
     */
    public static String generateTitleVariable() {
        return "v_" + RandomStringUtils.randomAlphanumeric(DEF_COUNT);
    }

    /**
     * Generates a email check key
     *
     * @return the email check key
     */
    public static String generateEmailCheckKey() {
        return RandomStringUtils.randomAlphanumeric(DEF_COUNT);
    }

    /**
     * Generates a mobile check key
     *
     * @return the mobile check key
     */
    public static String generateMobileKey() {
        return RandomStringUtils.randomNumeric(MOBILE_COUNT);
    }
}
