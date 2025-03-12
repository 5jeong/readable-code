package cleancode.mission.day7.io;

import cleancode.mission.day7.model.StudyCafeLockerPass;
import cleancode.mission.day7.model.StudyCafeLockerPasses;
import cleancode.mission.day7.model.StudyCafePass;
import cleancode.mission.day7.model.StudyCafePassType;
import cleancode.mission.day7.model.StudyCafePasses;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class StudyCafeFileHandler {
    private static final String STUDY_CAFE_PASS_FILE = "src/main/resources/cleancode/studycafe/pass-list.csv";
    private static final String LOCKER_PASS_FILE = "src/main/resources/cleancode/studycafe/locker.csv";

    public StudyCafePasses readStudyCafePasses() {
        return StudyCafePasses.of(readFile(STUDY_CAFE_PASS_FILE).stream()
                .map(this::parseStudyCafePass)
                .toList());
    }

    public StudyCafeLockerPasses readLockerPasses() {
        return StudyCafeLockerPasses.of(readFile(LOCKER_PASS_FILE).stream()
                .map(this::parseStudyCafeLockerPass)
                .toList());
    }

    private StudyCafePass parseStudyCafePass(String line) {
        String[] values = convertArrayFrom(line);

        StudyCafePassType studyCafePassType = StudyCafePassType.valueOf(values[0]);
        int duration = Integer.parseInt(values[1]);
        int price = Integer.parseInt(values[2]);
        double discountRate = Double.parseDouble(values[3]);

        return StudyCafePass.of(studyCafePassType, duration, price, discountRate);
    }

    private String[] convertArrayFrom(String line) {
        return line.split(",");
    }

    private StudyCafeLockerPass parseStudyCafeLockerPass(String line) {
        String[] values = convertArrayFrom(line);

        StudyCafePassType studyCafePassType = StudyCafePassType.valueOf(values[0]);
        int duration = Integer.parseInt(values[1]);
        int price = Integer.parseInt(values[2]);

        return StudyCafeLockerPass.of(studyCafePassType, duration, price);
    }

    private List<String> readFile(String path) {
        try {
            return Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            throw new RuntimeException("파일을 읽는데 실패했습니다.", e);
        }
    }

}
