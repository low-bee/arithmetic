package com.xiaolong.arithmetic;

import static org.junit.jupiter.api.Assertions.*;

class FormatLicenseKeyTest {
    FormatLicenseKey testObj ;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        testObj = new FormatLicenseKey();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void licenseKeyFormatting() {

        assert "12-31-23-12-31-23".equals(testObj.licenseKeyFormatting("123-123-123-123", 2));
    }
}