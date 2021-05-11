package ru.job4j.pooh;

import static ru.job4j.pooh.Status.STATUS_OK;

public class Resp {
    private final String text;
    private final int status;
    private final Integer id;
    private final String name;

    public Resp(String text, int status, Integer id, String name) {
        this.status = status;
        if (this.status == STATUS_OK.getCode()) {
            this.text = "\r\n" + text.split(" ")[7].split("\r\n")[2];
        } else {
            this.text = "\r\n404. Queue is empty";
        }
        this.id = id;
        this.name = name;
    }

    public static Resp of(Req req, int status) {
        return new Resp(req.text(), status, req.id(), req.name());
    }

    public String text() {
        return text;
    }

    public int status() {
        return status;
    }

    public Integer id() {
        return id;
    }

    public String name() {
        return name;
    }
}