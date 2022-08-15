package com.bridgelabz.CensusAnalyser;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class IndianCensusAnalyser {

	public static final String PATH = "E:/Rahul Proejcts/IndiaStateCensusData.csv";
	public static final String STATE_FILE_PATH = "E:/Rahul Proejcts/IndiaStateCode.csv";

	/*
	 * Method to read csv file & returns number of records
	 */
	public int loadIndiaCensusData(String path) throws CensusAnalyserException {
		try {
			Reader reader = Files.newBufferedReader(Paths.get(PATH));
			CsvToBeanBuilder<IndiaCensusCSV> csvCsvToBeanBuilder = new CsvToBeanBuilder<IndiaCensusCSV>(reader);
			csvCsvToBeanBuilder.withType(IndiaCensusCSV.class);
			csvCsvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
			CsvToBean<IndiaCensusCSV> csvToBean = csvCsvToBeanBuilder.build();
			Iterator<IndiaCensusCSV> censusCSVIterator = csvToBean.iterator();
			int numOfEntries = 0;
			while (censusCSVIterator.hasNext()) {
				numOfEntries++;
				censusCSVIterator.next();
			}
			return numOfEntries;
		} catch (IOException e) {
			throw new CensusAnalyserException(e.getMessage(),
					CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
		}
	}

	/*
	 * Method to read state code csv file & returns number of records
	 */
	public int loadStateCodeData(String path) throws CensusAnalyserException {
		try (Reader reader = Files.newBufferedReader(Paths.get(STATE_FILE_PATH))) {
			CsvToBeanBuilder<StateCodeCensusCsv> csvCsvToBeanBuilder = new CsvToBeanBuilder<StateCodeCensusCsv>(reader);
			csvCsvToBeanBuilder.withType(StateCodeCensusCsv.class);
			csvCsvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
			CsvToBean<StateCodeCensusCsv> csvToBean = csvCsvToBeanBuilder.build();
			Iterator<StateCodeCensusCsv> censusCSVIterator = csvToBean.iterator();
			int numOfEntries = 0;
			while (censusCSVIterator.hasNext()) {
				numOfEntries++;
				censusCSVIterator.next();
			}
			return numOfEntries;
		} catch (IOException e) {
			throw new CensusAnalyserException(e.getMessage(),
					CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
		}
	}

	public static void main(String[] args) {
		System.out.println("****************** Welcome To Indian Census Analyzer *****************\n");
		try {
			IndianCensusAnalyser census = new IndianCensusAnalyser();
			System.out.println("Number of Records : " + census.loadIndiaCensusData(PATH));
			System.out.println(census.loadStateCodeData(STATE_FILE_PATH));
		} catch (CensusAnalyserException e) {
			e.printStackTrace();
		}
	}

}