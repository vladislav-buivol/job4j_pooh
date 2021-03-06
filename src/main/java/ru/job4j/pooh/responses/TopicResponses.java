package ru.job4j.pooh.responses;

import ru.job4j.pooh.Req;
import ru.job4j.pooh.Resp;
import ru.job4j.pooh.ResponseHolder;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TopicResponses implements ResponseHolder {
    private final ConcurrentHashMap<String, ConcurrentHashMap<Integer, ConcurrentLinkedQueue<Resp>>> queue = new ConcurrentHashMap<>();

    public ConcurrentHashMap<String, ConcurrentHashMap<Integer, ConcurrentLinkedQueue<Resp>>> getQueue() {
        return queue;
    }

    @Override
    public void add(Req req, Resp resp) {
        queue.putIfAbsent(req.name(), new ConcurrentHashMap<>());
        queue.get(req.name()).putIfAbsent(req.id(), new ConcurrentLinkedQueue<>());
        ConcurrentLinkedQueue<Resp> responses = queue.get(req.name()).get(req.id());
        responses.offer(resp);
    }

    @Override
    public Resp poll(Req req) {
        if (queue.get(req.name()) != null && queue.get(req.name()).get(req.id()) != null) {
            return queue.get(req.name()).get(req.id()).poll();
        }
        return null;
    }
}