package pers.xiaoming.notebook.lang.classloader;

import java.net.URL;
import java.net.URLClassLoader;

public class URLPathClassLoader extends URLClassLoader {
    private final String packagePath;

    public URLPathClassLoader(URL[] urls, ClassLoader parent, String packagePath) {
        super(urls, parent);
        this.packagePath = packagePath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class<?> targetClass = findLoadedClass(name);

        // 1. if already loaded, just return the loaded class
        if (targetClass != null) {
            return targetClass;
        }

        // 2. if not loaded before, load with URLPathClassLoader if within the package
        if (!packagePath.startsWith(name)) {
            return super.loadClass(name);
        }
        // 3. target class not in specified path, use default class loader to load
        else {
            return findClass(name);
        }
    }
}
