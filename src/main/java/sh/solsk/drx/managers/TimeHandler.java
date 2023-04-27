package sh.solsk.drx.managers;


import java.sql.Timestamp;

public class TimeHandler {

    public Long getCurrentMillis() {
        return new Timestamp(System.currentTimeMillis()).getTime();
    }


}
