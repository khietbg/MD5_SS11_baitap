package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ra.model.entity.Catalog;
import ra.service.catalog.ICatalogService;

import java.util.List;
import java.util.Optional;

@Controller
public class CatalogController {
    @Autowired
    private ICatalogService catalogService;

    @GetMapping("/catalog")
    public String getListCatalog(Model model) {
        Iterable<Catalog> catalogs = catalogService.findAll();
        model.addAttribute("list", catalogs);
        return "catalog/list";
    }

    @GetMapping("/createCatalog")
    public ModelAndView createForm() {
     ModelAndView modelAndView = new ModelAndView("catalog/create");
     modelAndView.addObject("catalog",new Catalog());
        return modelAndView;
    }
    @PostMapping("/createCatalog")
    public String create(@ModelAttribute("catalog") Catalog catalog){
        catalogService.save(catalog);
        return "redirect:/catalog";
    }
    @GetMapping("/editCatalog/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {
        Optional<Catalog> customer = catalogService.findById(id);
        return new ModelAndView("catalog/edit", "catalog", customer.get());
    }

    @PostMapping("/updateCatalog")
    public String update(@ModelAttribute("catalog") Catalog c) {
        catalogService.save(c);
        return "redirect:/catalog";
    }

}
