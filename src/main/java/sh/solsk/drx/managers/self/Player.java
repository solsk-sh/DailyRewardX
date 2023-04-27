package sh.solsk.drx.managers.self;

import java.sql.Timestamp;
import java.util.UUID;

public class Player {

    private int streakLength;
    private boolean hasMooved;
    private Timestamp lastLoginTimestamp, lastClaimedTimestamp;

    public Player(UUID playerId) {

    }

}
