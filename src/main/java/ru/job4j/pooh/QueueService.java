package ru.job4j.pooh;

import ru.job4j.pooh.responses.QueueResponses;

public class QueueService extends PoohService implements Service {
    public QueueService() {
        super(new QueueResponses());
    }

    @Override
    public Resp process(Req req) {
        return super.process(req);
    }
}