package kr.withever.humanlibrary.api.controller;

import kr.withever.humanlibrary.domain.humanbook.Humanbook;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by youngjinkim on 2017. 3. 6..
 */

@RestController
@RequestMapping(value = "/api/humanbooks")
public class HumanbookController {

    @RequestMapping(value = "/{hbId}", method = RequestMethod.GET)
    public Humanbook retrieveHumanbook(@PathVariable(value = "hbId") Long hbId) {
        Humanbook humanbook = new Humanbook();
        return humanbook;
    }
}
