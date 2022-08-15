package com.bridgelabz.CensusAnalyser;

import org.junit.Assert;
import org.junit.Test;

public class IndiaCensusAnalyserTest {

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

}
