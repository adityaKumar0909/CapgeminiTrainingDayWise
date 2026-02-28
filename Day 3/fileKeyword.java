import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class fileKeyword {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String dirName = sc.nextLine();
        File dir = new File(dirName);

        if (dir.exists() && dir.isDirectory()) {
            String content[] = dir.list();
            HashMap<String, Long> mpp = new HashMap<>();

            if (content != null) {
                for (String x : content) {
                    if (x.endsWith(".java")) {
                        File javaFile = new File(dir, x);
                        if(javaFile.isFile()) {
                            mpp.put(x, javaFile.length());
                        }
                    }
                }
            }

            LinkedHashMap<String, Long> sortedMap = mpp.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            (e1, e2) -> e1,
                            LinkedHashMap::new
                    ));

            System.out.println("\nAll .java files in descending order of size:");
            for (Map.Entry<String, Long> entry : sortedMap.entrySet()) {
                System.out.println(entry.getKey() + " (" + entry.getValue() + " bytes)");
            }

        } else {
            System.out.println("Directory does not exist.");
        }
    }
}