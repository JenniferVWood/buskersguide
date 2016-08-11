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

    @RequestMapping("-omQsfC9a4gidM5gCj6RJw5bHoOp-wQxF9_Kc3nUcrs")
    public @ResponseBody String challenge() {
        return "";
    }


    @RequestMapping("s3jUloJmFiOkMm4wKHJZgMmNzwzxprAhx-BKTZ-NjWI")
    public @ResponseBody String challenge2() {
        return "-omQsfC9a4gidM5gCj6RJw5bHoOp-wQxF9_Kc3nUcrs.DsbFvnbSxYF93RLG34XfDd0rsqzn-Glc9zhuIEXj13c";
    }
}
