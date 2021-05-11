package ru.job4j.pooh;

public class Status {
    private final String name;
    private final int code;

    public static final Status STATUS_OK = new Status("OK", 200);
    public static final Status STATUS_NOT_FOUND = new Status("NOT FOUND", 404);

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }

    public Status(String name, int code) {
        this.name = name;
        this.code = code;
    }
}
