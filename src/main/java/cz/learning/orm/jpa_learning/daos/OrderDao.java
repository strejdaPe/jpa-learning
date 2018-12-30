package cz.learning.orm.jpa_learning.daos;

import cz.learning.orm.jpa_learning.entities.Order;

import javax.annotation.Resource;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.*;
import java.util.List;

@Named
public class OrderDao {
    @PersistenceContext()
    EntityManager em;

    @Resource
    UserTransaction tx;

    public List<Order> getAllOrders() {
        var orders = em.createQuery("select o from Order o", Order.class)
            .getResultList();
        return orders;
    }

    public void createOrder(Order order) {
        try {
            tx.begin();
            em.persist(order);
            tx.commit();
        } catch (NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException e) {
            e.printStackTrace();
        }
    }
}
