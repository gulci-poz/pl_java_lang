package com.gulci.java;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CrewManager {
    private static final String FILENAME = "C:\\projects\\java\\pl_java_lang\\src\\SpecialistsList.txt";
    private static CrewMember[] pool;

    public static CrewMember FindAvailable(CrewMember.FlightCrewJob job) {
        CrewMember cm = null;

        for (int i = 0; i < pool.length; i++) {
            if (pool[i] != null && pool[i].getJob() == job) {
                cm = pool[i];
                pool[i] = null;
                break;
            }
        }

        return cm;
    }

    static {
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(FILENAME));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        String line;
        int idx = 0;
        pool = new CrewMember[10];

        try {
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                // we're sure that the job names from the file match these from the enum FlightCrewJob
                CrewMember.FlightCrewJob job = CrewMember.FlightCrewJob.valueOf(parts[0]);
                pool[idx] = new CrewMember(job);
                pool[idx].setName(parts[1]);
                idx++;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
