package ru.job4j.pooh;

import ru.job4j.pooh.responses.TopicResponses;

public class TopicService extends PoohService implements Service {
    public TopicService() {
        super(new TopicResponses());
    }

    @Override
    public Resp process(Req req) {
        return super.process(req);
    }
}