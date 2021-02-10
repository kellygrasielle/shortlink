package com.bankamerica.controller;


import com.bankamerica.model.ShortLink;
import com.bankamerica.service.ShortLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.net.URI;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Controller
public class LinkController {

    @Autowired
    ShortLinkService service;

    @RequestMapping("/shortlink/alias")
    public String alias(Model model, @ModelAttribute ShortLink link){
        if(link.equals("")){
            return "redirect:/link";
        }
        ShortLink shortLink = new ShortLink();
        shortLink.setAlias(service.convertToShortUrl(link.getUrl()));

        model.addAttribute("link", link);
        model.addAttribute("alias_response", shortLink.getAlias());
        return "shortlink";

    }


    @RequestMapping(value="/shortlink/url", method = RequestMethod.GET)
    public String localRedirect( Model model, @ModelAttribute ShortLink link)  {

        String url = service.getOriginalUrl(link.getAlias());
        model.addAttribute("url_response", url);
        model.addAttribute("link", new ShortLink());
        return "longlink";

    }

    @RequestMapping(value ="/shortlink", method = RequestMethod.GET )
    public String shortlink(Model model){

        model.addAttribute("link", new ShortLink());
        return "shortlink";
    }

    @RequestMapping(value ="/longlink", method = RequestMethod.GET )
    public String redirect(Model model){
        model.addAttribute("link", new ShortLink());
        return "longlink";
    }


    @RequestMapping(value ="/" )
    public String home() {
        return "redirect:/shortlink";
    }


    @RequestMapping(value="/{alias}", method = RequestMethod.GET)
    public ModelAndView method(@PathVariable("alias") String alias) {
        String url = service.getOriginalUrl(alias);
        return new ModelAndView("redirect:" + url);
    }


}
