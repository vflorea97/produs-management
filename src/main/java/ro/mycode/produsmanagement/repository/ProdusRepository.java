package ro.mycode.produsmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.mycode.produsmanagement.model.Produs;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProdusRepository extends JpaRepository<Produs, Long> {

    @Query("select p from Produs p where p.category = ?1")
    Optional<List<Produs>> getProdusByCategory(String category);

    @Query("select count(p.nume), p.category from Produs p where p.category = ?1")
    String [] getCountProdGroupByCategory(String category);

    @Query("select p from Produs p where p.category = ?1 order by p.nume")
    Optional<List<Produs>> getProdusByCategoryNameAsc(String category);

    @Query("select p.nume, p.price, p.stock from Produs p where p.category = ?1")
    String [] getProdusPriceAndStockByCategory(String category);

    @Query("select p from Produs p where p.price between ?1 and ?2")
    Optional<List<Produs>> getProdusByPriceRange(double minPrice, double maxPrice);

    Optional<Produs> findProdusBySku(int sku);

    @Transactional
    void removeBySku(int sku);

    @Transactional
    @Modifying
    @Query("update Produs p set p.price = ?1 where p.sku = ?2")
    void updateProductPrice(double price, int sku);

    @Transactional
    @Modifying
    @Query("update Produs p set p.stock = ?1 where p.sku = ?2")
    void updateProductStock(int stock, int sku);

    @Transactional
    @Modifying
    @Query("update Produs p set p.description = ?1 where p.sku = ?2")
    void updateProductDescription(String description, int sku);

    @Transactional
    @Modifying
    @Query("update Produs p set p.weight = ?1 where p.sku = ?2")
    void updateProductWeight(double weight, int sku);

    Optional<Produs> findProdusBySkuAndPrice(int sku, double price);
    Optional<Produs> findProdusBySkuAndStock(int sku, int stock);
    Optional<Produs> findProdusBySkuAndDescription(int sku, String description);
    Optional<Produs> findProdusBySkuAndWeight(int sku, double weight);


}
