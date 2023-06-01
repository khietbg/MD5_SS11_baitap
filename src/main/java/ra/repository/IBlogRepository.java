package ra.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ra.model.entity.Blog;
@Repository
public interface IBlogRepository extends PagingAndSortingRepository<Blog,Long> {
}
