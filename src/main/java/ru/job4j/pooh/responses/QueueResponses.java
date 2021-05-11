package ru.job4j.pooh.responses;

import ru.job4j.pooh.Req;
import ru.job4j.pooh.Resp;
import ru.job4j.pooh.ResponseHolder;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

import static ru.job4j.pooh.Status.STATUS_OK;

public class QueueResponses implements ResponseHolder {
    private final ConcurrentHashMap<String, ConcurrentLinkedQueue<Resp>> queue = new ConcurrentHashMap<>();

    @Override
    public void add(Req req, Resp resp) {
        queue.putIfAbsent(req.name(), new ConcurrentLinkedQueue<>());
        resp = new Resp(req.text(), STATUS_OK.getCode(), req.id(), req.name());
        queue.get(req.name()).add(resp);
    }

    @Override
    public boolean contains(Req req) {
        return !(queue.get(req.name()) == null) && queue.get(req.name()).size() != 0;
    }

    @Override
    public Resp poll(Req req) {
        return queue.get(req.name()).poll();
    }
}
