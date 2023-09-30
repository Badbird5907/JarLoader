package dev.badbird.jarloader;

import java.io.File;
import java.io.IOException;
import java.util.jar.JarFile;

public class JarLoader {
    public static void premain(String args, java.lang.instrument.Instrumentation inst) {
        System.out.println("[PREMAIN] Loading Libraries...");
        File libs = new File("lib");
        int added = 0;
        if (libs.exists()) {
            for (File file : libs.listFiles()) {
                if (file.getName().endsWith(".jar")) {
                    try {
                        inst.appendToSystemClassLoaderSearch(new JarFile(file));
                        added++;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("[PREMAIN] Loaded " + added + " libraries.");
        } else {
            System.out.println("[PREMAIN] Libraries folder not found.");
        }
    }
}