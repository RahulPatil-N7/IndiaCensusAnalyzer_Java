package com.bridgelabz.CensusAnalyser;

import com.opencsv.bean.CsvBindByName;

public class StateCodeCensusCsv {

	@CsvBindByName(column = "SrNo")
	private int srNo;

	@CsvBindByName(column = "State Name")
	private String state;

	@CsvBindByName(column = "TIN")
	private int tin;

	@CsvBindByName(column = "StateCode")
	private String stateCode;

	@Override
	public String toString() {
		return "IndiaStateCodeCSV{" + "srNo=" + srNo + ", state='" + state + '\'' + ", tin=" + tin + ", stateCode='"
				+ stateCode + '\'' + '}';
	}

}
