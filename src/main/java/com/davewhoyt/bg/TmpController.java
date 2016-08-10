package com.davewhoyt.bg;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by david on 8/9/16.
 */
@Controller
@RequestMapping("/.well-known/acme-challenge")
public class TmpController {

    @RequestMapping("yaXKfNt_v_IINBKRZBM2dAyydASCljLZKykrATZbJNk")
    public @ResponseBody String challenge() {
        return "yaXKfNt_v_IINBKRZBM2dAyydASCljLZKykrATZbJNk.fBMzJbBfpan_dUJaa7YIElvqBmoaAzzaOy6rweLYN1Q";
    }
    @RequestMapping("l7zk2r15iUW5oHuefBuO0A5fITnT3Rg2hfIr2MXYpBE")
    public @ResponseBody String challenge2() {
        return "l7zk2r15iUW5oHuefBuO0A5fITnT3Rg2hfIr2MXYpBE.fBMzJbBfpan_dUJaa7YIElvqBmoaAzzaOy6rweLYN1Q";
    }
}
