package ru.job4j.pooh;

public class Req {
    private final String method;
    private final String mode;
    private final String text;
    private final Integer id;
    private final String name;

    private Req(String method, String mode, String text, Integer id, String name) {
        this.method = method;
        this.mode = mode;
        this.text = text;
        this.id = id;
        this.name = name;
    }

    public static Req of(String content) {
        String[] contentParts = content.split(" ");
        String method = contentParts[0];
        String[] messageInfo = contentParts[1].split("/");
        String mode = messageInfo[1];
        String name = "UNKNOWN";
        if (messageInfo.length > 2) {
            name = messageInfo[2];
        }
        Integer id = null;
        if (messageInfo.length > 3) {
            id = Integer.valueOf(messageInfo[3]);
        }
        return new Req(method, mode, content, id, name);
    }

    public String method() {
        return method;
    }

    public String mode() {
        return mode;
    }

    public String text() {
        return text;
    }

    public Integer id() {
        return id;
    }

    public String name() {
        return name;
    }
}