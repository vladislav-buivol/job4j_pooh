package ru.job4j.pooh;

public interface ResponseHolder {
    void add(Req req, Resp resp);

    boolean contains(Req req);

    Resp poll(Req req);
}
