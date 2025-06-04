package com.orangehrmdemo.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Arrays;
import java.util.List;

public class Utilities {

    public static List<String> genaraterandom(){
        String firstname =  RandomStringUtils.randomAlphabetic(4);
        String lastname = RandomStringUtils.randomAlphabetic(4);
        String empid = RandomStringUtils.randomNumeric(4);

        return Arrays.asList(firstname,lastname,empid);
    }
}
