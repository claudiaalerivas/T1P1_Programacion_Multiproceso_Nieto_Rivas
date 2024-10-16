import java.io.File;
import java.util.ArrayList;

import org.salesianos.util.FileHelper;
import org.salesianos.util.ProcessLauncher;

public class App {
    public static void main(String[] args) throws Exception {
        final String ROUTE_FILE = "./input/Numbers.txt";
        final String ROUTE_FINAL = "./output/file/NumbesPrime.txt";
        ArrayList<Integer> numbers = FileHelper.getAllNumbers(ROUTE_FILE);
        ArrayList<Process> processes = new ArrayList<>();
        ArrayList<String> numbersTemp = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            String pathFile = "./output/temp/" + numbers.get(i) + ".txt";
            Process subProcess = ProcessLauncher.initIsPrime(numbers.get(i), pathFile);
            processes.add(subProcess);
            numbersTemp.add(pathFile);
        }

        for (Process subProcess : processes) {
            subProcess.waitFor();
        }
        FileHelper.mergePrimeFiles(numbersTemp, ROUTE_FINAL);

        for (int i = 0; i < numbers.size(); i++) {
            String pathFile = "./output/temp/" + numbers.get(i) + ".txt";
            File file = new File(pathFile);
            file.delete();
        }

        System.out.println("There are " + FileHelper.getNumbersCount(ROUTE_FINAL) + " prime numbers.");
        FileHelper.showPrimes(ROUTE_FINAL);

    }

} 