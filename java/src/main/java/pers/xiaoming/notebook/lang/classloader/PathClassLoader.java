package pers.xiaoming.notebook.lang.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class PathClassLoader extends ClassLoader {
    private final String classPath;
    private final String packagePath;

    public PathClassLoader(String classPath, String packagePath) {
        this.classPath = classPath;
        this.packagePath = packagePath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        if (name == null) {
            throw new ClassNotFoundException();
        }

        if (name.startsWith(packagePath)) {
            byte[] classData = getData(name);
            if (classData == null) {
                throw new ClassNotFoundException();
            } else {
                return defineClass(name, classData, 0, classData.length);
            }
        } else {
            // Don't call super.loadClass(name);
            throw new ClassNotFoundException();
        }
    }

    private byte[] getData(String className) {
        String path = classPath + File.separator + className.replace('.', File.separatorChar) + ".class";
        try {
            InputStream in = new FileInputStream(path);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] buffer = new byte[2048];
            int num = 0;
            while ((num = in.read(buffer)) != -1) {
                out.write(buffer, 0, num);
            }
            return out.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
