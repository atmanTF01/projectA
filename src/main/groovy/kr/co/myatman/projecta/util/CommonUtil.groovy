package kr.co.myatman.projecta.util

import org.springframework.stereotype.Component

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Component
class CommonUtil {
    static String getLocalDateTimeFormat(int formatType ){
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter FORM = DateTimeFormatter.ofPattern("");

        switch (formatType) {
            case 1:
                FORM = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                break;
            case 2:
                FORM = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                break;
            case 3:
                FORM = DateTimeFormatter.ofPattern("HH:mm:ss");
                break;
        }

        return ldt.format(FORM);
    }
}
