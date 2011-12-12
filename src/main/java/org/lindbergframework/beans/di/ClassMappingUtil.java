package org.lindbergframework.beans.di;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

import org.apache.commons.lang.StringUtils;
import org.lindbergframework.util.CollectionsUtil;

/**
 * Utilitary Class for Mapping operations.
 *  
 * @author Victor Lindberg
 *
 */
class ClassMappingUtil {
	
	/**
	 * List classes in the project.
	 * 
	 * @throws URISyntaxException
	 * 
	 */
	public static Collection<String> listClassesInProject(String basePackage) throws URISyntaxException {
		return scan(basePackage, Thread.currentThread().getContextClassLoader());
	}

	/**
	 * Executes scan in the project for ma classes.
	 * 
	 * @param basePackage base package where to do mapping
	 * @param classLoader classLoader.
	 * @return Collection of strings with the classes full names
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
		String formatBasePackage = formatBasepackage(basePackage);
	    formatBasePackage = StringUtils.removeStart(formatBasePackage, "/");
		for (URL url : urls){
		   List<String> classList = null;
		   if (url.getPath().startsWith("jar:") ||
		       url.getPath().endsWith(".jar")){
		       classList = lindbergClassLoader.getClassNamesInJar(url.toURI().getPath(), exclusions);
		       classList = cleanClasses(basePackage, classList, findInSubPackages);
		       classes.addAll(classList);
		   }else{
			  String path = StringUtils.removeEnd(url.getPath(),"/") + "/"; 
			  
		      File location = new File(path + formatBasePackage);
	          getClassesInDirectory(basePackage,null,
				    location,classes, findInSubPackages,exclusions);
		   }
		}
		
		for (int i = 0; i < classes.size();i++)
		    classes.set(i, StringUtils.removeEnd(classes.get(i),".class"));
		
		TreeSet<String> uniqueCollection = new TreeSet<String>(classes);//eliminate duplicates

		return uniqueCollection;
	}
	
	/**
	 * Checks if the basepackage param contains character of sub package '*'
	 * 
	 * @param basePackage base package param.
	 * 
	 * @return true if is subpackages ou false if is not subpackage.
	 */
	private static boolean isFindSubPackages(String basePackage){
	    return basePackage.endsWith("*");
	}
	
	/**
	 * Removes the subpackage token from basepackage param.
	 * 
	 * @param basePackage base package param.
	 * 
	 * @return basepackeage param without subpackage token.
	 */
	private static String removeTokenSubPackages(String basePackage){
	    int indexSubPackages = basePackage.lastIndexOf("*");
        if (indexSubPackages == -1)
            return basePackage;
        
        return  basePackage.substring(0, indexSubPackages - 1);
	}
	
	private static String formatBasepackage(String basePackage){
	    return basePackage.replace( ".", "/");
	}
	
	/**
	 * Extracts all exclusions packages from basepackage param.
	 * 
	 * @param base base package param.
	 * 
	 * @return list of stirngs with exclusions packages.
	 */
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
	
	/**
	 * Removes exclusions packages from basepackage param.
	 * 
	 * @param base base package param.
	 * @return string from basepackage param without exclusion token.
	 */
	private static String removeTokenExclusions(String base){
	    int indexExclusionsToken = base.indexOf(":");
	    if (indexExclusionsToken == -1)
	        return base;
	    
	    return base.substring(0, indexExclusionsToken);
	}
	
	/**
	 * Clean list of classes removing classes that are not inside basepackage.
	 * 
	 * @param basePack basepackage param.
	 * @param classes list of classes (string)
	 * @param findInSubPackage true if subpackage token is present in base package param.
	 * 
	 * @return list of classes.
	 */
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
	
	/**
	 * Checks if the class name is inside of exclusions.
	 * 
	 * @param name class name.
	 * @param exclusions list of exclusions.
	 * 
	 * @return true if the class name is inside of exclusions.
	 */
	public static boolean isExclusion(String name, List<String> exclusions){
	    for (String exc : exclusions)
	        if (name.contains(exc) || 
	            name.contains(exc.replace("/", "\\")))
	            return true;
	    
	    return false;
	}

	/**
	 * Load classes from location in classList argument.
	 *  
	 * @param base base package param.
	 * @param parent location parent.
	 * @param location actual location.
	 * @param classList list of classes.
	 * @param findInSubPackages
	 * @param exclusions list of exclusions.
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
