package org.lindbergframework.beans.di;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

/**
 * @author Laudelino Martins Cardoso Neto
 * @author Victor Lindberg
 */
class LindbergDIClassLoader extends URLClassLoader {

    private String urlPath;

    public LindbergDIClassLoader() {
        super(new URL[] {});
    }

    public void addJarFile(String path) {
        try {
            urlPath = "jar:file://" + path + "!/";
            addURL(new URL(urlPath));
        } catch (Exception e) {
            throw new RuntimeException("unable to add "+path);
        }
    }

    public List<Method> getClassMethods(String className) {
    	List<Method> methods = new ArrayList<Method>();
        try {
            Class clazz = this.loadClass(className);
            Method declaredMethods[] = clazz.getDeclaredMethods();

            for (int i = 0; i < declaredMethods.length; i++) {
                methods.add(declaredMethods[i]);
            }

        } catch (Throwable e) {
            throw new RuntimeException("unable to load class methods : "+className);
        }
        
        return methods;
    }

    public List<String> getClassNamesInPackage(String jarName,
        List<String> exclusions) {
        ArrayList classList = new ArrayList();

        try {
            JarInputStream jarFile = new JarInputStream(new FileInputStream(
                jarName));
            JarEntry jarEntry;

            while (true) {
                jarEntry = jarFile.getNextJarEntry();
                if (jarEntry == null) {
                    break;
                }

                String name = jarEntry.getName();
                if (ClassMappingUtil.isExclusion(name, exclusions))
                    continue;

                classList.add(name.replaceAll("/", "\\."));
            }
        } catch (Exception e) {
            throw new RuntimeException("error loading classes from "+jarName);
        }

        return classList;
    }

}