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

    @RequestMapping("Cx9VPYfoEQSG23ufFOCJcYyDuLQdnedMOeDr69v4ZEg")
    public @ResponseBody String challenge() {
        return "Cx9VPYfoEQSG23ufFOCJcYyDuLQdnedMOeDr69v4ZEg.bBev5h0NloRfB0tSU-ylDky26ulmSLkXHOEhPI9MTLc";
    }


    @RequestMapping("s3jUloJmFiOkMm4wKHJZgMmNzwzxprAhx-BKTZ-NjWI")
    public @ResponseBody String challenge2() {
        return "s3jUloJmFiOkMm4wKHJZgMmNzwzxprAhx-BKTZ-NjWI.bBev5h0NloRfB0tSU-ylDky26ulmSLkXHOEhPI9MTLc";
    }
}
