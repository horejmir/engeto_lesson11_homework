package com.engeto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;

import java.util.List;
import java.util.logging.Logger;

public class GoodsMethodsImpl implements GoodsMethods {

    private final EntityManager entityManager = Persistence.createEntityManagerFactory("engetoEshop")
                                                            .createEntityManager();

    private static final Logger logger = Logger.getLogger(GoodsMethodsImpl.class.getName());

    @Override
    public Item loadItemById(Integer id) {
       return entityManager.find(Item.class, id);
    }

    @Override
    public void deleteAllOutOfStockItems() {
        entityManager.getTransaction().begin();
        int numberOfDeletedItems = entityManager.createQuery("DELETE FROM Item i WHERE i.numberInStock = :numberInStock ")
                .setParameter("numberInStock", 0).executeUpdate();
        entityManager.getTransaction().commit();

        if (numberOfDeletedItems > 0)
            logger.info("Deleted " + numberOfDeletedItems + " out of stock item(s).");
        else
            logger.info("No item(s) deleted: all items are in stock.");
    }

    @Override
    public List<Item> loadAllAvailableItems() {
        return entityManager.createQuery("SELECT i FROM Item i", Item.class).getResultList();
    }

    @Override
    public void saveItem(Item item) {
        if (item != null) {
            int numberOfRows = entityManager.createQuery("SELECT i FROM Item i WHERE i.serialNo = :serialNo ")
                                                .setParameter("serialNo", item.getSerialNo()).getResultList().size();

            if (numberOfRows == 0) {
                entityManager.getTransaction().begin();
                entityManager.persist(item);
                entityManager.getTransaction().commit();
                logger.info("Item id: " + item.getId() + " saved.");
            } else {
                logger.info("Item not saved: item with serialNo: " + item.getSerialNo() + " is already in database.");
            }
        } else
            logger.info("Item not saved: item is null.");
    }

    @Override
    public void updatePrice(Integer id, BigDecimal newPrice) {
        if (newPrice.compareTo(new BigDecimal(0)) > 0) {

            Item item = entityManager.find(Item.class, id);

            if (item != null) {
                entityManager.getTransaction().begin();
                item.setPrice(newPrice);
                entityManager.getTransaction().commit();
                logger.info("Item id: " + item.getId() + ", price updated to: " + item.getPrice());
            } else
                logger.info("Item's price not updated: item with id " + id + " does not exists.");
        }  else
            logger.info("Item's price not updated: new price is not valid.");
    }
}
