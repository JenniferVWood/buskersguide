package com.davewhoyt.bg;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by david on 8/9/16.
 */
@Controller
public class TmpController {

    @RequestMapping("/.well-known/acme-challenge/weOYyPd2Zvebu2mcEplsK-HgtkCkS0QHZN7uFu2q-x4")
    public @ResponseBody String challenge() {
        return "weOYyPd2Zvebu2mcEplsK-HgtkCkS0QHZN7uFu2q-x4.fBMzJbBfpan_dUJaa7YIElvqBmoaAzzaOy6rweLYN1Q";
    }
}
