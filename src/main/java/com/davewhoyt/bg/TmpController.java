package com.davewhoyt.bg;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by david on 8/9/16.
 */
@Controller
public class TmpController {

    @RequestMapping("/.well-known/acme-challenge/3liqbcC4lbLYgqZrKtrcvoqFf6OwAQgYPnRx7hkio60")
    public @ResponseBody String challenge() {
        return "3liqbcC4lbLYgqZrKtrcvoqFf6OwAQgYPnRx7hkio60.fBMzJbBfpan_dUJaa7YIElvqBmoaAzzaOy6rweLYN1Q";
    }
}
