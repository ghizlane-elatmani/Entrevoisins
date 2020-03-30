package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;


/**
 * Neighbour API client
 */
public interface NeighbourApiService {

    /**
     * Get all my Neighbours
     * @return {@link List}
     */
    List<Neighbour> getNeighbours();

    /**
     * Get all favorites neighbours
     * @return {@Link List}
     */
    List<Neighbour> getFavoritesNeighbours();


    /**
     * Add a favorite neighbour
     * @param neighbour
     */
    void addFavoriteNeighbour(Neighbour neighbour);

    /**
     * Deletes a neighbour
     * @param neighbour
     */
    void deleteNeighbour(Neighbour neighbour);


    /**
     * Deletes a favorite neighbour
     * @param neighbour
     */
    void deleteFavoriteNeighbour(Neighbour neighbour);

    /**
     * Create a neighbour
     * @param neighbour
     */
    void createNeighbour(Neighbour neighbour);

    /**
     * return neighbour by position
     * @param position
     */
    Neighbour getNeighbourByPosition(int position);

    /**
     * return favorite neighbour by position
     * @param position
     */
    Neighbour getFavoriteNeighbourByPosition(int position);
}
