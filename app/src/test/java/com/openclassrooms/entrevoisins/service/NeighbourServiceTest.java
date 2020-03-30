package com.openclassrooms.entrevoisins.service;

import android.accounts.NetworkErrorException;

import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Unit test on Neighbour service
 */
@RunWith(JUnit4.class)
public class NeighbourServiceTest {

    private NeighbourApiService service;

    @Before
    public void setup() {
        service = DI.getNewInstanceApiService();
    }

    @Test
    public void getNeighboursWithSuccess() {
        List<Neighbour> neighbours = service.getNeighbours();
        List<Neighbour> expectedNeighbours = DummyNeighbourGenerator.DUMMY_NEIGHBOURS;
        assertThat(neighbours, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedNeighbours.toArray()));
    }

    @Test
    public void deleteNeighbourWithSuccess() {
        Neighbour neighbourToDelete = service.getNeighbours().get(0);
        service.deleteNeighbour(neighbourToDelete);
        assertFalse(service.getNeighbours().contains(neighbourToDelete));
    }


    @Test
    public void getFavoriteNeighboursWithSuccess() {
        List<Neighbour> expectedFavoritesNeighbours = service.getFavoritesNeighbours();
        assertTrue(expectedFavoritesNeighbours.isEmpty());
    }

    @Test
    public void addFavoriteNeighboursWithSuccess() {
        Neighbour neighbour = service.getNeighbours().get(0);
        service.addFavoriteNeighbour(neighbour);
        assertFalse(service.getFavoritesNeighbours().isEmpty());
    }

//    @Test
//    public void getNeighbourByPosition(){
//        //TODO
//    }

    @Test
    public void deleteFavoriteNeighbourWithSuccess() {
        Neighbour neighbour = service.getNeighbours().get(0);
        service.addFavoriteNeighbour(neighbour);
        assertFalse(service.getFavoritesNeighbours().isEmpty());
        service.deleteFavoriteNeighbour(neighbour);
        assertTrue(service.getFavoritesNeighbours().isEmpty());
    }
}
