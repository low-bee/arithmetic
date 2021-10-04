package com.xiaolong.arithmetic;

import org.junit.jupiter.api.Test;

import javax.lang.model.element.VariableElement;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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

    @Test
    void testRef() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        // 因为方法由重载，要想调用方法，必须传入方法名 + 参数类型
        Method licenseKeyFormatting = FormatLicenseKey.class.getMethod("licenseKeyFormatting", String.class, int.class);
        Object[] a = new Object[]{"123-123-123-123", 2};
        // invoke 一个对象的实例
        Object invoke = licenseKeyFormatting.invoke(FormatLicenseKey.class.getConstructor().newInstance(), a);
        System.out.println(invoke.toString());
    }
}