package site.taru.magic.mapper;

import org.springframework.stereotype.Repository;
import site.taru.magic.entity.News;

@Repository
public interface NewsMapper {
    void insert(News news);
}
