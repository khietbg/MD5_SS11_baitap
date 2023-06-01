package ra.formatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ra.model.entity.Catalog;
import ra.service.catalog.ICatalogService;

import javax.swing.*;
import java.util.Optional;

@Component
public class CatalogConverter implements Converter<String,Catalog> {
    private ICatalogService catalogService;

    @Autowired
    public CatalogConverter(ICatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @Override
    public Catalog convert(String soure) {
        Optional<Catalog> catalogOptional = catalogService.findById(Long.valueOf(soure));
        return catalogOptional.orElse(null);
    }

}
