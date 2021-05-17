package ru.job4j.pooh;

public interface ResponseHolder {
    void add(Req req, Resp resp);

    Resp poll(Req req);
}
