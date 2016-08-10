package com.davewhoyt.bg;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by david on 8/9/16.
 */
@Controller
public class TmpController {

    @RequestMapping(".well-known/acme-challenge/BmuJxaS5nRXGSPNFDnDez2VkE5qU3MD7NiwMxiO5Nys")
    public @ResponseBody String challenge() {
        return "BmuJxaS5nRXGSPNFDnDez2VkE5qU3MD7NiwMxiO5Nys.fBMzJbBfpan_dUJaa7YIElvqBmoaAzzaOy6rweLYN1Q";
    }
}
