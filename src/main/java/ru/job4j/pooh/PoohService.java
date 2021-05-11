package ru.job4j.pooh;

import static ru.job4j.pooh.Status.STATUS_NOT_FOUND;
import static ru.job4j.pooh.Status.STATUS_OK;

public class PoohService implements Service {
    private final ResponseHolder responses;

    public PoohService(ResponseHolder responses) {
        this.responses = responses;
    }

    @Override
    public Resp process(Req req) {
        Resp resp;
        if (req.method().equals("GET")) {
            if (responses.contains(req)) {
                resp = responses.poll(req);
            } else {
                resp = Resp.of(req, STATUS_NOT_FOUND.getCode());
            }
        } else {
            resp = Resp.of(req, STATUS_OK.getCode());
            responses.add(req, resp);
        }
        return resp;
    }
}
