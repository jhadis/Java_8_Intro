package com.hadis.airlineroutes.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.ws.rs.ApplicationPath;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import com.hadis.airlineroutes.config.AirlineRouteAppConfig;
import com.hadis.airlineroutes.config.AirlineRouteAppConfigDB;
import com.hadis.airlineroutes.model.Route;

/**
 * Reads in point to point routes from file and stores in graph
 * @author Jonathan
 *
 */

public class DataIngester {
	
	public DataStoreUtil storage = null;
	
	@Autowired
	public void setStorage(DataStoreUtil storage) {
		this.storage = storage;
	}

	/**
	 * Expects route in input file to be on separate lines in form "Starting Point:Ending Point" 
	 * @param inputFile
	 */
	public DataIngester(Scanner inputFile) {		
		if (this.storage != null) {
			System.out.println("storage var was injected by Spring");
			System.out.println("storage var class name: " +storage.getClass().getName());
		} else {
			System.out.println("storage var was NOT injected by Spring");
		}

		readFileAndStore(inputFile);
	}
	
	protected void readFileAndStore(Scanner inputFile) {
		while (inputFile.hasNextLine()) {
			StringTokenizer st = new StringTokenizer(inputFile.nextLine(), ":");
			Route record = new Route(st.nextToken(), st.nextToken());
			try {
				storage.storeRecord(record);
			} catch (Exception e) {
				System.out.println("Couldn't store record: " +record);
			}
		}		
	}

	public static void main(String[] args) throws FileNotFoundException {
		if (args.length == 1) {
			String fileName = args[0];
			File inputFile = new File(fileName);
			if (inputFile != null) {
				Scanner inputFileScanner = new Scanner(inputFile);
				DataIngester app = new DataIngester(inputFileScanner);
			}
			
			
		}
		else {
			System.err.println("Must provide filename of text file containing routes");
		}

	}

}
