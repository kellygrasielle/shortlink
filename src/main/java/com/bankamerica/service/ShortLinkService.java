package com.bankamerica.service;

import com.bankamerica.model.Url;
import com.bankamerica.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShortLinkService {

    @Autowired
    BaseConversion conversion;
    @Autowired
    UrlRepository urlRepository;

    // Function to generate a short url from integer ID
    public String convertToShortUrl(String urlSr) {
        Url url = new Url();
        url.setLongUrl(urlSr);
        Url entity = urlRepository.save(url);

        return conversion.encode(entity.getId());
    }

    public String getOriginalUrl(String shortUrl) {
        long id = conversion.decode(shortUrl);
        Url entity = urlRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("There is no entity with " + shortUrl));


        return entity.getLongUrl();
    }

}
