package ra.service.catalog;

import ra.model.entity.Blog;
import ra.model.entity.Catalog;
import ra.service.IGenerateService;

public interface ICatalogService extends IGenerateService<Catalog,Long> {
    Iterable<Catalog> findAll();
}
