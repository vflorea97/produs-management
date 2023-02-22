package ro.mycode.produsmanagement.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ro.mycode.produsmanagement.ProdusManagementApplication;
import ro.mycode.produsmanagement.model.Produs;

import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ProdusManagementApplication.class)
@Transactional
class ProdusRepositoryTest {

    @Autowired
    ProdusRepository produsRepository;

    @BeforeEach
    public void clean(){
        produsRepository.deleteAll();
    }

    @Test
    void getProdusByCategory() {
        Produs produs = Produs.builder().category("Gradina").createDate("4/4/2018").description("Lalele rosii").nume("Lalele").price(30.99).sku("1044973").stock(92).weight(1.2).build();
        Produs produs2 = Produs.builder().category("Gradina").createDate("11/3/2013").description("Lalele albe").nume("Lalele").price(30.99).sku("4279394").stock(27).weight(1.2).build();
        Produs produs3 = Produs.builder().category("Gradina").createDate("2/11/2003").description("Lalele galbene").nume("Lalele").price(30.99).sku("8752865").stock(32).weight(1.2).build();
        Produs produs4 = Produs.builder().category("Bucatarie").createDate("8/24/2004").description("Cutit cu maner metalic").nume("Cutit").price(56.99).sku("6847148").stock(26).weight(0.5).build();
        Produs produs5 = Produs.builder().category("Bucatarie").createDate("9/10/2021").description("Cutit de unt").nume("Cutit").price(21.99).sku("3549135").stock(53).weight(0.3).build();
        Produs produs6 = Produs.builder().category("Electrocasnice-Mari").createDate("9/30/2021").description("Uscator rufe A+++").nume("Uscator rufe").price(1599.99).sku("8554122").stock(91).weight(20.3).build();
        Produs produs7 = Produs.builder().category("Electrocasnice-Mici").createDate("10/4/2018").description("Expresor cafea cu capsule").nume("Expresor cafea").price(219.99).sku("9263772").stock(41).weight(2.2).build();
        Produs produs8 = Produs.builder().category("Baie").createDate("10/2/2006").description("Sport lumina rece").nume("Spot").price(35.99).sku("3530712").stock(80).weight(0.2).build();
        Produs produs9 = Produs.builder().category("Electrocasnice-Mici").createDate("12/3/2017").description("Aspirator fara sac").nume("Aspirator").price(319.99).sku("3173881").stock(73).weight(4.1).build();

        produsRepository.saveAndFlush(produs);
        produsRepository.saveAndFlush(produs2);
        produsRepository.saveAndFlush(produs3);
        produsRepository.saveAndFlush(produs4);
        produsRepository.saveAndFlush(produs5);
        produsRepository.saveAndFlush(produs6);
        produsRepository.saveAndFlush(produs7);
        produsRepository.saveAndFlush(produs8);
        produsRepository.saveAndFlush(produs9);

        List<Produs> produse = produsRepository.getProdusByCategory("Gradina").get();

        assertEquals(3,produse.size());
       

    }

    @Test
    void getCountProdGroupByCategory() {
        Produs produs = Produs.builder().category("Gradina").createDate("4/4/2018").description("Lalele rosii").nume("Lalele").price(30.99).sku("1044973").stock(92).weight(1.2).build();
        Produs produs2 = Produs.builder().category("Gradina").createDate("11/3/2013").description("Lalele albe").nume("Lalele").price(30.99).sku("4279394").stock(27).weight(1.2).build();
        Produs produs3 = Produs.builder().category("Gradina").createDate("2/11/2003").description("Lalele galbene").nume("Lalele").price(30.99).sku("8752865").stock(32).weight(1.2).build();
        Produs produs4 = Produs.builder().category("Bucatarie").createDate("8/24/2004").description("Cutit cu maner metalic").nume("Cutit").price(56.99).sku("6847148").stock(26).weight(0.5).build();
        Produs produs5 = Produs.builder().category("Bucatarie").createDate("9/10/2021").description("Cutit de unt").nume("Cutit").price(21.99).sku("3549135").stock(53).weight(0.3).build();
        Produs produs6 = Produs.builder().category("Electrocasnice-Mari").createDate("9/30/2021").description("Uscator rufe A+++").nume("Uscator rufe").price(1599.99).sku("8554122").stock(91).weight(20.3).build();
        Produs produs7 = Produs.builder().category("Electrocasnice-Mici").createDate("10/4/2018").description("Expresor cafea cu capsule").nume("Expresor cafea").price(219.99).sku("9263772").stock(41).weight(2.2).build();
        Produs produs8 = Produs.builder().category("Baie").createDate("10/2/2006").description("Sport lumina rece").nume("Spot").price(35.99).sku("3530712").stock(80).weight(0.2).build();
        Produs produs9 = Produs.builder().category("Electrocasnice-Mici").createDate("12/3/2017").description("Aspirator fara sac").nume("Aspirator").price(319.99).sku("3173881").stock(73).weight(4.1).build();

        produsRepository.saveAndFlush(produs);
        produsRepository.saveAndFlush(produs2);
        produsRepository.saveAndFlush(produs3);
        produsRepository.saveAndFlush(produs4);
        produsRepository.saveAndFlush(produs5);
        produsRepository.saveAndFlush(produs6);
        produsRepository.saveAndFlush(produs7);
        produsRepository.saveAndFlush(produs8);
        produsRepository.saveAndFlush(produs9);

        String [] desc = produsRepository.getCountProdGroupByCategory("Gradina");
        assertEquals("3,Gradina",desc[0]);
    }

    @Test
    void getProdusByCategoryNameAsc() {
        Produs produs = Produs.builder().category("Gradina").createDate("4/4/2018").description("Lalele rosii").nume("Lalele").price(30.99).sku("1044973").stock(92).weight(1.2).build();
        Produs produs2 = Produs.builder().category("Gradina").createDate("11/3/2013").description("Furtun alb").nume("Furtun").price(30.99).sku("4279394").stock(27).weight(1.2).build();
        Produs produs3 = Produs.builder().category("Gradina").createDate("2/11/2003").description("Lopata metal").nume("Lopata").price(30.99).sku("8752865").stock(32).weight(1.2).build();
        Produs produs4 = Produs.builder().category("Bucatarie").createDate("8/24/2004").description("Cutit cu maner metalic").nume("Cutit").price(56.99).sku("6847148").stock(26).weight(0.5).build();
        Produs produs5 = Produs.builder().category("Bucatarie").createDate("9/10/2021").description("Cutit de unt").nume("Cutit").price(21.99).sku("3549135").stock(53).weight(0.3).build();
        Produs produs6 = Produs.builder().category("Electrocasnice-Mari").createDate("9/30/2021").description("Uscator rufe A+++").nume("Uscator rufe").price(1599.99).sku("8554122").stock(91).weight(20.3).build();
        Produs produs7 = Produs.builder().category("Electrocasnice-Mici").createDate("10/4/2018").description("Expresor cafea cu capsule").nume("Expresor cafea").price(219.99).sku("9263772").stock(41).weight(2.2).build();
        Produs produs8 = Produs.builder().category("Baie").createDate("10/2/2006").description("Sport lumina rece").nume("Spot").price(35.99).sku("3530712").stock(80).weight(0.2).build();
        Produs produs9 = Produs.builder().category("Electrocasnice-Mici").createDate("12/3/2017").description("Aspirator fara sac").nume("Aspirator").price(319.99).sku("3173881").stock(73).weight(4.1).build();

        produsRepository.saveAndFlush(produs);
        produsRepository.saveAndFlush(produs2);
        produsRepository.saveAndFlush(produs3);
        produsRepository.saveAndFlush(produs4);
        produsRepository.saveAndFlush(produs5);
        produsRepository.saveAndFlush(produs6);
        produsRepository.saveAndFlush(produs7);
        produsRepository.saveAndFlush(produs8);
        produsRepository.saveAndFlush(produs9);

        List<Produs> produse = produsRepository.getProdusByCategoryNameAsc("Gradina").get();

        assertEquals(3,produse.size());
        assertEquals(produs2,produse.get(0));
    }

    @Test
    void getProdusPriceAndStockByCategory() {
        Produs produs = Produs.builder().category("Gradina").createDate("4/4/2018").description("Lalele rosii").nume("Lalele").price(30.99).sku("1044973").stock(92).weight(1.2).build();
        Produs produs2 = Produs.builder().category("Gradina").createDate("11/3/2013").description("Lalele albe").nume("Lalele").price(30.99).sku("4279394").stock(27).weight(1.2).build();
        Produs produs3 = Produs.builder().category("Gradina").createDate("2/11/2003").description("Lalele galbene").nume("Lalele").price(30.99).sku("8752865").stock(32).weight(1.2).build();
        Produs produs4 = Produs.builder().category("Bucatarie").createDate("8/24/2004").description("Cutit cu maner metalic").nume("Cutit").price(56.99).sku("6847148").stock(26).weight(0.5).build();
        Produs produs5 = Produs.builder().category("Bucatarie").createDate("9/10/2021").description("Cutit de unt").nume("Cutit").price(21.99).sku("3549135").stock(53).weight(0.3).build();
        Produs produs6 = Produs.builder().category("Electrocasnice-Mari").createDate("9/30/2021").description("Uscator rufe A+++").nume("Uscator rufe").price(1599.99).sku("8554122").stock(91).weight(20.3).build();
        Produs produs7 = Produs.builder().category("Electrocasnice-Mici").createDate("10/4/2018").description("Expresor cafea cu capsule").nume("Expresor cafea").price(219.99).sku("9263772").stock(41).weight(2.2).build();
        Produs produs8 = Produs.builder().category("Baie").createDate("10/2/2006").description("Sport lumina rece").nume("Spot").price(35.99).sku("3530712").stock(80).weight(0.2).build();
        Produs produs9 = Produs.builder().category("Electrocasnice-Mici").createDate("12/3/2017").description("Aspirator fara sac").nume("Aspirator").price(319.99).sku("3173881").stock(73).weight(4.1).build();

        produsRepository.saveAndFlush(produs);
        produsRepository.saveAndFlush(produs2);
        produsRepository.saveAndFlush(produs3);
        produsRepository.saveAndFlush(produs4);
        produsRepository.saveAndFlush(produs5);
        produsRepository.saveAndFlush(produs6);
        produsRepository.saveAndFlush(produs7);
        produsRepository.saveAndFlush(produs8);
        produsRepository.saveAndFlush(produs9);

        String [] desc = produsRepository.getProdusPriceAndStockByCategory("Gradina");

        assertEquals(3,desc.length);
        assertEquals("Lalele,30.99,92",desc[0]);
    }

    @Test
    void getProdusByPriceRange() {
        Produs produs = Produs.builder().category("Gradina").createDate("4/4/2018").description("Lalele rosii").nume("Lalele").price(30.99).sku("1044973").stock(92).weight(1.2).build();
        Produs produs2 = Produs.builder().category("Gradina").createDate("11/3/2013").description("Lalele albe").nume("Lalele").price(30.99).sku("4279394").stock(27).weight(1.2).build();
        Produs produs3 = Produs.builder().category("Gradina").createDate("2/11/2003").description("Lalele galbene").nume("Lalele").price(30.99).sku("8752865").stock(32).weight(1.2).build();
        Produs produs4 = Produs.builder().category("Bucatarie").createDate("8/24/2004").description("Cutit cu maner metalic").nume("Cutit").price(56.99).sku("6847148").stock(26).weight(0.5).build();
        Produs produs5 = Produs.builder().category("Bucatarie").createDate("9/10/2021").description("Cutit de unt").nume("Cutit").price(20.99).sku("3549135").stock(53).weight(0.3).build();
        Produs produs6 = Produs.builder().category("Electrocasnice-Mari").createDate("9/30/2021").description("Uscator rufe A+++").nume("Uscator rufe").price(1599.99).sku("8554122").stock(91).weight(20.3).build();
        Produs produs7 = Produs.builder().category("Electrocasnice-Mici").createDate("10/4/2018").description("Expresor cafea cu capsule").nume("Expresor cafea").price(219.99).sku("9263772").stock(41).weight(2.2).build();
        Produs produs8 = Produs.builder().category("Baie").createDate("10/2/2006").description("Sport lumina rece").nume("Spot").price(35.99).sku("3530712").stock(80).weight(0.2).build();
        Produs produs9 = Produs.builder().category("Electrocasnice-Mici").createDate("12/3/2017").description("Aspirator fara sac").nume("Aspirator").price(319.99).sku("3173881").stock(73).weight(4.1).build();

        produsRepository.saveAndFlush(produs);
        produsRepository.saveAndFlush(produs2);
        produsRepository.saveAndFlush(produs3);
        produsRepository.saveAndFlush(produs4);
        produsRepository.saveAndFlush(produs5);
        produsRepository.saveAndFlush(produs6);
        produsRepository.saveAndFlush(produs7);
        produsRepository.saveAndFlush(produs8);
        produsRepository.saveAndFlush(produs9);

        List<Produs> produse = produsRepository.getProdusByPriceRange(30.00,100.00).get();

        assertEquals(5,produse.size());

    }

    @Test
    void findProdusBySku() {
        Produs produs = Produs.builder().category("Gradina").createDate("4/4/2018").description("Lalele rosii").nume("Lalele").price(30.99).sku("1044973").stock(92).weight(1.2).build();
        Produs produs2 = Produs.builder().category("Gradina").createDate("11/3/2013").description("Lalele albe").nume("Lalele").price(30.99).sku("4279394").stock(27).weight(1.2).build();
        Produs produs3 = Produs.builder().category("Gradina").createDate("2/11/2003").description("Lalele galbene").nume("Lalele").price(30.99).sku("8752865").stock(32).weight(1.2).build();
        Produs produs4 = Produs.builder().category("Bucatarie").createDate("8/24/2004").description("Cutit cu maner metalic").nume("Cutit").price(56.99).sku("6847148").stock(26).weight(0.5).build();
        Produs produs5 = Produs.builder().category("Bucatarie").createDate("9/10/2021").description("Cutit de unt").nume("Cutit").price(20.99).sku("3549135").stock(53).weight(0.3).build();
        Produs produs6 = Produs.builder().category("Electrocasnice-Mari").createDate("9/30/2021").description("Uscator rufe A+++").nume("Uscator rufe").price(1599.99).sku("8554122").stock(91).weight(20.3).build();
        Produs produs7 = Produs.builder().category("Electrocasnice-Mici").createDate("10/4/2018").description("Expresor cafea cu capsule").nume("Expresor cafea").price(219.99).sku("9263772").stock(41).weight(2.2).build();
        Produs produs8 = Produs.builder().category("Baie").createDate("10/2/2006").description("Sport lumina rece").nume("Spot").price(35.99).sku("3530712").stock(80).weight(0.2).build();
        Produs produs9 = Produs.builder().category("Electrocasnice-Mici").createDate("12/3/2017").description("Aspirator fara sac").nume("Aspirator").price(319.99).sku("3173881").stock(73).weight(4.1).build();

        produsRepository.saveAndFlush(produs);
        produsRepository.saveAndFlush(produs2);
        produsRepository.saveAndFlush(produs3);
        produsRepository.saveAndFlush(produs4);
        produsRepository.saveAndFlush(produs5);
        produsRepository.saveAndFlush(produs6);
        produsRepository.saveAndFlush(produs7);
        produsRepository.saveAndFlush(produs8);
        produsRepository.saveAndFlush(produs9);

        Produs prod = produsRepository.findProdusBySku("4279394").get();
        Produs prod2 = produsRepository.findProdusBySku("3549135").get();

        assertEquals(produs2,prod);
        assertEquals(produs5,prod2);
    }

    @Test
    void removeBySku() {
        Produs produs = Produs.builder().category("Gradina").createDate("4/4/2018").description("Lalele rosii").nume("Lalele").price(30.99).sku("1044973").stock(92).weight(1.2).build();

        produsRepository.saveAndFlush(produs);

        produsRepository.removeBySku("1044973");
        List<Produs> produse = produsRepository.getProdusByCategory("Gradina").get();


        assertEquals(false,produse.contains(produs));

    }

    @Test
    void updateProductPrice() {
        Produs produs = Produs.builder().category("Gradina").createDate("4/4/2018").description("Lalele rosii").nume("Lalele").price(30.99).sku("1044973").stock(92).weight(1.2).build();

        produsRepository.saveAndFlush(produs);

        produsRepository.updateProductPrice(21.99,"1044973");

        assertNotEquals(Optional.empty(),produsRepository.findProdusBySkuAndPrice("1044973",21.99));
    }

    @Test
    void updateProductStock() {
        Produs produs = Produs.builder().category("Gradina").createDate("4/4/2018").description("Lalele rosii").nume("Lalele").price(30.99).sku("1044973").stock(92).weight(1.2).build();

        produsRepository.saveAndFlush(produs);

        produsRepository.updateProductStock(2,"1044973");

        assertNotEquals(Optional.empty(),produsRepository.findProdusBySkuAndStock("1044973",2));
    }

    @Test
    void updateProductDescription() {
        Produs produs = Produs.builder().category("Gradina").createDate("4/4/2018").description("Lalele rosii").nume("Lalele").price(30.99).sku("1044973").stock(92).weight(1.2).build();

        produsRepository.saveAndFlush(produs);

        produsRepository.updateProductDescription("Lalele mov","1044973");

        assertNotEquals(Optional.empty(), produsRepository.findProdusBySkuAndDescription("1044973","Lalele mov"));
    }

    @Test
    void updateProductWeight() {
        Produs produs = Produs.builder().category("Gradina").createDate("4/4/2018").description("Lalele rosii").nume("Lalele").price(30.99).sku("1044973").stock(92).weight(1.2).build();

        produsRepository.saveAndFlush(produs);

        produsRepository.updateProductWeight(2.3,"1044973");

        assertNotEquals(Optional.empty(), produsRepository.findProdusBySkuAndWeight("1044973",2.3));
    }

}