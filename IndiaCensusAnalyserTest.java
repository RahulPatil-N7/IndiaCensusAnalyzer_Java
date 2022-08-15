package com.bridgelabz.CensusAnalyser;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class IndiaCensusAnalyserTest {

	private static final String WRONG_CSV_FILE_PATH = "E:/Rahul Proejcts/";
	private static final String WRONG_CSV_FILE_TYPE = "E:/Rahul Proejcts/IndiaStateCensusData.txt";
	private static final String WRONG_STATECSV_FILE_TYPE = "E:/Rahul Proejcts/IndiaStateCode.txt";

	/*
	 * TC 1.1 -Given the States Census CSV file, Check to ensure the Number of
	 * Record matches
	 */
	@Test
	public void givenIndianCensusCSVFileReturnsCorrectRecords() {
		try {
			IndianCensusAnalyser censusAnalyser = new IndianCensusAnalyser();
			int numOfRecords = censusAnalyser.loadIndiaCensusData(IndianCensusAnalyser.PATH);
			Assert.assertEquals(29, numOfRecords);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
		}
	}

	/*
	 * TC 1.2 -Given the State Census CSV File if incorrect Returns a custom
	 * Exception
	 */
	@Test
	public void givenIndiaCensusData_WithWrongFile_ShouldThrowException() {
		try {
			IndianCensusAnalyser censusAnalyser = new IndianCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadIndiaCensusData(WRONG_CSV_FILE_PATH);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
		}
	}

	/*
	 * TC 1.3 -Given the State Census CSV file with incorrect type, Should throw
	 * exception.
	 */
	@Test
	public void givenIndiaCensusCSVFile_WhenLoadedWithWrongType_ShouldThrowException() {
		try {
			IndianCensusAnalyser censusAnalyser = new IndianCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadIndiaCensusData(WRONG_CSV_FILE_TYPE);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
		}
	}

	/*
	 * TC 1.4 -Given the State Census CSV file with incorrect Delimiter, Should
	 * throw exception.
	 */
	@Test
	public void givenIndiaCensusCSVFile_WhenLoadedWithWrongDelimiter_ShouldThrowException()
			throws CensusAnalyserException {
		IndianCensusAnalyser censusAnalyser = new IndianCensusAnalyser();
		try {
			int numOfRecord = censusAnalyser.loadIndiaCensusData(IndianCensusAnalyser.PATH);
			Assert.assertEquals(29, numOfRecord);
		} catch (Exception e) {
			System.out.println("State Census CSV file with incorrect Delimiter");
		}
	}

	/*
	 * TC 1.5 -Given the State Census CSV file with incorrect Column Name, Should
	 * throw exception.
	 */
	@Test
	public void givenIndiaCensusCSVFile_WhenLoadedWithWrongColumn_ShouldThrowException() {
		try {
			IndianCensusAnalyser censusAnalyser = new IndianCensusAnalyser();
			int numOfRecord = censusAnalyser.loadIndiaCensusData(IndianCensusAnalyser.PATH);
			Assert.assertEquals(29, numOfRecord);
		} catch (CensusAnalyserException e) {
			System.out.println("State Census CSV file with incorrect header.");
		}
	}

	/*
	 * TC 2.1 -Given the States Code CSV file, Check to ensure the Number of Record
	 * matches.
	 */
	@Test
	public void givenIndiaStateCodeCSVFile_WhenLoaded_ShouldReturnCorrectRecords() {
		try {
			IndianCensusAnalyser censusAnalyser = new IndianCensusAnalyser();
			int numOfRecord = censusAnalyser.loadStateCodeData(IndianCensusAnalyser.STATE_FILE_PATH);
			Assert.assertEquals(37, numOfRecord);
		} catch (CensusAnalyserException e) {

		}
	}

	/*
	 * TC 2.2 -Given the State Census CSV file incorrect, returns a custom
	 * exception.
	 */
	@Test
	public void givenIndiaStateCodeData_WithWrongFile_ShouldThrowException() {
		try {
			IndianCensusAnalyser censusAnalyser = new IndianCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadStateCodeData(WRONG_CSV_FILE_PATH);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
		}
	}

	/*
	 * TC 2.3 -Given the State Code CSV file with incorrect type, Should throw
	 * exception.
	 */
	@Test
	public void givenIndiaStateCodeCSVFile_WhenLoadedWithWrongType_ShouldThrowException() {
		try {
			IndianCensusAnalyser censusAnalyser = new IndianCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadStateCodeData(WRONG_STATECSV_FILE_TYPE);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
		}
	}

}
