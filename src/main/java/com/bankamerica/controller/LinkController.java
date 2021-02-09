package com.bankamerica.controller;


import com.bankamerica.model.ShortLink;
import com.bankamerica.service.ShortLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
        System.out.println("alias" + shortLink.getAlias());
        System.out.println("url" + shortLink.getUrl());

        model.addAttribute("link", link);
        model.addAttribute("alias_response", shortLink.getAlias());
        return "link";

    }


    @RequestMapping(value="/redirect/alias", method = RequestMethod.GET)
    public void localRedirect(HttpServletResponse response, Model model, @ModelAttribute ShortLink link) throws IOException {


        String url = service.getOriginalUrl(link.getAlias());
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(url);
        System.out.println("url" + url);
        response.sendRedirect(url);
    }

    @RequestMapping(value ="/shortlink", method = RequestMethod.GET )
    public String shortlink(Model model){

        model.addAttribute("link", new ShortLink());
        return "link";
    }

    @RequestMapping(value ="/redirect", method = RequestMethod.GET )
    public String redirect(Model model){

        model.addAttribute("link", new ShortLink());
        return "redirect";
    }


    @RequestMapping(value ="/" )
    public String home() {

        return "redirect:/shortlink";
    }


}
