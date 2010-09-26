package org.lindbergframework.beans.di;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

import org.apache.commons.lang.StringUtils;
import org.lindbergframework.util.CollectionsUtil;
import org.springframework.util.CollectionUtils;

/**
 * 
 * @author Victor Lindberg
 *
 */
class ClassMappingUtil {
	
	/**
	 * ScannerProjectClasses
	 * @throws URISyntaxException 
	 * 
	 */
	public static Collection<String> listClassesInProject(String basePackage) throws URISyntaxException {
		return scan(basePackage, Thread.currentThread().getContextClassLoader());
	}

	/**
	 * scan
	 * 
	 * @param classLoader
	 *            ClassLoader
	 * @throws URISyntaxException 
	 */
	private static Collection<String> scan(String basePackage, ClassLoader classLoader) throws URISyntaxException {
		List<String> classes = new ArrayList<String>();
		
		if (!(classLoader instanceof URLClassLoader)) {
			return classes;
		}
        
		boolean findInSubPackages = isFindSubPackages(basePackage);
		basePackage = removeTokenSubPackages(basePackage);
		
		URL[] urls = ((URLClassLoader) classLoader).getURLs();
		
		List<String> exclusions = extractExclusions(formatBasepackage(basePackage));
		basePackage = removeTokenExclusions(basePackage);
		
		LindbergDIClassLoader lindbergClassLoader = new LindbergDIClassLoader();
		for (URL url : urls){
		   List<String> classList = null;
		   if (url.getPath().startsWith("jar:") ||
		       url.getPath().endsWith(".jar")){
		       classList = lindbergClassLoader.getClassNamesInPackage(url.toURI().getPath(), exclusions);
		       classList = cleanClasses(basePackage, classList, findInSubPackages);
		       classes.addAll(classList);
		   }else{
		      File location = new File(url.getPath()+formatBasepackage(basePackage));
	          getClassesInDirectory(basePackage,null,
				    location,classes, findInSubPackages,exclusions);
		   }
		}
		
		for (int i = 0; i < classes.size();i++)
		    classes.set(i, StringUtils.removeEnd(classes.get(i),".class"));
		
		TreeSet<String> uniqueCollection = new TreeSet<String>(classes);//eliminate duplicates

		return uniqueCollection;
	}
	
	private static boolean isFindSubPackages(String basePackage){
	    return basePackage.endsWith("*");
	}
	
	private static String removeTokenSubPackages(String basePackage){
	    int indexSubPackages = basePackage.lastIndexOf("*");
        if (indexSubPackages == -1)
            return basePackage;
        
        return  basePackage.substring(0, indexSubPackages - 1);
	}
	
	private static String formatBasepackage(String basePackage){
	    return basePackage.replace( ".", "/");
	}
	
	private static List<String> extractExclusions(String base){
	    List<String> list = CollectionsUtil.asList(base.split(":"));
	    base = removeTokenExclusions(base);
	    if (! list.isEmpty())
	        list.remove(0);
	    
	    for (int i = 0; i < list.size();i++){
	        list.set(i, base+"/"+list.get(i));
	    }
	    
	    return list;
	}
	
	private static String removeTokenExclusions(String base){
	    int indexExclusionsToken = base.indexOf(":");
	    if (indexExclusionsToken == -1)
	        return base;
	    
	    return base.substring(0, indexExclusionsToken);
	}
	
	private static List<String> cleanClasses(String basePack, List<String> classes, boolean findInSubPackage){
	    basePack = removeTokenSubPackages(basePack);
	    List<String> cleanList = new ArrayList<String>();
	    for (String clazz : classes)
	        if (clazz.contains(basePack) && clazz.endsWith(".class")){
	            if (! findInSubPackage){
	               int indexDocClass = clazz.lastIndexOf(".class");
	               String sub = clazz.substring(basePack.length() + 1,indexDocClass);
	               sub = StringUtils.removeEnd(sub, ".class");
	               if (sub.indexOf(".") != -1)
	                   continue;
	            }
	             
	            cleanList.add(clazz);
	        }
	    
	    return cleanList;
	}
	
	public static boolean isExclusion(String name, List<String> exclusions){
	    for (String exc : exclusions)
	        if (name.contains(exc) || 
	            name.contains(exc.replace("/", "\\")))
	            return true;
	    
	    return false;
	}

	/**
	 * getClassesInDirectory
	 * 
	 * @param parent
	 *            String
	 * @param location
	 *            File
	 */
	private static void getClassesInDirectory(String base, String parent, File location, List<String> classList, boolean findInSubPackages, List<String> exclusions) {
		File[] files = location.listFiles();
        if (files == null)
            return;
        
		for (File file : files) {
			StringBuilder builder = new StringBuilder();

			builder.append(parent).append(".").append(file.getName());

			String path = (parent == null ? file.getName() : builder.toString());
			
			if (findInSubPackages && file.isDirectory()) {
			    if (isExclusion(file.getPath(), exclusions))
			        continue;
				getClassesInDirectory(base, path, file,classList, findInSubPackages,exclusions);
			}
			else if (file.getName().endsWith(".class")) {
				int p = path.indexOf("$");

				if (p != -1) {
					path = path.substring(0, p);
				}

				if (path.contains("class")) {
					path = path.substring(0, path.length() - 6);
					classList.add(base+"."+path);
				}
			}
		}
	}
	
	
}
