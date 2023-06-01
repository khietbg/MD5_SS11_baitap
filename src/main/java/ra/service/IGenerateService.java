package ra.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Optional;

public interface IGenerateService<T, E> {
    Iterable<T> findAll();

    Optional<T> findById(E e);

    T save(T t);

    void delete(E e);
}
