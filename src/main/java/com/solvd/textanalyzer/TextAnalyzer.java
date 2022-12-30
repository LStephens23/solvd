package main.java.com.solvd.textanalyzer;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.java.com.solvd.vehiclefactory.Runner;

public class TextAnalyzer {
	private static Logger logger = LogManager.getLogger(Runner.class.getName());

	public static void main(String[] args) {

		try {
			String input = FileUtils.readFileToString(new File("src/main/resources/input.txt"), StandardCharsets.UTF_8).replaceAll("[^A-Za-z]", " ");
			String[] words = StringUtils.split(input, " ");
			Map<String, Integer> wordCounts = new TreeMap<>();
			Arrays.stream(words).forEach(word -> wordCounts.merge(word.toLowerCase(), 1, (old, one) -> old + one) );

			StringBuilder sb = new StringBuilder();
			wordCounts.entrySet().stream().forEach(entry -> sb.append(entry.getKey() + ": " + entry.getValue() + "\n"));
			FileUtils.writeStringToFile(new File("src/main/resources/results.txt"), sb.toString(), StandardCharsets.UTF_8);
			
		} catch (IOException e) {
			logger.info(e);
		}

	}

}
