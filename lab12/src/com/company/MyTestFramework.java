package com.company;

import java.lang.reflect.Method;

public class MyTestFramework {
    public static void testFramework (String args) throws Exception {
        int passed = 0, failed = 0;
        for (Method m : Class.forName(args).getMethods()) {
            if (m.isAnnotationPresent(Test.class)) {
                try {
                    m.invoke(null);
                    passed++;
                } catch (Throwable ex) {
                    System.out.printf("Test %s failed: %s %n",
                            m, ex.getCause());
                    failed++;

                    System.out.printf("Passed: %d, Failed %d%n", passed, failed);
                }        }
            }
        }
}
