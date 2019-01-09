package cz.learning.orm.jpa_learning.service;

import cz.learning.orm.jpa_learning.entities.Order;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class MessageService {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Order> getAllOrders() {
        return entityManager.createQuery("select o from Order o", Order.class).getResultList();
    }

    public Order addOrder(Order order) {
        entityManager.persist(order);
        return order;
    }
}
