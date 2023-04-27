package sh.solsk.drx.managers.files;

public enum FileType {

    CONFIG("config.yml"),
    MESSAGES("messages.yml"),
    BONUS("rewards.yml");

    private final String fileName;

    FileType(String fileName) {
        this.fileName = fileName;
    }

}
