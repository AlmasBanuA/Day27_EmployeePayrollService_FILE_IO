package com.day27.employeepayroll;

/**
 * importing java IO File
 */
import java.io.File;

/**
 * program to demonstrate File Operations like Delete File and Check File Not
 * Exist
 * 
 * @author user -Almas
 *
 */
public class FileUtils {

	/**
	 * created method deleteFiles to delete a File that has created
	 * 
	 * @param contentsToDelete -Contents in a file will be deleted
	 * @return -return to method created
	 */
	public static boolean deleteFiles(File contentsToDelete) {
		File[] allContents = contentsToDelete.listFiles();

		/**
		 * taking if else condition check all contents in a file should be not null if
		 * not null then it will enters the for each loop and delete that file
		 */
		if (allContents != null) {
			for (File file : allContents) {
				deleteFiles(file);
			}
		}
		return contentsToDelete.delete();
	}
}

