package com.davewhoyt.bg;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by david on 8/9/16.
 */
@Controller
@RequestMapping("/.well-known/acme-challenge/")
public class TmpController {

    @RequestMapping("Ed082E_R9x-7E0HMg0s6BfifY1OGF9dJ5pRvwuXHnxg")
    public @ResponseBody String challenge() {
        return "Ed082E_R9x-7E0HMg0s6BfifY1OGF9dJ5pRvwuXHnxg.fBMzJbBfpan_dUJaa7YIElvqBmoaAzzaOy6rweLYN1Q";
    }


    @RequestMapping("")
    public @ResponseBody String challenge2() {
        return "";
    }
}
