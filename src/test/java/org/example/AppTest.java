package org.example;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class AppTest {

    @Test
    public void checkSettingProperty() throws IOException {
        File setting = new File("src/test/java/resources/testSetting.txt");
        BufferedInputStream bis = null;

        try {
            bis = new BufferedInputStream(new FileInputStream(setting));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Map<String, String> expected = new HashMap<>();
        expected.put("port", "9999");
        expected.put("host", "www.localhost");

        Map<String, String> actual = App.settingProperty(bis);

        Assertions.assertEquals(expected, actual);
    }

}

