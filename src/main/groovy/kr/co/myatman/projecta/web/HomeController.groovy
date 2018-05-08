package kr.co.myatman.projecta.web

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
@RequestMapping
class HomeController {
    @RequestMapping(method = RequestMethod.GET)
    String home() {
        return 'redirect:/swagger-ui.html'
    }

    @RequestMapping(value = 'signin', method = RequestMethod.GET)
    String login() {
        return '/login'
    }
}
