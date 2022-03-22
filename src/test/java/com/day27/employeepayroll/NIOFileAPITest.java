package com.day27.employeepayroll;

/**
 * importing different classes
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Test;

public class NIOFileAPITest {

	/**
	 * private variables can only be accessed within the same class (an outside
	 * class has no access to it) private = restricted access However, it is
	 * possible to access them if we provide public get and set methods.
	 */
	private static String HOME = System.getProperty("user.home");
	private static String PLAY_WITH_NIO = "TempPlayGround";

	@Test

	/**
	 * created method here when we given a path it will checked if it is exist or
	 * not and confirm and if it is not exist then throws IOException
	 * 
	 * @throws IOException -throws exception
	 */
	public void givenPathWhenCheckedThenConfirm() throws IOException {
		/**
		 * check file exists or not
		 */
		Path homePath = Paths.get(HOME);
		Assert.assertTrue(Files.exists(homePath));

		/**
		 * delete file and check file not exists
		 */
		Path playPath = Paths.get(HOME + "/" + PLAY_WITH_NIO);
		/*
		 * if(Files.exists(playPath)) FileUtils.deleteFiles(playPath.toFile());
		 * Assert.assertTrue(Files.notExists(homePath));
		 */

		/**
		 * create directory of playpath
		 */
		Files.createDirectory(playPath);
		Assert.assertTrue(Files.exists(playPath));

		/**
		 * create File
		 */
		IntStream.range(1, 10).forEach(cntr -> {
			Path tempFile = Paths.get(playPath + "/temp" + cntr);
			Assert.assertTrue(Files.notExists(tempFile));
			try {
				Files.createFile(tempFile);
			} catch (IOException e) {
			}
			Assert.assertTrue(Files.exists(tempFile));
		});

		/**
		 * List files, Directories as well as Files with Extension
		 */
		Files.list(playPath).filter(Files::isRegularFile).forEach(System.out::println);
		Files.newDirectoryStream(playPath).forEach(System.out::println);
		Files.newDirectoryStream(playPath, path -> path.toFile().isFile() && path.toString().startsWith("temp"))
				.forEach(System.out::println);

	}

}
