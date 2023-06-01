package ra.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ra.model.entity.Catalog;
@Repository
public interface ICatalogRepository extends PagingAndSortingRepository<Catalog,Long> {
}
