package cz.learning.orm.jpa_learning.rest;

import cz.learning.orm.jpa_learning.daos.OrderDao;
import cz.learning.orm.jpa_learning.entities.Order;
import cz.learning.orm.jpa_learning.service.MessageService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/orders")
public class OrderResource {
    @Inject
    private OrderDao dao;

    @Inject
    private MessageService messageService;

    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public List<Order> getAllOrders() {
        return dao.getAllOrders();
    }

    @GET
    @Path("/ejb")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public List<Order> getAllOrdersWithEjb() {
        return messageService.getAllOrders();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Order createOrder(Order order) {
        dao.createOrder(order);
        return order;
    }

    @POST
    @Path("/ejb")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Order createOrderWithEjb(Order order) {
        messageService.addOrder(order);
        return order;
    }
}
