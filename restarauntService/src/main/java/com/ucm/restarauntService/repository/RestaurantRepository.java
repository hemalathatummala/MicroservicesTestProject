package com.ucm.restarauntService.repository;

import java.util.Collection;

public interface RestaurantRepository<Restaurant, String> extends Repository<Restaurant, String> {

    /**
     *
     * @param name
     * @return
     */
    boolean containsName(String name);

    /**
     *
     * @param name
     * @return
     * @throws Exception
     */
    public Collection<Restaurant> findByName(String name) throws Exception;
}
