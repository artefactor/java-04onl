package by.teachmeskills.persistence.dao.impl.product;

import by.teachmeskills.persistence.dao.exception.DAOException;
import by.teachmeskills.persistence.dao.impl.ORMAbstractDAO;
import by.teachmeskills.persistence.dao.product.ProductDAO;
import by.teachmeskills.persistence.dao.query.product.ProductJPQLQueries;
import by.teachmeskills.persistence.entity.product.ProductEntity;
import java.util.Optional;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

@Repository
public class ProductOrmDAO extends ORMAbstractDAO<ProductEntity> implements ProductDAO {

    @Override
    public Optional<ProductEntity> getByTitle(String title) {
        try {
            TypedQuery<ProductEntity> query = entityManager.createNamedQuery(ProductJPQLQueries.GET_BY_TITLE_NAME, ProductEntity.class);
            query.setParameter("title", title);
            return Optional.ofNullable(query.getSingleResult());
        } catch (Exception e) {
            logger.error("Unable to read product entity: {}", e.getMessage(), e);
            throw new DAOException("Unable to get product by title", e);
        }
    }

    @Override
    protected Class<ProductEntity> getEntityClass() {
        return ProductEntity.class;
    }
}
